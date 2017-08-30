package com.cc.demo.kotlin.view

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View


class StretchView : View {
    private var viewWidth: Int = 0
    private var viewHeight: Int = 0
    private var initPosition = 0
    private var initWidth: Int = 0
    private var initHeight: Int = 0
    private var stretchLength: Int = 0
    private var stretchDirection = 0
    private val animDurection = 70L
    var isAnimating = false
        private set
    private var radius = 0.0f
    private var stretchRatio = 0.0f
    private val verticalCtrlRatio = 0.4f
    private var color = Color.parseColor("#42bd41")
    private var animator: ValueAnimator? = null
    private var paint: Paint? = null
    private var path: Path? = null
    private val animatorUpdateListener = ValueAnimator.AnimatorUpdateListener { animation ->
        this@StretchView.stretchRatio = (animation.animatedValue as Float).toFloat()
        this@StretchView.invalidate()
        Log.i("StretchView", "onAnimationUpdate  ,stretchRatio = " + this@StretchView.stretchRatio)
    }
    private val animatorListenerAdapter = object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            this@StretchView.changeDirection()
            this@StretchView.resetInitData()
            this@StretchView.invalidate()
            Log.w("StretchView", "onAnimationEnd..")
        }
    }

    constructor(context: Context) : super(context) {
        this.init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.init()
    }

    private fun init() {
        this.animator = ValueAnimator.ofFloat(*floatArrayOf(1.0f, 0.0f))
        this.animator!!.duration = this.animDurection
        this.animator!!.addUpdateListener(this.animatorUpdateListener)
        this.animator!!.addListener(this.animatorListenerAdapter)
        this.paint = Paint(1)
        this.paint!!.color = this.color
        this.paint!!.style = Paint.Style.FILL
        this.paint!!.strokeCap = Paint.Cap.ROUND
        this.path = Path()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var circleCenter1X = this.initPosition.toFloat() + this.radius
        val circleCenter1Y = this.initHeight.toFloat() / 2.0f
        var circleCenter2X = (this.initPosition + this.initWidth).toFloat() - this.radius
        val circleCenter2Y = this.initHeight.toFloat() / 2.0f
        var p1x = circleCenter1X
        val p1y = 0.0f
        var p2x = circleCenter2X
        val p2y = 0.0f
        var p4x = circleCenter1X
        val p4y = this.initHeight.toFloat()
        var p3x = circleCenter2X
        val p3y = this.initHeight.toFloat()
        val ctrl1x: Float
        val ctrl1y: Float
        val ctrl2x: Float
        val ctrl2y: Float
        if (this.stretchDirection == DirectionLeft) {
            circleCenter1X = this.initPosition.toFloat() + this.radius - this.stretchRatio * this.stretchLength.toFloat()
            p1x = circleCenter1X
            p4x = circleCenter1X
            ctrl1x = (circleCenter1X - this.stretchRatio * this.stretchLength.toFloat() + circleCenter2X) * 0.6f
            ctrl1y = p1y + this.initHeight.toFloat() * this.verticalCtrlRatio * this.stretchRatio
            ctrl2x = (circleCenter1X - this.stretchRatio * this.stretchLength.toFloat() + circleCenter2X) * 0.6f
            ctrl2y = p4y - this.initHeight.toFloat() * this.verticalCtrlRatio * this.stretchRatio
        } else if (this.stretchDirection == DirectionRight) {
            circleCenter2X = (this.initPosition + this.initWidth).toFloat() - this.radius + this.stretchRatio * this.stretchLength.toFloat()
            p2x = circleCenter2X
            p3x = circleCenter2X
            ctrl1x = (circleCenter2X + this.stretchRatio * this.stretchLength.toFloat() + circleCenter1X) * 0.4f
            ctrl1y = p1y + this.initHeight.toFloat() * this.verticalCtrlRatio * this.stretchRatio
            ctrl2x = (circleCenter2X + this.stretchRatio * this.stretchLength.toFloat() + circleCenter1X) * 0.4f
            ctrl2y = p4y - this.initHeight.toFloat() * this.verticalCtrlRatio * this.stretchRatio
        } else {
            ctrl1x = (circleCenter1X + circleCenter2X) * 0.5f
            ctrl1y = p1y
            ctrl2x = (circleCenter2X + p3y) * 0.5f
            ctrl2y = p3y
        }

        canvas.drawCircle(circleCenter1X, circleCenter1Y, this.radius, this.paint!!)
        canvas.drawCircle(circleCenter2X, circleCenter2Y, this.radius, this.paint!!)
        this.path!!.reset()
        this.path!!.moveTo(p1x, p1y)
        this.path!!.quadTo(ctrl1x, ctrl1y, p2x, p2y)
        this.path!!.lineTo(p3x, p3y)
        this.path!!.quadTo(ctrl2x, ctrl2y, p4x, p4y)
        this.path!!.close()
        canvas.drawPath(this.path!!, this.paint!!)
    }

    private fun startAnim(): Boolean {
        this.isAnimating = true
        this.animator!!.start()
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        this.viewWidth = this.measuredWidth
        this.viewHeight = this.measuredHeight
        if (this.viewHeight > 0) {
            this.radius = (this.viewHeight / 2).toFloat()
            this.initHeight = this.viewHeight
        }

    }

    fun setColor(color: Int) {
        this.color = color
    }

    fun setInitPosition(initPosition: Int) {
        this.initPosition = initPosition
    }

    fun setInitWidth(initWidth: Int) {
        this.initWidth = initWidth
    }

    fun setParams(stretchRatio: Float, direction: Int, stretchLength: Int) {
        if (stretchLength != 0) {
            this.isAnimating = true
        }

        this.stretchRatio = stretchRatio
        this.stretchDirection = direction
        this.stretchLength = stretchLength
        this.invalidate()
    }

    fun setStretchLength(stretchLength: Int) {
        this.stretchLength = stretchLength
    }

    fun startShrink(initPosition: Int) {
        this.initPosition = initPosition
        this.changeDirection()
        this.startAnim()
    }

    private fun changeDirection() {
        if (this.stretchDirection == DirectionLeft) {
            this.stretchDirection = DirectionRight
        } else if (this.stretchDirection == DirectionRight) {
            this.stretchDirection = DirectionLeft
        }

    }

    fun resetInitData() {
        this.stretchLength = 0
        this.stretchRatio = 0.0f
        this.stretchDirection = 0
        this.isAnimating = false
    }

    companion object {
        private val TAG = "StretchView"
        var DirectionLeft = 33
        var DirectionRight = 34
    }
}
