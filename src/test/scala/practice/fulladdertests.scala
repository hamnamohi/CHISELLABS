package practice
import chisel3._
import org.scalatest._
import chiseltest._

class fulladdertests extends FreeSpec with ChiselScalatestTester{
    "fulladder Gate Test" in { 
        test(new fulladder()){ c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.io.c.poke(1.S)
        c.clock.step(1)
        c.io.sum.expect(-8.S)
        c.io.cout.expect(1.S)}
    }
}