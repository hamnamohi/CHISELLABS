package Lab8

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class massignTest extends FreeSpec with ChiselScalatestTester {
    "Memory Assign Test " in {
        test(new memory_assignment){ c =>
            c.io.requestor(0).bits.poke(1.U)
            c.io.requestor(0).valid.poke(1.B)
            c.io.requestor(1).bits.poke(2.U)
            c.io.requestor(1).valid.poke(0.B)
            c.io.requestor(2).bits.poke(3.U)
            c.io.requestor(2).valid.poke(0.B)
            c.io.requestor(3).bits.poke(4.U)
            c.io.requestor(3).valid.poke(0.B)
            c.clock.step(10)
            c.io.Readaddr.poke(4.U)
            c.io.Writeaddr.poke(4.U)

            c.clock.step(20)
            
        }
    }
}