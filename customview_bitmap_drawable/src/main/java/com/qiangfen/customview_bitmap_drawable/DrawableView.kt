package com.qiangfen.customview_bitmap_drawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/16 10:43
 */
class DrawableView : View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val drawable = MyDrawable()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawable.setBounds(0, 0, width, height)
        drawable.draw(canvas)
    }
}