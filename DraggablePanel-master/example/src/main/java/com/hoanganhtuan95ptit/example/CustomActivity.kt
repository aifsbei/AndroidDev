package com.hoanganhtuan95ptit.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoanganhtuan95ptit.draggable.DraggablePanel
import com.hoanganhtuan95ptit.example.fragment.BottomFragment
import com.hoanganhtuan95ptit.example.fragment.TopFragment
import kotlinx.android.synthetic.main.activity_custom.*
import kotlinx.android.synthetic.main.layout_bottom.*

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        draggablePanel.setDraggableListener(object : DraggablePanel.DraggableListener {
            override fun onChangeState(state: DraggablePanel.State) {
            }

            override fun onChangePercent(percent: Float) {
                alpha.alpha = 1 - percent
                shadow.alpha = percent
            }

        })

        supportFragmentManager.beginTransaction().add(R.id.frameTop, TopFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.frameBottom, BottomFragment()).commit()

        btnMax.setOnClickListener { draggablePanel.maximize() }
        btnMin.setOnClickListener { draggablePanel.minimize() }
        btnClose.setOnClickListener { draggablePanel.close() }

    }
}
