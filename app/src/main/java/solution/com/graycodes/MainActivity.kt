package solution.com.graycodes

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var grayCodeAdapter: GrayCodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGenerate.setOnClickListener {
            val number = etNumber.text.toString()
            generateGrayCode(number.toInt())
            etNumber.clearFocus()
            hideKeyboard(etNumber)
        }
    }

    private fun generateGrayCode(number: Int) {
        val grayCodes = GrayCodeUtils.generate(number.toInt())
        if (!::grayCodeAdapter.isInitialized) {
            grayCodeAdapter = GrayCodeAdapter(grayCodes)
            rvGrayCodes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvGrayCodes.adapter = grayCodeAdapter
        } else
            grayCodeAdapter.setData(grayCodes)
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}