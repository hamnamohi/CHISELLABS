package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class operatortests extends FreeSpec with ChiselScalatestTester{
    "operator Test" in { 
        test(new Operator(4,UInt(4.W))(_+_)){ c=>
        c.io.in(0).poke(6.U)
        c.io.in(1).poke(2.U)
        c.io.in(2).poke(1.U)
        c.io.in(3).poke(3.U)
        
        c.clock.step(1)
        c.io.out(0).expect(12.U)
        c.io.out(1).expect(12.U)
        c.io.out(2).expect(12.U)
        c.io.out(3).expect(12.U)}
    }
}