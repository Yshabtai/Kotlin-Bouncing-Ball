package ys.com.kotlinapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * Created by Yuval Shabtai on 6/16/2017.
 */
class BallView : View {

    var ballX = 150F
    var ballY = 200F
    var ballRad = 50F

    var vX = 1F
    var vY = 1F

    var ballPaint: Paint? = null

    constructor(context: Context?) : super(context) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        ballPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        (ballPaint as Paint).color = Color.argb(0xFF, 0x91, 0xD8, 0xFF)
    }


    /**
     * Changes the velocity of the ball.
     *
     * @param vx: Int delta x
     * @param vy: Int delta y
     */
    fun addVelocity(dx: Float, dy: Float) {
        vX += dx
        vY += dy
    }

    /**
     * Moves the ball around the view.
     */
    fun moveBall() {
        ballX += vX
        ballY += vY

        if(ballX > width - ballRad) {   //Ball exited the right margin
            val overshoot = ballX - (width - ballRad)
            ballX -= overshoot * 2
            vX = -vX

        } else if (ballX < ballRad) {   //Ball exited the left border
            val overshoot = ballRad - ballX
            ballX += overshoot * 2
            vX = -vX
        }

        if(ballY > height - ballRad) {  //Ball exited below
            val overshoot = ballY - (height - ballRad)
            ballY -= overshoot * 2
            vY = -vY
        } else if(ballY < ballRad) {    //Ball exited above
            val overshoot = ballRad - ballY
            ballY += overshoot * 2
            vY = -vY
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle(ballX, ballY, ballRad, ballPaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_DOWN) {
            val xDistance = event.x - ballX
            val yDistance = event.y - ballY

            val deltaX = -xDistance / 25
            val deltaY = -yDistance / 25

            addVelocity(deltaX, deltaY)
        }

        return super.onTouchEvent(event)
    }
}