package com.arash.altafi.menus.slider.slider7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_slider7.*

class Slider7 : AppCompatActivity() {

    private val adapterTrending: TrendingAdapter = TrendingAdapter()
    private var modelTrending: ArrayList<Photo7> = arrayListOf()
    private val helper: SnapHelper = LinearSnapHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider7)

        init()
    }

    private fun init() {
        helper.attachToRecyclerView(trendingRecyclerview)

        modelTrending.add((Photo7("جومانجی 1", "https://arashaltafi.ir/Movie/banner/jomanji1.jpg")))
        modelTrending.add((Photo7("جومانجی 2", "https://arashaltafi.ir/Movie/banner/jomanji2.jpg")))
        modelTrending.add((Photo7("جومانجی 3", "https://arashaltafi.ir/Movie/banner/jomanji3.jpg")))
        modelTrending.add((Photo7("سریع و خشن", "https://arashaltafi.ir/Movie/banner/FastandFurious.jpg")))
        modelTrending.add((Photo7("Break", "https://arashaltafi.ir/Movie/banner/Break.jpg")))
        modelTrending.add((Photo7("Outlaw King", "https://arashaltafi.ir/Movie/banner/the-outlaw.jpg")))
        modelTrending.add((Photo7("The Hunt", "https://arashaltafi.ir/Movie/banner/the_hunt.jpg")))
        modelTrending.add((Photo7("Bloodshot", "https://arashaltafi.ir/Movie/banner/BloodshotMovieReview.jpg")))
        modelTrending.add((Photo7("Sputnik", "https://arashaltafi.ir/Movie/banner/Sputnik.jpg")))
        modelTrending.add((Photo7("The New Mutants", "https://arashaltafi.ir/Movie/banner/The_New_Mutants_2020_2.jpg")))
        modelTrending.add((Photo7("Cosmoball", "https://arashaltafi.ir/Movie/banner/Cosmoball_2020.jpg")))
        modelTrending.add((Photo7("Come Away", "https://arashaltafi.ir/Movie/banner/Come_Away_1.jpg")))
        modelTrending.add((Photo7("Tenet", "https://arashaltafi.ir/Movie/banner/tenet_2020.jpg")))
        modelTrending.add((Photo7("The Nest", "https://arashaltafi.ir/Movie/banner/TheNest_2020.jpg")))
        modelTrending.add((Photo7("Soul", "https://arashaltafi.ir/Movie/banner/Soul_2020.jpg")))
        modelTrending.add((Photo7("The Rifleman", "https://arashaltafi.ir/Movie/banner/The_Rifleman_2019.jpg")))
        modelTrending.add((Photo7("Cruella", "https://arashaltafi.ir/Movie/banner/Cruella_1.jpg")))

        adapterTrending.setTrends(modelTrending)
        trendingRecyclerview.apply {
            adapter = adapterTrending
            set3DItem(true)
            setInfinite(true)
            setIntervalRatio(5F)
            setAlpha(false)
            setFlat(false)
        }
    }

}