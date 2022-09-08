// EX2 LAB 1
package lab1
import chisel3._

class CounterR( ) extends Module{
    val io = IO (new Bundle {
        val result = Output ( Bool() )
    })
    
    val count = RegInit (0.U (4.W) )
    when ( count(3.U) === 1.B ) {
        count := 0.U
    }.otherwise {
        count := count + 1.U
    }
    io.result := count(3.U)
    
}