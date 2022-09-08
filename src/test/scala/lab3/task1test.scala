//lab3 task1
package lab3
import chisel3._
import org.scalatest._
import chiseltest._

class task1tests extends FreeSpec with ChiselScalatestTester{
    "task1 Test" in { 
        test(new BranchControl()){ c=>
        c.io.fnct3.poke(4.U)
        c.io.arg_x.poke(1.U)
        c.io.arg_y.poke(2.U)
        c.io.branch.poke(1.B)
        //c.io.branch.poke(1.B)
        //c.io.in.poke(15.U)
        //c.io.select.poke(0.B)
        c.clock.step(1)
        c.io.br_taken.expect(1.B)}
    }
}