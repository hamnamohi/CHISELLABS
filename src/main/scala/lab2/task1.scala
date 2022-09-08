//lab 2 task1
package lab2
import chisel3._
import chisel3.util._
class LM_IO_Interface1 extends Bundle {
//2.6. ASSIGNMENTS 25
val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Output ( UInt (32. W ) )
}
class Mux_5to1 extends Module {
val io = IO (new LM_IO_Interface1 )
// Start coding here
val sel = Cat(io.s2,io.s1,io.s0).asInstanceOf[UInt]
io.out := MuxCase( false .B , Array (
( sel ===0.U ) -> 0.U ,
( sel ===1.U) -> 8.U ,
( sel ===2.U) -> 16.U ,
( sel ===3.U) -> 24.U ,
(sel === BitPat("b1??" )) -> 32.U 
// ( sel ===5. U ) -> io . in5 ,
// ( sel ===6. U ) -> io . in6 ,
// ( sel ===7. U ) -> io . in7 )
))}

// End your code here

//println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new Mux_5to1 ) )
