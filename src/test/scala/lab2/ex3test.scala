//lab 2 ex1
package lab2
import chisel3._
import org.scalatest._
import chiseltest._

class encodermuxtest extends FreeSpec with ChiselScalatestTester{
    "encoder mux Test" in { 
        test(new encodermux()){ c=>
        c.io.in1.poke(1.U)
        c.clock.step(1)
        c.io.out.expect(0.U)}
    }
}