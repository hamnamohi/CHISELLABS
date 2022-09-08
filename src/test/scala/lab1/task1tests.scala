package lab1
import chisel3._
import org.scalatest._
import chiseltest._

class datatests extends FreeSpec with ChiselScalatestTester{
    "data Test" in { 
        test(new data1()){ c=>
        c.io.a1.poke(0.B)
        c.io.b1.poke(0.B)
        c.clock.step(1)
        c.io.c1.expect(0.B)}
    }
}