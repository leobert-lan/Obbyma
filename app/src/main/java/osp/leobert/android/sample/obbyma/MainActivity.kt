package osp.leobert.android.sample.obbyma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import osp.leobert.android.sample.obbyma.cases.BooleanCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val booleanCase by lazy { BooleanCase() }

    fun booleanCase(view: View) {
        booleanCase.startCase()
    }
}