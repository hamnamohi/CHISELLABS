package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class XORC2tests extends FreeSpec with ChiselScalatestTester{
    "XORC Test" in { 
        test(new counter_with_xor()){ c=>
        
        
        c.clock.step(20)
        //c.io.out.expect(1.U)}
    }}}