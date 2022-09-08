// lab 1 task2
package lab1
import chisel3._
import chisel3.util._
import java.io.File
class counter_up_down ( n : Int ) extends Module {
    val io = IO(new Bundle {
        // val data_in = Input ( UInt ( n.W ) )
        // val reload = Input ( Bool () )
        val out = Output ( Bool () )
        })
    val counter2 = RegInit (0.U ( n.W ) )
    val flag = RegInit(0.U)
    dontTouch(counter2)
    val max_count = RegInit(6.U ( n.W ) )
    io.out := 0.U
    when ( counter2 =/= max_count && flag === 0.U ) {
        when (flag === 0.U){
            counter2 := counter2 + 1.U}
        
        //io.out := 1.B 
        }
    .elsewhen (counter2 === max_count){
        flag := 1.U
        io.out := 1.U
        counter2 := counter2 - 1.U}
   
    .elsewhen (counter2 === 0.U){
        flag := 0.U
        io.out := 1.U

    }
    .elsewhen (flag === 1.U){
        counter2 := counter2 - 1.U
    }}
    //io.out := 1.B  }

    // }. elsewhen (counter2 =/= max_count){
    //     //io.out := 1.B
    //     counter2 := counter2 + 1.U
        
    // }
    //io.out := 1.B
