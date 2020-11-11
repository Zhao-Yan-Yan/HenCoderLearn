package com.zy.customview_xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/10 19:02
 */
class XfermodeView : View {

    private val modes = arrayOf(
        PorterDuff.Mode.ADD,
        PorterDuff.Mode.CLEAR,
        PorterDuff.Mode.DARKEN,
        PorterDuff.Mode.DST,
        PorterDuff.Mode.DST_ATOP,
        PorterDuff.Mode.DST_IN,
        PorterDuff.Mode.DST_OUT,
        PorterDuff.Mode.DST_OVER,
        PorterDuff.Mode.LIGHTEN,
        PorterDuff.Mode.MULTIPLY,
        PorterDuff.Mode.OVERLAY,
        PorterDuff.Mode.SCREEN,
        PorterDuff.Mode.SRC,
        PorterDuff.Mode.SRC_ATOP,
        PorterDuff.Mode.SRC_IN,
        PorterDuff.Mode.SRC_OUT,
        PorterDuff.Mode.SRC_OVER,
        PorterDuff.Mode.XOR,
    )

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private val xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }
}