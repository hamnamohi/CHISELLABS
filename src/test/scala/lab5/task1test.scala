package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class addtests extends FreeSpec with ChiselScalatestTester{
    "add Test" in { 
        test(new Adder(4)){ c=>
        c.io.in0.poke(6.U)
        c.io.in1.poke(2.U)
        // c.io.in(2).poke(1.U)
        // c.io.in(3).poke(3.U)
        
        c.clock.step(1)
        c.io.sum.expect(8.U)
        }
    }
}