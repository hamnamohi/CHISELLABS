//lab3 task2
package lab3
import chisel3._
import chisel3.util._
object instructions{
    

    val i_type = "b0010011".U 
    val s_type = "b0100011".U 
    val u_type = "b0110111".U 
    val sb_type = "b1100011".U 
    val j_type ="b1101111".U 
     
}

class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32. W ) )
    val immd_se = Output ( UInt (32. W ) )
}
import instructions._
class ImmdValGen extends Module {
    val io = IO (new LM_IO_Interface_ImmdValGen )
// Start coding here
    io.immd_se := 0. U
    
    switch(io.instr(6,0)){
        is(i_type){
            val temp :=Fill(20,io.instr(31))
            io.immd_se := Cat(temp, io.instr(31,20))
        }
        is(s_type){
            val temp :=Fill(20,io.instr(31))
            io.immd_se := Cat(temp,io.instr(31,25),io.instr(11,7))
        }
        is(u_type){
            val temp :=Fill(20,io.instr(31))
            io.immd_se := Cat(temp,io.instr(31,12))
        }
        is(sb_type){
            val temp :=Fill(20,io.instr(31))
            io.immd_se := Cat(temp,io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8))
        }
        is(j_type){
            val temp :=Fill(20,io.instr(31))
            io.immd_se := Cat(temp,io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21))
        }
        
    }
}
