package mx.tecnm.tepic.ladm_u2_practica1

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p){
    //VARIABLES MOVIMIENTO CALACA
    var xC = -2000f
    var incrementoX = 10
    var escondida = true
    var img = R.drawable.calaca2

    var trabajando = false

    val timer = object : CountDownTimer(2000,5) {
        override fun onTick(millisUntilFinished: Long) {
            xC += incrementoX

            if(xC < -201 && escondida == true){

            }else {
                escondida = false
                if (xC <= -201) {
                    incrementoX *= -1
                    img = R.drawable.calaca2
                }
                if (xC >= 500) {
                    incrementoX *= -1
                    img = R.drawable.calaca1
                }
            }

            invalidate()
        }

        override fun onFinish() {
            start()
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()

        if(trabajando == false){
            timer.start()
            trabajando = true
        }

        c.drawARGB(255,7, 0, 57)

        //SUELO
        p.setColor(Color.rgb(80, 32, 3))
        c.drawRect(0f,1200f,1080f,1776f,p)

        //LUNA
        p.setColor(Color.rgb(252, 255, 147))
        c.drawCircle(100f,100f,300f,p)

        //RESPLANDOR LUNA
        p.setColor(Color.argb(60,255,255,255))
        c.drawCircle(100f,100f,350f,p)
        p.setColor(Color.argb(59,255,255,255))
        c.drawCircle(100f,100f,390f,p)
        p.setColor(Color.argb(58,255,255,255))
        c.drawCircle(100f,100f,430f,p)

        //ESTRELLAS
        p.setColor(Color.WHITE)
        c.drawCircle(500f,200f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(500f,200f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(640f,470f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(640f,470f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(760f,30f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(760f,30f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(1000f,200f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(1000f,200f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(100f,700f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(100f,700f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(970f,700f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(970f,700f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(710f,800f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(710f,800f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(430f,700f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(430f,700f,9f,p)

        p.setColor(Color.WHITE)
        c.drawCircle(230f,930f,5f,p)
        p.setColor(Color.argb(150,255,255,255))
        c.drawCircle(230f,930f,9f,p)

        p.setColor(Color.WHITE)
        val grande = BitmapFactory.decodeResource(resources,R.drawable.big)
        c.drawBitmap(grande,50f,600f,p)

        //ARBOL
        p.setColor(Color.rgb(98, 76, 63))
        c.drawRect(900f,500f,1300f,1400f,p)

        p.setColor(Color.rgb(87, 116, 95))
        c.drawCircle(730f,600f,200f,p)
        p.setColor(Color.rgb(64, 84, 69))
        c.drawCircle(730f,620f,190f,p)

        p.setColor(Color.rgb(87, 116, 95))
        c.drawCircle(960f,480f,300f,p)
        p.setColor(Color.rgb(64, 84, 69))
        c.drawCircle(960f,500f,290f,p)

        p.setColor(Color.rgb(87, 116, 95))
        c.drawCircle(930f,750f,200f,p)
        p.setColor(Color.rgb(64, 84, 69))
        c.drawCircle(950f,750f,200f,p)

        //ELEMENTOS PANTEON
        val calaca = BitmapFactory.decodeResource(resources,img)
        c.drawBitmap(calaca,xC,800f,p)

        val mediana = BitmapFactory.decodeResource(resources,R.drawable.medium)
        c.drawBitmap(mediana,700f,840f,p)

        val cancel = BitmapFactory.decodeResource(resources,R.drawable.cancel)
        c.drawBitmap(cancel,0f,1200f,p)

        val catrina = BitmapFactory.decodeResource(resources,R.drawable.catrina)
        c.drawBitmap(catrina,1000f,1000f,p)
    }
}