package practice
import chisel3._
import org.scalatest._
import chiseltest._

class Andtests extends FreeSpec with ChiselScalatestTester{
    "And Gate Test" in { 
        test(new And()){ c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.clock.step(1)
        c.io.c.expect(0.S)}
    }
}
