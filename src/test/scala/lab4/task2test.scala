package lab4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random

class immediatetest extends FreeSpec with ChiselScalatestTester {
    "imme test" in {
test ( new ImmdValGen() ) { c =>
val array_op = Array ( "b00000000011000110000001110010011","b00000000011000110000001110100011",
"b00000000011000110000001110110111","b00000000011000110000001111100011",
"b00000000011000110000001111101111")
for ( i <- 0 until 100) {

val opr1 = Random.nextInt (5)
val type1_ = array_op(opr1)

val result_ = type1_ match {
case "b00000000011000110000001110010011" => 6
case "b00000000011000110000001110100011" => 7
case "b00000000011000110000001110110111" => 1584
case "b00000000011000110000001111100011" => 1027
case "b00000000011000110000001111101111" => 98307}

c.io.instr.poke (type1_ .U )
c.clock.step (1)
c.io.immd_se.expect (result_ .U)

}
}
}}