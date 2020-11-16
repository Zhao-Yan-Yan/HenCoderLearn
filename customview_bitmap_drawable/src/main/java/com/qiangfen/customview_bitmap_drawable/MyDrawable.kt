package com.qiangfen.customview_bitmap_drawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/16 10:44
 */
class MyDrawable : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 5f.dp
    }
    private val offset = 80f.dp

    override fun draw(canvas: Canvas) {
        var x = bounds.left.toFloat()
        while (x < bounds.right.toFloat()) {
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), paint)
            x += offset
        }

        var y = bounds.top.toFloat()
        while (y < bounds.bottom.toFloat()) {
            canvas.drawLine(bounds.left.toFloat(), y, bounds.right.toFloat(), y, paint)
            y += offset
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }
}