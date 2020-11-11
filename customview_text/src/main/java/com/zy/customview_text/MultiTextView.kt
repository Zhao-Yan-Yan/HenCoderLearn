package com.zy.customview_text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/11 18:37
 */
class MultiTextView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 18.dp
    }
    private val content =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget semper elit, nec laoreet ex. Nunc venenatis quam sit amet ex semper ornare. Mauris accumsan ligula in volutpat vestibulum. Aliquam nisl orci, fringilla vel feugiat eget, pharetra a velit. Nullam placerat, orci vel porttitor vehicula, odio justo porta velit, non bibendum est dui laoreet risus. Phasellus interdum, dolor et malesuada bibendum, lorem justo pretium massa, sit amet consectetur nibh eros at lectus. Sed posuere, ligula at sollicitudin maximus, nulla justo porttitor felis, id pretium augue magna non magna. Nulla facilisi. Suspendisse at ante ac odio rutrum maximus. Etiam nec urna aliquet, tincidunt odio at, fermentum tellus. Curabitur vehicula aliquam ante. Maecenas accumsan libero vel magna luctus, eu viverra ipsum malesuada."

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
        val staticLayout = StaticLayout.Builder.obtain(content, 0, content.length, textPaint, width)
            .setAlignment(Layout.Alignment.ALIGN_NORMAL)
            .setLineSpacing(0f, 1.2f)
            .setIncludePad(true)
            .setEllipsize(TextUtils.TruncateAt.END)
            .build()
        staticLayout.draw(canvas)
    }
}