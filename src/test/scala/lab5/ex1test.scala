package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class whenmuxtests extends FreeSpec with ChiselScalatestTester{
    "whenmux Test" in { 
        test(new ALU(4)){ c=>
        c.io.alu_oper.poke("b1111".U)
        c.io.arg_x.poke(15.U)
        c.io.arg_y.poke(0.B)
        c.clock.step(1)
        c.io.alu_out.expect(0.U)}
    }
}