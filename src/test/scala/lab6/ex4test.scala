package lab6
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class QueTests extends FreeSpec with ChiselScalatestTester {

  "Que tests" in {
    test(new MyQueue) { c =>
      c.io.in.bits.poke(8.U)
      c.io.in.valid.poke(1.B)
      c.clock.step(20)
      c.io.out.ready.poke(1.B)
      c.io.out.bits.expect(8.U)
    }
  }
}
