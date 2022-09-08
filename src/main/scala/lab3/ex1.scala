//lab3 ex1
package lab3
import chisel3._
import chisel3.util._

class encoderIO extends Bundle {
val in = Input ( UInt (4. W ) )
val out = Output ( UInt (2. W ) )
}
class T4to2encoder extends Module {
val io = IO (new encoderIO )
io . out := 0. U
switch ( io . in ) {
is ("b0000". U ) {
io . out :=  0. U
}
is ("b0001". U ) {
io . out := 1. U
}
is ("b0010". U ) {
io . out := 3. U
}
is ("b0011". U ) {
io . out := 4. U
}
}
}
