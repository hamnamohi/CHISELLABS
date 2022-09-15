package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class counter_up_down1test extends FreeSpec with ChiselScalatestTester{
    "counter_up_down1 Test" in { 
        test(new up_down_counter1()){ c=>
        c.clock.step(18)
        //c.io.up_down.poke(1.B)
        // c.io.reload.poke(0.B)
        //c.io.out.expect(1.B)
        
        
        }
    }
}