package com.qiangfen.customview_bitmap_drawable

import android.content.res.Resources
import android.util.TypedValue

/**
 * @ProjectName: HenCoderLearn
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/11/16 10:49
 */

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )