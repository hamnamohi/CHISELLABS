package lab5
import chisel3 . _
import chisel3 . util . _
class eMux_ [ T <: Data ]( gen : T  ,gen1 :T ) extends Bundle {

val out = Output ( gen )
val in1 = Input ( gen )
val in2 = Input ( gen1 )
val sel = Input ( Bool () )
}
class emux1 [ T <: Data ]( gen:T, gen1:T ) extends Module {
 val io = IO(new eMux_(gen, gen1))

io . out := mux2 ( io . in1 , io . in2 , io . sel )
def mux2 [ T <: Data ]( in_0 :T , in_1 :T , sel : Bool ) : T = {
Mux( sel , in_1 , in_0 )
}
}