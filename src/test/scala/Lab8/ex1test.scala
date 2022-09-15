package Lab8
import chisel3._
import org.scalatest._
import chiseltest._

class maskingtests extends FreeSpec with ChiselScalatestTester{
    "masking Test" in { 
        test(new masking()){ c=>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(2.U)
        c.io.mask(0).poke(1.B)
        c.io.mask(1).poke(1.B)
        c.io.mask(2).poke(1.B)
        c.io.mask(3).poke(1.B)
        c.io.dataIn(0).poke(1.U)
        c.io.dataIn(1).poke(1.U)
        c.io.dataIn(2).poke(1.U)
        c.io.dataIn(3).poke(1.U)
        c.clock.step(20)
    
        //c.io.result.expect(0.B)
        
        }
    }
}