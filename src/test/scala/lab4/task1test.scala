package lab4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder . _
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
//import FUNCTION3._
class branchcontroltest extends FreeSpec with ChiselScalatestTester {
    "branch control test" in {
test ( new BranchControl() ) { c =>
// br operations
val array_op = Array ( 0,1,4,5,6,7)
for ( i <- 0 until 100) {
val src_a = Random . nextLong () & 0xFFFFFFFFL
val src_b = Random . nextLong () & 0xFFFFFFFFL
val opr = Random . nextInt (6)
val func3 = array_op(opr)
val branch1 = Random.nextBoolean()
// ALU functional implementation using Scala match
val result = func3 match {
case 0 => if (src_a === src_b) {1}  else {0}
case 1 => if (src_a != src_b) {1}  else {0}
case 4 => if (src_a < src_b)  {1}  else {0}
case 5 => if (src_a >= src_b)  {1}  else {0}
case 6 => if (src_a <= src_b) {1}  else {0}
case 7 => if (src_a >= src_b)  {1}  else {0}}
c.io.arg_x.poke ( src_a .U )
c.io.arg_y.poke ( src_b .U )
c.io.branch.poke ( branch1 .B )
c.io.fnct3.poke ( func3 .U )
c.clock.step (1)
if (branch1 === 1.B){
c.io.br_taken.expect ( result.B )
} else if (branch1 === 0.B) {c.io.br_taken.expect (0.B)}
//c . clock . step (2)
}
}
    }}