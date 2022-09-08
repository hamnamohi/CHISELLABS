//lab3 ex2
package lab3
import chisel3._
import org.scalatest._
import chiseltest._

class ALUpractice1tests extends FreeSpec with ChiselScalatestTester{
    "Encoder mux Test" in { 
        test(new ALUpractice1()){ c=>
        c.io.in.poke(0.U)
        c.io.in1.poke(1.U)
        c.io.in2.poke(2.U)
        //c.io.in.poke(15.U)
        //c.io.select.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(3.U)}
    }
}