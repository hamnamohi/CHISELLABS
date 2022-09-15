// Counter with XOR example
package lab6
import chisel3 . _
import chisel3 . util . _
class counter_with_xor ( val max : Int = 4) extends Module {
val io = IO (new Bundle {
val out = Output ( UInt (( log2Ceil ( max ) . W ) ) )
})
// Start Coding here
val count = RegInit(0.U(max.W))

when ((count(log2Ceil(max)-1)^0.B).asBool){
    count := 0.U
}.otherwise{count := count + 1.U}
io.out := count
// End your code here
}
//println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new counter_with_xor ( n ) )

