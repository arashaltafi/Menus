package com.arash.altafi.menus.slider.slider4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.arash.altafi.menus.R
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.BaseSliderView.OnSliderClickListener
import com.daimajia.slider.library.SliderTypes.DefaultSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import kotlinx.android.synthetic.main.activity_slider4.*
import org.json.JSONArray
import org.json.JSONException
import java.util.*

class Slider4 : AppCompatActivity() , OnSliderClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider4)

        init()
    }

    private fun init() {
        val sliderImage: MutableMap<String, String> = TreeMap()
        val url = "https://arashaltafi.ir/shop/get_slider.php"
        val listener = Response.Listener<JSONArray> { response ->
                for (i in 0 until response.length()) {
                    try {
                        val jsonObject = response.getJSONObject(i)
                        val image = jsonObject.getString("image")
                        val id = jsonObject.getString("id")
                        sliderImage[id] = image
                    }
                    catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                for (j in sliderImage.keys.indices) {
                    val keyName = sliderImage.keys.toTypedArray()[j]
                    val defaultSliderView = DefaultSliderView(this)
                    defaultSliderView
                        .image(sliderImage[keyName])
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this)
                    defaultSliderView.bundle(Bundle())
                    defaultSliderView.bundle.putString("extra", keyName)
                    slider_4.addSlider(defaultSliderView)
                }
            slider_4.setPresetTransformer(SliderLayout.Transformer.Tablet)
            slider_4.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
            slider_4.setCustomAnimation(DescriptionAnimation())
            slider_4.setDuration(5000)
            }
        val errorListener = Response.ErrorListener {
            Toast.makeText(this, "خطا در اتصال", Toast.LENGTH_SHORT).show()
        }
        val request = JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener)
        MySingleton.getInstance(applicationContext)!!.addToRequestQueue(request)
    }


    override fun onSliderClick(slider: BaseSliderView?) {
        val intent = Intent(applicationContext, SecondSlider4::class.java)
        intent.putExtra("id", slider!!.bundle["extra"].toString())
        startActivity(intent)
    }

}