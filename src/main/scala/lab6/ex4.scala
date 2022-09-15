package lab6
import chisel3 . _
import chisel3 . util . _
//import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }
class MyQueue extends Module {
// your code begin
val io = IO ( new Bundle {
val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready = Output , bits = Input
val out = Decoupled ( UInt (8. W ) ) // valid = Output , ready =Input , bits = Output
})
val Q1 = Queue(io.in,5)
    val Q2 = Queue(Q1,5)
    Q1.deq()
    
    Q2.ready := 0.B
    when(Q2.valid && io.out.ready){
        io.out.enq(Q2.deq())
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
    }

}

// your code end here
