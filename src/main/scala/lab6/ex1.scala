package lab6
import chisel3 . _
class shift_register ( val init : Int = 1) extends Module {
val io = IO (new Bundle {
val in = Input ( UInt (4. W ) )
val out = Output ( UInt (4. W ) )
})
io.out := 0.U
val state = RegInit ( init . U (4. W ) ) // register initialization
val temp = RegInit(0.U(4.W))

    when (temp === 0.U){
        temp := 1.U
        state := io.in
    }.otherwise{
          io.out := state(0)
        state := state >> 1
    }
}