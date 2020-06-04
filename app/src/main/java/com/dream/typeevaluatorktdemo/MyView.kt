package com.dream.typeevaluatorktdemo

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?) : View(context) {
    val RADIUS = 80f

    lateinit var paint: Paint
    var point: Point? = null

    constructor(context: Context?, attrs: AttributeSet) : this(context) {
        paint = Paint()
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (point == null) {
            point = Point(RADIUS, RADIUS)
            canvas?.drawCircle(RADIUS, RADIUS, RADIUS, paint)
            val startPoint = Point(RADIUS, RADIUS)
            val endPoint = Point(500f, 500f)
            val anim = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint)
            anim.setDuration(5000)
            anim.addUpdateListener {
                point = it.animatedValue as Point
                invalidate()
            }
            anim.start()
        } else {
            canvas?.drawCircle(point!!.x, point!!.y, RADIUS, paint)
        }
    }
}