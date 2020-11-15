package com.zy.customview_clip_camera

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testView = findViewById<View>(R.id.testView)
        val topFlipAnimator = ObjectAnimator.ofFloat(testView, "topFlip", -60f)
        topFlipAnimator.duration = 1500
        topFlipAnimator.startDelay = 200

        val bottomFlipAnimator = ObjectAnimator.ofFloat(testView, "bottomFlip", 60f)
        bottomFlipAnimator.duration = 1500
        bottomFlipAnimator.startDelay = 200

        val flipRotationAnimator = ObjectAnimator.ofFloat(testView, "flipRotation", 360f )
        flipRotationAnimator.duration = 3000
        flipRotationAnimator.startDelay = 200

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        animatorSet.start()
        animatorSet.addListener(
            object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    animation?.start()
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }
            }
        )
    }
}