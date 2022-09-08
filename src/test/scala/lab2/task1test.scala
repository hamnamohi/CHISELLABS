//lab 2 task1
package lab2
import chisel3._
import org.scalatest._
import chiseltest._

class muxcasetests extends FreeSpec with ChiselScalatestTester{
    "muxcaseTest" in { 
        test(new Mux_5to1()){ c=>
        c.io.s0.poke(0.B)
        c.io.s1.poke(0.B)
        c.io.s2.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(0.U)}
    }
}