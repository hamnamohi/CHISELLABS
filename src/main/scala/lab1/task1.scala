package lab1
import chisel3._
class data1 extends Module{
    val io=IO(new Bundle{
        val a1=Input(Bool())
        val b1=Input(Bool())
        val c1=Output(Bool())
    })
    io.c1:=io.a1 & io.b1
    
}