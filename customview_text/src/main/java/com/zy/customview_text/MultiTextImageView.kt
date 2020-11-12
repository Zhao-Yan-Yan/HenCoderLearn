package com.zy.customview_text

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import kotlin.math.max

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/11 18:37
 */
class MultiTextImageView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 18.dp
    }
    private val content: String =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget semper elit, nec laoreet ex. Nunc venenatis quam sit amet ex semper ornare. Mauris accumsan ligula in volutpat vestibulum. Aliquam nisl orci, fringilla vel feugiat eget, pharetra a velit. Nullam placerat, orci vel porttitor vehicula, odio justo porta velit, non bibendum est dui laoreet risus. Phasellus interdum, dolor et malesuada bibendum, lorem justo pretium massa, sit amet consectetur nibh eros at lectus. Sed posuere, ligula at sollicitudin maximus, nulla justo porttitor felis, id pretium augue magna non magna. Nulla facilisi. Suspendisse at ante ac odio rutrum maximus. Etiam nec urna aliquet, tincidunt odio at, fermentum tellus. Curabitur vehicula aliquam ante. Maecenas accumsan libero vel magna luctus, eu viverra ipsum malesuada."

    private val fontMetrics = Paint.FontMetrics()
    private val imageWidth = 180.dp
    private val imageXOffset = 0.dp
    private val imageYOffset = 55.dp
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.getFontMetrics(fontMetrics)
        val img = getImg(imageWidth.toInt())
        canvas.drawBitmap(img, imageXOffset, imageYOffset, paint)
        val floatArray = floatArrayOf(0f)
        var start = 0
        var count: Int
        var offset = -fontMetrics.top
        var xOffset: Float
        var maxWidth: Float
        while (start < content.length) {
            if (offset + fontMetrics.bottom < imageYOffset || offset + fontMetrics.top > img.height + imageYOffset) {
                xOffset = 0f
                maxWidth = width.toFloat()
            } else {
                xOffset = imageWidth
                maxWidth = width.toFloat()
            }

            count = paint.breakText(
                content, start, content.length, true, maxWidth - xOffset, floatArray
            )
            canvas.drawText(
                content, start, start + count, xOffset, offset, paint
            )
            start += count
            offset += paint.fontSpacing
        }
    }

    fun getImg(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.test, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.test, options)
    }
}