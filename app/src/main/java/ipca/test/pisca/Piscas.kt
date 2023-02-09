package ipca.test.pisca

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import java.util.*

class Piscas(context: Context, attrs: AttributeSet) : View(context, attrs) {

    var leftArrow = 0
    var rightArrow = 0
    private var isLeftBlinking = false
    private var isRightBlinking = false
    private var isBothBlinking = false
    private lateinit var blinkLeftRunnable: Runnable
    private lateinit var blinkRightRunnable: Runnable
    private lateinit var blinkBothRunnable: Runnable
    private val blinkHandler = Handler()


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var paint = Paint()


        val width = width.toFloat()
        val height = height.toFloat()

        if (leftArrow == 0) {
            // Left arrow
            paint.style = Paint.Style.STROKE
            paint.color = 0xFFFFA500.toInt()
            canvas?.drawLine(width / 8, height / 2, width / 4, height / 4, paint)
            canvas?.drawLine(width / 8, height / 2, width / 4, height * 3 / 4, paint)
            canvas?.drawLine(width / 4, height / 4, width / 4, height * 3 / 4, paint)

            val leftPath = Path()
            leftPath.moveTo(width / 8, height / 2)
            leftPath.lineTo(width / 4, height / 4)
            leftPath.lineTo(width / 4, height * 3 / 4)
            leftPath.close()
            canvas?.drawPath(leftPath, paint)
        } else if (leftArrow == 1) {
            // Left arrow

            paint.style = Paint.Style.FILL
            paint.color = 0xFFFFA500.toInt()
            canvas?.drawLine(width / 8, height / 2, width / 4, height / 4, paint)
            canvas?.drawLine(width / 8, height / 2, width / 4, height * 3 / 4, paint)
            canvas?.drawLine(width / 4, height / 4, width / 4, height * 3 / 4, paint)


            val leftPath = Path()
            leftPath.moveTo(width / 8, height / 2)
            leftPath.lineTo(width / 4, height / 4)
            leftPath.lineTo(width / 4, height * 3 / 4)
            leftPath.close()
            canvas?.drawPath(leftPath, paint)
        }

        if (rightArrow == 0) {
            // Right arrow
            paint.style = Paint.Style.STROKE
            paint.color = 0xFFFFA500.toInt()
            canvas?.drawLine(width * 7 / 8, height / 2, width * 3 / 4, height / 4, paint)
            canvas?.drawLine(width * 7 / 8, height / 2, width * 3 / 4, height * 3 / 4, paint)
            canvas?.drawLine(width * 3 / 4, height / 4, width * 3 / 4, height * 3 / 4, paint)


            val rightPath = Path()
            rightPath.moveTo(width * 7 / 8, height / 2)
            rightPath.lineTo(width * 3 / 4, height / 4)
            rightPath.lineTo(width * 3 / 4, height * 3 / 4)
            rightPath.close()
            canvas?.drawPath(rightPath, paint)
        } else if (rightArrow == 1) {
            // Right arrow
            paint.style = Paint.Style.FILL
            paint.color = 0xFFFFA500.toInt()
            canvas?.drawLine(width * 7 / 8, height / 2, width * 3 / 4, height / 4, paint)
            canvas?.drawLine(width * 7 / 8, height / 2, width * 3 / 4, height * 3 / 4, paint)
            canvas?.drawLine(width * 3 / 4, height / 4, width * 3 / 4, height * 3 / 4, paint)

            val rightPath = Path()
            rightPath.moveTo(width * 7 / 8, height / 2)
            rightPath.lineTo(width * 3 / 4, height / 4)
            rightPath.lineTo(width * 3 / 4, height * 3 / 4)
            rightPath.close()
            canvas?.drawPath(rightPath, paint)
        }

    }

    fun setLeftArrow() {
        if (!isLeftBlinking) {
            isLeftBlinking = true
            blinkLeftRunnable = Runnable {
                leftArrow = if (leftArrow == 0) 1 else 0
                invalidate()
                blinkHandler.postDelayed(blinkLeftRunnable, 1000)
            }
            blinkHandler.post(blinkLeftRunnable)
        } else if (isLeftBlinking) {
            isLeftBlinking = false
            leftArrow = 0
            invalidate()
            blinkHandler.removeCallbacks(blinkLeftRunnable)
        }
    }

    fun setRightArrow() {
        if (!isRightBlinking) {
            isRightBlinking = true
            blinkRightRunnable = Runnable {
                rightArrow = if (rightArrow == 0) 1 else 0
                invalidate()
                blinkHandler.postDelayed(blinkRightRunnable, 1000)
            }
            blinkHandler.post(blinkRightRunnable)
        } else if (isRightBlinking) {
            isRightBlinking = false
            rightArrow = 0
            invalidate()
            blinkHandler.removeCallbacks(blinkRightRunnable)
        }
    }


    fun setBothArrow() {

        if (!isBothBlinking) {
            isBothBlinking = true
            blinkBothRunnable = Runnable {
                leftArrow = if (leftArrow == 0) 1 else 0
                rightArrow = if (rightArrow == 0) 1 else 0
                invalidate()
                blinkHandler.postDelayed(blinkBothRunnable, 1000)
            }
            blinkHandler.post(blinkBothRunnable)
        } else if (isBothBlinking) {
            isBothBlinking = false
            leftArrow = 0
            invalidate()
            rightArrow = 0
            invalidate()
            blinkHandler.removeCallbacks(blinkBothRunnable)
        }
    }
}