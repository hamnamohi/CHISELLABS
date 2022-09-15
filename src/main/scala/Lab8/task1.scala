package Lab8
import chisel3._
import chisel3.util._
class memory_assignment extends Module {
val io = IO (new Bundle {
val memory_out = Vec (4 , Output ( UInt (32. W ) ) )
val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
val Readaddr = Input ( UInt (5. W ) )
val Writeaddr = Input ( UInt (5. W ) )
 val mask = Input ( Vec (4 , Bool () ) )
})

val q1 = Queue(io.requestor(0), 5)
val q2 = Queue(io.requestor(1), 5)
val q3 = Queue(io.requestor(2), 5)
val q4 = Queue(io.requestor(3), 5)

val arb_priority = Module (new RRArbiter ( UInt () , 4) )
// connect the inputs to different producers
arb_priority.io.in (0) <> q1
arb_priority.io.in (1) <> q2
arb_priority.io.in (2) <> q3
arb_priority.io.in (3) <> q4
arb_priority.io.out.ready := 1.B

val memory = Mem (1024 ,Vec(4, UInt (32. W ) ))
val temp = Reg(Vec(4,UInt(32.W)))
when (io.requestor(0).valid){
    temp(0) := arb_priority.io.out.bits
}.otherwise{ temp(0) := 0.U}
when (io.requestor(1).valid){
    temp(1) := arb_priority.io.out.bits
}.otherwise{ temp(1) := 0.U}
when (io.requestor(2).valid){
    temp(2) := arb_priority.io.out.bits
}.otherwise{ temp(2) := 0.U}
when (io.requestor(3).valid){
    temp(3) := arb_priority.io.out.bits
}.otherwise{ temp(3) := 0.U}

memory . write ( io.Writeaddr , temp )
io.memory_out := memory.read(io.Readaddr)

}