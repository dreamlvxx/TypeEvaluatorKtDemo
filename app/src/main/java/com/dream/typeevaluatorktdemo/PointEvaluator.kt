package com.dream.typeevaluatorktdemo

import android.animation.TypeEvaluator

class PointEvaluator : TypeEvaluator<Point>{

    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
        val x = startValue.x + fraction * (endValue.x - startValue.x)
        val y = startValue.y + fraction * (endValue.y - startValue.y)
        return Point(x,y)
    }

}