//lab 2 ex2
package lab2
import chisel3._
import org.scalatest._
import chiseltest._

class mux2tests extends FreeSpec with ChiselScalatestTester{
    "mux2 Test" in { 
        test(new Mux_8to1()){ c=>
        c.io.in0.poke(0.B)
        c.io.in1.poke(1.B)
        c.io.in2.poke(0.B)
        c.io.in3.poke(1.B)
        c.io.in4.poke(0.B)
        c.io.in5.poke(1.B)
        c.io.in6.poke(0.B)
        c.io.in7.poke(1.B)
        c.io.s0.poke(1.B)
        c.io.s1.poke(4.U)
        //c.io.s2.poke(1.U)
        c.clock.step(1)
        c.io.out.expect(0.B)}
    }
}