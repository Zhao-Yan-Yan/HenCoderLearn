package com.zy.customview_clip_camera

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/15 13:43
 */
class EffectView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera()
    private val bitmap = getBitmap(300.dp.toInt())

    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }
    var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //上
        canvas.save()
        canvas.translate(width / 2f, height / 2f)
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(
            -bitmap.width / 2f * 2,
            -bitmap.height / 2f * 2,
            bitmap.width / 2f * 2,
            0f * 2
        )
        canvas.rotate(flipRotation)
        canvas.translate(-width / 2f, -height / 2f)
        canvas.drawBitmap(
            bitmap,
            width / 2f - bitmap.width / 2f,
            height / 2f - bitmap.height / 2f,
            paint
        )
        canvas.restore()

        //下
        canvas.save()
        canvas.translate(width / 2f, height / 2f)
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(
            -bitmap.width / 2f * 2,
            0f * 2,
            bitmap.width / 2f * 2,
            bitmap.height / 2f * 2,
        )
        canvas.rotate(flipRotation)
        canvas.translate(-width / 2f, -height / 2f)
        canvas.drawBitmap(
            bitmap,
            width / 2f - bitmap.width / 2f,
            height / 2f - bitmap.height / 2f,
            paint
        )

        canvas.restore()
    }

    fun getBitmap(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.test, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.test, options)
    }
}