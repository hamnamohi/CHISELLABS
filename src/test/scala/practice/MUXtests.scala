package practice
import chisel3._
import org.scalatest._
import chiseltest._

class MUXtests extends FreeSpec with ChiselScalatestTester{
    "MUX Gate Test" in { 
        test(new MUX()){ c=>
        c.io.in1.poke(4.U)
        c.io.in2.poke(1.U)
        c.io.sel.poke(1.U)
        c.clock.step(1)
        c.io.out.expect(3.U)}
    }
}