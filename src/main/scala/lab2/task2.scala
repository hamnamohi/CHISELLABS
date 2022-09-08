//lab 2 task2
package lab2
import chisel3._
import chisel3.util._
class barrel_shift extends Module {
val io = IO (new Bundle {
val in = Vec (4 , Input ( Bool () ) )
val sel1 = Vec (2 , Input ( Bool () ) )
val shift_type = Input ( Bool () )
val out = Vec (4 , Output ( Bool () ) )
})
// Start you code here
val sel = Cat(io.sel1(0),io.sel1(1)).asUInt
// class shiftmux extends Module {
// val io = IO (new barrel_shift )

val mux2_1_1 = MuxCase(false .B , Array (
( io.shift_type ===0. B) -> 0.B ,
( io.shift_type ===1. B ) -> io.in(0) ))

val mux2_1_2 = MuxCase(false .B , Array (
( io.shift_type ===0. B ) -> 0.B ,
( io.shift_type ===1. B ) -> io.in(1) ))

val mux2_1_3 = MuxCase(false .B , Array (
( io.shift_type ===0. B ) -> 0.B ,
( io.shift_type ===1. B ) -> io.in(2) ))

 io.out(0) := MuxCase(false .B , Array (
( sel ===0. U ) -> io.in(0),
( sel ===1. U ) -> io.in(1),
( sel ===2. U ) -> io.in(2),
( sel ===3. U ) -> io.in(3) ))

io.out(1) := MuxCase(false .B , Array (
( sel ===0. U ) -> io.in(1),
( sel ===1. U ) -> io.in(2),
( sel ===2. U ) -> io.in(3),
( sel ===3. U ) -> mux2_1_1 ))

io.out(2) := MuxCase(false .B , Array (
( sel ===0. U ) -> io.in(2),
( sel ===1. U ) -> io.in(3),
( sel ===2. U ) -> mux2_1_1,
( sel ===3. U ) -> mux2_1_2 ))

io.out(3) := MuxCase(false .B , Array (
( sel ===0. U ) -> io.in(3),
( sel ===1. U ) -> mux2_1_1,
( sel ===2. U ) -> mux2_1_2,
( sel ===3. U ) -> mux2_1_3 ))


// End your code here
}
