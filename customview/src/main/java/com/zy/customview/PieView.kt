package com.zy.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/9 17:19
 */
class PieView : View {

    private val angles = listOf(
        120f, 40f, 60f, 100f, 40f
    )

    private val colors = listOf(
        "#9ad3bc", "#f3eac2", "#f5b461", "#ec524b", "#cad315"
    )

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val radius = 150.dp
    private val offset = 20.dp
    private val currentSelect = 0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var startAngle = 0f
        for ((index, angle) in angles.withIndex()) {
            paint.color = Color.parseColor(colors[index])

            if (index == currentSelect) {
                canvas.save()
                canvas.translate(
                    offset * cos(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat(),
                    offset * sin(Math.toRadians(startAngle + angle / 2f.toDouble()).toFloat())
                )
            }

            canvas.drawArc(
                width / 2f - radius,
                height / 2f - radius,
                width / 2f + radius,
                height / 2f + radius,
                startAngle,
                angle,
                true,
                paint
            )
            startAngle += angle

            if (index == currentSelect) {
                canvas.restore()
            }
        }
    }
}