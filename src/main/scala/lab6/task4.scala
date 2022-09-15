// lab 1 task2
package lab6
import chisel3._
import chisel3.util._
import java.io.File
class up_down_counter1 ( val max : Int = 10) extends Module {
val io = IO (new Bundle {
val out = Output ( UInt ( log2Ceil(max) . W ) )
val up_down = Input ( Bool () )

})
    val counter2 = RegInit (0.U ( log2Ceil ( max ).W ) )
    io.out := 0.U
    //val flag = RegInit(0.U)
    dontTouch(counter2)
    val up_down1 = RegInit(io.up_down)
    
    when ( counter2 =/= max.U && up_down1 === 1.B ) {
        //
            counter2 := counter2 + 1.U
        
        //io.out := 1.B 
        }
    .elsewhen (counter2 === max.U){
        up_down1 := 0.B
        
        counter2 := counter2 - 1.U}
   
    .elsewhen (counter2 === 0.U){
        up_down1 := 1.B
        

    }
    .elsewhen (up_down1 === 0.B){
        counter2 := counter2 - 1.U
    }
    io.out := counter2}
    //io.out := 1.B  }

    // }. elsewhen (counter2 =/= max_count){
    //     //io.out := 1.B
    //     counter2 := counter2 + 1.U
        
    // }
    //io.out := 1.B
