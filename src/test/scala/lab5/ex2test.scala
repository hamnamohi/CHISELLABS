package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class emuxtests extends FreeSpec with ChiselScalatestTester{
    "emux Test" in { 
        test(new emux(UInt(32.W))){ c=>
        c.io.in1.poke(4.U)
        c.io.in2.poke(5.U)
        c.io.sel.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(4.U)}
    }
}