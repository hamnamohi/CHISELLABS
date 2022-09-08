//lab3 ex2
package lab3
import chisel3._
import chisel3.util._


trait Config {
// word length configuration parameter
val WLEN = 64
// ALU operation control signal width
val ALUOP_SIG_LEN = 4
}
object ALUOP {
// ALU Operations , may expand / modify in future
val ALU_ADD = 0. U (4. W )
val ALU_SUB = 1. U (4. W )
val ALU_AND = 2. U (4. W )
val ALU_OR = 3. U (4. W )
val ALU_XOR = 4. U (4. W )
val ALU_SLT = 5. U (4. W )
val ALU_SLL = 6. U (4. W )
val ALU_SLTU = 7. U (4. W )
val ALU_SRL = 8. U (4. W )
val ALU_SRA = 9. U (4. W )
val ALU_COPY_1 = 10. U (4. W )
val ALU_COPY_2 = 11. U (4. W )
val ALU_XXX = 15. U (4. W )
}

import ALUOP._


class ALUpractice extends Bundle with Config {
val in = Input ( UInt (ALUOP_SIG_LEN. W ) )
val in1 = Input ( UInt (WLEN. W ) )
val in2 = Input ( UInt (WLEN. W ) )
val out = Output ( UInt (WLEN. W ) )
}
class ALUpractice1 extends Module with Config{
val io = IO (new ALUpractice )
io . out := 0. U
val sum = io . in1 + Mux( io . in (0) , - io . in2 , io . in2 )
val cmp = Mux( io . in1 ( WLEN -1) === io . in1 ( WLEN -1) , sum ( WLEN -1) ,
Mux( io . in (1) , io . in2 ( WLEN -1) , io . in1 ( WLEN -1) ) )

val shamt = io . in2 (4 ,0) . asUInt
val shin = Mux( io . in (3) , io . in1 , Reverse ( io . in1 ) )
val shiftr = ( Cat ( io . in (0) && shin ( WLEN -1) , shin ) . asSInt >> shamt ) (
WLEN -1 , 0)
val shiftl = Reverse ( shiftr )




switch ( io . in ) {
is (ALU_ADD ) {
io . out :=  sum
}
is (ALU_SUB ) {
io . out := sum

}
is (ALU_AND ) {
io . out :=  io . in1 & io . in2
}
is (ALU_OR) {
io . out :=  io . in1 | io . in2
}
is (ALU_XOR ) {
io . out :=  io . in1 ^ io . in2
}
is (ALU_SLT ) {
io . out := cmp
}
is (ALU_SLL ) {
io . out := shiftl
}
is (ALU_SLTU ) {
io . out := cmp
}
is (ALU_SRL ) {
io . out := shiftr
}
is (ALU_SRA ) {
io . out := shiftr
}
is (ALU_COPY_1 ) {
io . out :=  io . in1
}
is (ALU_COPY_2 ) {
io . out :=  io . in2
}
is (ALU_XXX ) {
io . out := 0. U
}
}
}
