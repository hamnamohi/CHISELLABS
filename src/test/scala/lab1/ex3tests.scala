//ex3 lab1
package lab1

import chisel3._
import org.scalatest._
import chiseltest._
class Counter3test extends FreeSpec with ChiselScalatestTester{
    "Counter3 Test" in {
        test(new Counter3(8,8)){ c =>
        // c.io.counterBits.poke(3.U)
        c.clock.step(20)
        c.io.result.expect(0.B)
        }
    }
}