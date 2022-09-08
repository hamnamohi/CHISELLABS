package practice
import chisel3._
import org.scalatest._
import chiseltest._

class NANDtests extends FreeSpec with ChiselScalatestTester{
    "NAND Gate Test" in { 
        test(new NAND()){ c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.clock.step(1)
        c.io.c.expect(-1.S)}
    }
}
