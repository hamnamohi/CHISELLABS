//lab3 task3
package lab3
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_decoder_with_valid extends Bundle {
val in = Input ( UInt (2. W ) )
val out = Valid ( Output ( UInt (4. W ) ) )
}
class decoder_with_valid extends Module {
val io = IO (new LM_IO_Interface_decoder_with_valid )
// Start coding here
io.out.bits := 0.U
io.out.valid := 0.B
switch ( io . in ) {
is (0. U ) {
io.out.bits :=  0. U
io.out.valid := 1.B
}
is (1. U ) {
io.out.bits := 1. U
io.out.valid := 1.B
// 30 CHAPTER 3. CONTROL FLOW AND COMBINATIONAL CIRCUITS
}
is (2. U ) {
io.out.bits := 2. U
io.out.valid := 1.B
}
is (3. U ) {
io.out.bits := 3. U
io.out.valid := 1.B
}}
// End coding here
}