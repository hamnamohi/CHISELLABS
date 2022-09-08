// package lab4
// import chisel3._
// import chisel3.util._
// import org.scalatest._
// import chiseltest._
// import chiseltest.experimental.TestOptionBuilder . _
// import chiseltest.internal.VerilatorBackendAnnotation
// import scala.util.Random
// //import FUNCTION3._
// class immetest extends FreeSpec with ChiselScalatestTester {
//     "imme test" in {
// test ( new ImmdValGen() ) { c =>
// // br operations
// val array_op = Array ( 0,1,4,5,6,7)
// for ( i <- 0 until 100) {
// // val src_a = Random . nextLong () & 0xFFFFFFFFL
// // val src_b = Random . nextLong () & 0xFFFFFFFFL
// val opr = Random . nextInt (6)
// val type = array_op(opr)
// //val branch1 = Random.nextBoolean()
// // ALU functional implementation using Scala match
// val result = type match {
// case 0 => "b0010011"
// case 1 => "b0100011"
// case 4 => "b0110111"
// case 5 => "b1100011"
// case 6 => "b1101111"
// case 7 => "b0000011"}
// // c.io.arg_x.poke ( src_a .U )
// // c.io.arg_y.poke ( src_b .U )
// // c.io.branch.poke ( branch1 .B )
// c.io.instr.poke ( type .U )
// c.clock.step (1)
// if (branch1 === 1.B){
// c.io.br_taken.expect ( result.B )
// } else if (branch1 === 0.B) {c.io.br_taken.expect (0.B)}
// //c . clock . step (2)
// }
// }
//     }}