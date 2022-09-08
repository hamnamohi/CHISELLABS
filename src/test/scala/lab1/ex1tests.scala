//Ex:1 Lab1
package lab1
import chisel3._
import org.scalatest._
import chiseltest._

class Countertests extends FreeSpec with ChiselScalatestTester{
    "Counter Test" in { 
        test(new Counter(3.S)){ c=>
        c.clock.step(18)
    
        c.io.result.expect(0.B)
        
        }
    }
}