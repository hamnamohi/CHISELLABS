package lab5
import chisel3 . _
import chisel3 . util . _
class IO_Interface1 [ T <: Data ]( gen : T ) extends Bundle {
val out = Output ( gen )
val in1 = Input ( gen )
val in2 = Input ( gen )
val sel = Input ( Bool () )}

class emux ( size : UInt ) extends Module {
val io = IO (new IO_Interface1 ( size ) )
io . out :=Mux( io.sel , io.in2 , io.in1 )
}

