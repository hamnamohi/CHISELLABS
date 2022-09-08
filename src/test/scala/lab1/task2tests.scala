//lab1 task2
package lab1
import chisel3._
import org.scalatest._
import chiseltest._

class counter_up_downtest extends FreeSpec with ChiselScalatestTester{
    "counter_up_down Test" in { 
        test(new counter_up_down(3)){ c=>
        c.clock.step(18)
        // c.io.data_in.poke(8.U)
        // c.io.reload.poke(0.B)
        //c.io.out.expect(1.B)
        
        
        }
    }
}