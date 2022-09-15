package Lab8

import chisel3._ 
import chisel3.util._ 

class bankedmemory extends Module {
    val io = IO(new Bundle {
        val enable = Input(Bool())
        val out = Output(Vec(2,UInt(16.W)))
        val rAddr = Input(UInt(10.W))
        val wrAddr = Input(UInt(10.W))
        val wrData = Input(Vec(2,UInt(16.W)))
        val wr_en = Input(Bool())
        val mask = Input(Vec(2, Bool()))
    })

    val memory = SyncReadMem(1024,Vec(2,UInt(16.W)))
    val wrDataReg = RegNext(io.wrData)
    val doForwarding = RegNext(io.wrAddr === io.rAddr && io.wr_en)
    val memData = memory.read(io.rAddr, io.enable)
    when(io.wr_en){
        memory.write(io.wrAddr, io.wrData, io.mask)
    }
    io.out(0) := 0.U
    io.out(1) := 0.U
when (doForwarding){
    io.out(0) := Mux(io.mask(0), wrDataReg(0), memData(0))
    io.out(1) := Mux(io.mask(1), wrDataReg(1), memData(1))}
}