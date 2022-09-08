//lab3 task3
package lab3
import chisel3._
import org.scalatest._
import chiseltest._

class task2tests extends FreeSpec with ChiselScalatestTester{
    "task2 Test" in { 
        test(new decoder_with_valid()){ c=>
        c.io.in.poke(2.U)
        c.io.out.valid.expect(1.B)
        c.io.out.bits.expect(2.U)
        // c.io.arg_y.poke(2.U)
        // c.io.branch.poke(1.B)
        //c.io.branch.poke(1.B)
        //c.io.in.poke(15.U)
        //c.io.select.poke(0.B)
        c.clock.step(1)
        // c.io.br_taken.expect(1.B)}
    }
}}