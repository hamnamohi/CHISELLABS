//lab3 task1
package lab3
import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage
class LM_IO_Interfacee extends Bundle {
val fnct3 = Input ( UInt (3. W ) )
val branch = Input ( Bool () )
val arg_x = Input ( UInt (32. W ) )
val arg_y = Input ( UInt (32. W ) )
val br_taken = Output ( Bool () )
//val out = Output ( Bool () )
}
class BranchControl extends Module {
val io = IO (new LM_IO_Interfacee )
// Start Coding here
object FUNCTION3 {
val beq = 0.U(3.W)
val bne = 1.U (3.W)
val blt = 4.U (3.W)
val bge = 5.U (3.W)
val bltu = 6.U (3.W)
val bgeu = 7.U (3.W)}


import FUNCTION3._
//val temp = RegInit(0.U)
io.br_taken := 0.U
switch ( io.fnct3 ) {
is (beq ) {
when (io.arg_x === io.arg_y){
    io.br_taken := 1.B & io.branch
}.otherwise{ 
io.br_taken := 0.B & io.branch
}}
is (bne ) {
when (io.arg_x =/= io.arg_y){
    io.br_taken := 1.B & io.branch
}.otherwise{ 
io.br_taken := 0.B & io.branch}
}
is (blt ) {
when (io.arg_x < io.arg_y){
    io.br_taken := 1.B & io.branch
}.otherwise{ 
io.br_taken := 0.B & io.branch}
}
is (bge ) {
when (io.arg_x >= io.arg_y){
    io.br_taken := 1.B & io.branch
}.otherwise{ 
io.br_taken := 0.B& io.branch }
}
is (bltu ) {
when (io.arg_x <= io.arg_y){
    io.br_taken := 1.B & io.branch
}.otherwise{ 
io.br_taken := 0.B & io.branch }
}
is (bgeu ) {
when (io.arg_x >= io.arg_y){
    io.br_taken := 1.B & io.branch
}.otherwise{ 
io.br_taken := 0.B & io.branch }
}
}}








// End your code here
//Well , you can actually write classes too . So , technically you have no
// limit ; )

//println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new Branch_Control ) )
