//lab3 task2
package lab3
import chisel3._
import org.scalatest._
import chiseltest._
class task2test extends FreeSpec with ChiselScalatestTester{
    "ins Test" in {
        test(new ImmdValGen()){ c =>
        c.io.instr.poke("b01010101011010101010101010010011".U)
        c.clock.step(1)
        c.io.immd_se.expect("b0000000000000000000010101010110".U)
    }
}
}