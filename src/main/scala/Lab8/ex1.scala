package Lab8
import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
class masking extends Module {
    val width : Int = 8
    val io = IO (new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( Vec (4 , Bool () ) )
        val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
        val dataOut = Output ( Vec (4 , UInt ( width . W ) ) ) 
    })
    val mem = SyncReadMem(1024,Vec(4,UInt(width.W)))
    val wdata = Reg(Vec(4, UInt()))

    when(io.write === 1.B){
        val Msk_1 = Cat(io.mask(3),io.mask(2),io.mask(1),io.mask(0))
        when(Msk_1=== 0.U){
            
            wdata(0) := 0.U
            wdata(1) := 0.U
            wdata(2) := 0.U
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 1.U){
            
            wdata(0) := io.dataIn(0)
            wdata(1) := 0.U
            wdata(2) := 0.U
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 2.U){
            
            wdata(0) := 0.U
            wdata(1) := io.dataIn(1)
            wdata(2) := 0.U
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 3.U){
            
            wdata(0) := io.dataIn(0)
            wdata(1) := io.dataIn(1)
            wdata(2) := 0.U
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 4.U){
            
            wdata(0) := 0.U
            wdata(1) := 0.U
            wdata(2) := io.dataIn(2)
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 5.U){
           
            wdata(0) := io.dataIn(0)
            wdata(1) := 0.U
            wdata(2) := io.dataIn(2)
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 6.U){
            
            wdata(0) := 0.U
            wdata(1) := io.dataIn(1)
            wdata(2) := io.dataIn(2)
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 7.U){
            
            wdata(0) := io.dataIn(0)
            wdata(1) := io.dataIn(1)
            wdata(2) := io.dataIn(2)
            wdata(3) := 0.U
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 8.U){
            
            wdata(0) := 0.U
            wdata(1) := 0.U
            wdata(2) := 0.U
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 9.U){
            
            wdata(0) := io.dataIn(0)
            wdata(1) := 0.U
            wdata(2) := 0.U
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 10.U){
            
            wdata(0) := 0.U
            wdata(1) := io.dataIn(1)
            wdata(2) := 0.U
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 11.U){
            
            wdata(0) := 0.U
            wdata(1) := io.dataIn(1)
            wdata(2) := io.dataIn(2)
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 12.U){
            
            wdata(0) := 0.U
            wdata(1) := 0.U
            wdata(2) := io.dataIn(2)
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 13.U){
            
            wdata(0) := io.dataIn(0)
            wdata(1) := 0.U
            wdata(2) := io.dataIn(2)
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 14.U){
           
            wdata(0) := 0.U
            wdata(1) := io.dataIn(1)
            wdata(2) := io.dataIn(2)
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }.elsewhen(Msk_1 === 15.U){
            
            wdata(0) := io.dataIn(0)
            wdata(1) := io.dataIn(1)
            wdata(2) := io.dataIn(2)
            wdata(3) := io.dataIn(3)
            mem.write(io.addr, wdata)
        }

    }

    io.dataOut := mem.read(io.addr,io.enable)
}