package Lab8
import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class bankmemoryTest extends FreeSpec with ChiselScalatestTester {
    "bank memory Test" in {
        test(new bankedmemory){ c =>
            c.io.enable.poke(1.B)
            c.io.rAddr.poke(1.U)
            c.io.wrAddr.poke(1.U)
            c.io.wrData(0).poke(1.U)
            c.io.wrData(1).poke(2.U)
            c.io.wr_en.poke(1.B)
            c.io.mask(0).poke(0.B)
            c.io.mask(1).poke(1.B)
            c.clock.step(10)
        }
    }
}