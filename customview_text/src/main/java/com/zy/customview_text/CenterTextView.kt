package com.zy.customview_text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/11 19:10
 */
class CenterTextView : View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 20.dp
    }

    private val radius = 150.dp
    private var textContent = "abab"
    private val textRect = Rect()
    private val fontMetrics = Paint.FontMetrics()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE

        paint.color = Color.parseColor("#f5b461")
        canvas.drawArc(
            width / 2f - radius,
            height / 2f - radius,
            width / 2f + radius,
            height / 2f + radius,
            0f,
            360f,
            false,
            paint
        )
        paint.color = Color.parseColor("#9ad3bc")
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - radius,
            height / 2f - radius,
            width / 2f + radius,
            height / 2f + radius,
            -90f,
            225f,
            false,
            paint
        )
        paint.style = Paint.Style.FILL
        paint.textSize = 30.dp
        paint.textAlign = Paint.Align.CENTER
        paint.getTextBounds(textContent, 0, textContent.length, textRect)

        textContent = "abab"
        Log.e("TAG", "onDraw: $textRect")
        canvas.drawText(textContent, width / 2f, height / 2f + textRect.height() / 2, paint)

        textContent = "qbgyjacv"
        paint.getFontMetrics(fontMetrics)
        Log.e(
            "TAG",
            "onDraw: ${fontMetrics.ascent} , ${fontMetrics.descent} , ${fontMetrics.top} , ${fontMetrics.bottom} , ${fontMetrics.leading}"
        )
        canvas.drawText(
            textContent,
            width / 2f,
            height / 2f + (fontMetrics.descent - fontMetrics.ascent) / 2f,
            paint
        )

        textContent = "贴左上边"
        paint.getTextBounds(textContent, 0, textContent.length, textRect)
        paint.getFontMetrics(fontMetrics)
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(textContent, 0f, 0f - fontMetrics.top, paint)


        textContent = "贴左下边"
        paint.getTextBounds(textContent, 0, textContent.length, textRect)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(textContent, 0f, height.toFloat() - fontMetrics.bottom, paint)

        textContent = "贴右上边"
        paint.textAlign = Paint.Align.RIGHT
        paint.getTextBounds(textContent, 0, textContent.length, textRect)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(textContent, width.toFloat(), 0f - fontMetrics.top, paint)

        textContent = "贴右下边"
        paint.textAlign = Paint.Align.RIGHT
        paint.getTextBounds(textContent, 0, textContent.length, textRect)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(textContent, width.toFloat(), height - fontMetrics.bottom, paint)
    }
}