//lab 2 ex2
package lab2
import chisel3._
import chisel3.util._

class LM_IO_Interface extends Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )

val s0 = Input ( Bool())
val s1 = Input(UInt(3.W))
//val s2 = Input(UInt(2.W))
val out = Output ( Bool () ) // UInt (1. W))
}
class Mux_8to1 extends Module {
val io = IO (new LM_IO_Interface )
//io.out := MuxLookup ( io.s0 , false.B , Array (
io.out := MuxLookup( io.s0 , false.B , Array(
 (0.B) -> MuxLookup(io.s1,false.B,Array(
            (0.U) -> io.in0,
            (1.U) -> io.in1,
            (2.U) -> io.in2,
            (3.U) -> io.in3
            )) ,
(1.B) -> MuxLookup(io.s1,false.B,Array(
            (4.U) -> io.in4,
            (5.U) -> io.in5,
            (6.U) -> io.in6,
            (7.U) -> io.in7
    ))))
// io.out := MuxLookup( io.s0 , false.B , Array(
//     (0.B) -> a1
//     (1.B) -> a2))


    }