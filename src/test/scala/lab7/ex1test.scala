package lab7
import chisel3._
import org.scalatest._
import chiseltest._

class arbitertests extends FreeSpec with ChiselScalatestTester{
    "arbiter Test" in { 
        test(new arbiter()){ c=>
        c.io.in1.bits.poke(1.U)
        c.io.in1.valid.poke(1.B)
        c.io.in2.bits.poke(2.U)
        c.io.in2.valid.poke(1.B)
        c.io.in3.bits.poke(3.U)
        c.io.in3.valid.poke(1.B)
        c.clock.step(20)
    
        //c.io.result.expect(0.B)
        
        }
    }
}