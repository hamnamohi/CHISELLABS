//lab 2 ex1
package lab2
import chisel3._
import chisel3.util._
// Mux IO interface class
class Mux_2to1_IO extends Bundle {
val in_A = Input ( UInt (32. W ) )
val in_B = Input ( UInt (32. W ) )
val select = Input (Bool() )
val out = Output ( UInt () )
}
// 2 to 1 Mux implementation
class Mux_2to1 extends Module {
val io = IO (new Mux_2to1_IO)
// update the output
//val new1 = Fill(4, io.select.asUInt)
io.out := io.in_A & ~(Fill(32, io.select.asUInt)) | io.in_B & (Fill(32, io.select.asUInt))

}
//println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new Mux_2to1 () ) )
