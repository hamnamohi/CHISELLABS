//ex2 lab1
package lab1
import chisel3._
import org.scalatest._
import chiseltest._

class CounterRtests extends FreeSpec with ChiselScalatestTester{
    "CounterR Test" in { 
        test(new CounterR()){ c=>
        c.clock.step(18)
    
        c.io.result.expect(0.B)
        
        }
    }
}