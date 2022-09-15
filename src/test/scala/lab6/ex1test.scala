package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class R1tests extends FreeSpec with ChiselScalatestTester{
    "R1 Test" in { 
        test(new shift_register()){ c=>
        c.io.in.poke(1.U)
        
        c.clock.step(1)
        //c.io.out.expect(1.U)}
    }}
}