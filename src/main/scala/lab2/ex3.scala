//lab 2 ex3
package lab2


import chisel3._ 
import chisel3.util._

class encodermux extends Module {
    val io = IO(new Bundle{
        val in1 = Input(UInt(4.W))
        val out = Output(UInt(2.W))
    })

    io.out := Mux1H(io.in1, Seq(0.U, 1.U, 2.U, 3.U))

    
}