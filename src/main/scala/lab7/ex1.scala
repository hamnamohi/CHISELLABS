package lab7
import chisel3._
import chisel3.util._
import java.io.File
class arbiter ( ) extends Module {
val io = IO (new Bundle {
val in1 = Flipped(Decoupled(Input ( UInt ( 4 . W ) )))
val in2 = Flipped(Decoupled(Input ( UInt ( 4 . W ) )))
val in3 = Flipped(Decoupled(Input ( UInt ( 4 . W ) )))
val out = Decoupled(Output( UInt ( 4 . W )))
val out1 = Decoupled(Output( UInt ( 4 . W )))
val out2 = Decoupled(Output( UInt ( 4 . W )))})

val q1 = Queue(io.in1, 5)
val q2 = Queue(io.in2, 5)
val q3 = Queue(io.in3, 5)

val arb_priority = Module (new RRArbiter ( UInt () , 3) )
// connect the inputs to different producers
arb_priority . io . in (0) <> q1
arb_priority . io . in (1) <> q2
arb_priority . io . in (2) <> q3

// connect the output to consumer
io.out <> arb_priority.io.out
io.out1 <> arb_priority.io.out
io.out2 <> arb_priority.io.out
}

