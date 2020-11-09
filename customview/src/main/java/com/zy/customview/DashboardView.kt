package com.zy.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/9 18:01
 */
class DashboardView : View {
    private val dashWidth = 5.dp
    private val dashLength = 10.dp

    private val radius = 150.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 3.dp
    }
    private val openAngle = 120f
    private var path: Path = Path()
    private var dash: Path = Path()
    private val length = 100.dp
    private lateinit var pathEffect: PathEffect

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        dash.addRect(0f, 0f, dashWidth, dashLength, Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(
            width / 2f - radius,
            height / 2f - radius,
            width / 2f + radius,
            height / 2f + radius,
            90 + openAngle / 2f,
            360 - openAngle,
        )
        val pathMeasure = PathMeasure(path, false)
        pathEffect = PathDashPathEffect(
            dash,
            (pathMeasure.length - dashWidth) / 20f,
            0f,
            PathDashPathEffect.Style.ROTATE
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)

        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null

        val x =
            length * cos(Math.toRadians(90 + openAngle / 2 + 3 * (360 - openAngle) / 20.toDouble())).toFloat()
        val y =
            length * sin(Math.toRadians(90 + openAngle / 2 + 3 * (360 - openAngle) / 20.toDouble())).toFloat()
        canvas.drawLine(
            width / 2f, height / 2f,
            width / 2f + x, height / 2f + y, paint
        )
    }

}