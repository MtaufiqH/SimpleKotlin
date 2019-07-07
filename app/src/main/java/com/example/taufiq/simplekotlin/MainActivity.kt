package com.example.taufiq.simplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textViewTranslationY = textView_point.translationY
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
                textView_point.text = progress.toString()

                val translationDistance = (textViewTranslationY + progress
                        * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView_point.animate().translationY(translationDistance)

                textView_point.animate().setDuration(500).rotationBy(360f)
                    .translationY(textViewTranslationY)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


        button_reset.setOnClickListener { view ->
            seekBar.progress = 0
        }

    }
}
