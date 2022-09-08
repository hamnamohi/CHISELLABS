//lab3 ex1
package lab3
import chisel3._
import org.scalatest._
import chiseltest._

class T4to2encodertests extends FreeSpec with ChiselScalatestTester{
    "Encoder mux Test" in { 
        test(new T4to2encoder()){ c=>
        c.io.in.poke(1.U)
        //c.io.in.poke(15.U)
        //c.io.select.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(1.U)}
    }
}