//lab 2 ex1
package lab2
import chisel3._
import org.scalatest._
import chiseltest._

class mux1tests extends FreeSpec with ChiselScalatestTester{
    "mux Test" in { 
        test(new Mux_2to1()){ c=>
        c.io.in_A.poke(6.U)
        c.io.in_B.poke(15.U)
        c.io.select.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(6.U)}
    }
}