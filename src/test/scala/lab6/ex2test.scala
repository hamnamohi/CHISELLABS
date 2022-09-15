package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class C1tests extends FreeSpec with ChiselScalatestTester{
    "C1 Test" in { 
        test(new counter(4)){ c=>
        
        
        c.clock.step(20)
        //c.io.out.expect(1.U)}
    }}}
