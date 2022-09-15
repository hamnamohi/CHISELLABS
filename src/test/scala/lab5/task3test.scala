package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class emux_tests extends FreeSpec with ChiselScalatestTester{
    "emux_ Test" in { 
        test(new emux1(UInt(4.W),UInt(4.W))){ c=>
        c.io.in1.poke(6.U)
        c.io.in2.poke(2.U)
        c.io.sel.poke(1.B)
        // c.io.in(3).poke(3.U)
        
        c.clock.step(1)
        c.io.out.expect(2.U)
        }
    }
}