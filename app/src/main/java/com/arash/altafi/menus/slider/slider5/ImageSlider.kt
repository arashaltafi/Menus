package com.arash.altafi.menus.slider.slider5

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager2.widget.ViewPager2
import com.arash.altafi.menus.R
import com.arash.altafi.menus.databinding.ComponentImageSliderBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

@SuppressLint("ClickableViewAccessibility")
class ImageSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var viewPagerAdapter: ImageSliderVpAdapter? = null

    private var currentPage = 0
    private var imageData: List<Photo5> = listOf()

    private var period: Long = 0
    private var delay: Long = 0
    private var autoCycle = false

    private var selectedDot = 0
    private var unselectedDot = 0
    private var errorImage = 0
    private var placeholder = 0
    private var textAlign = Paint.Align.CENTER
    private var indicatorAlign = Paint.Align.CENTER
    private var swipeTimer = Timer()

    private var itemChangeListener: ItemChangeListener? = null
    private var touchListener: OnTouchListener? = null

    private var binding: ComponentImageSliderBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = ComponentImageSliderBinding.inflate(inflater, this, true)


        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ImageSlider,
            defStyleAttr,
            defStyleAttr
        )

        period = typedArray.getInt(R.styleable.ImageSlider_is_period, 1000).toLong()
        delay = typedArray.getInt(R.styleable.ImageSlider_is_delay, 1000).toLong()
        autoCycle = typedArray.getBoolean(R.styleable.ImageSlider_is_auto_cycle, false)
        placeholder =
            typedArray.getResourceId(
                R.styleable.ImageSlider_is_placeholder,
                R.drawable.bit_placeholder_image
            )
        errorImage =
            typedArray.getResourceId(
                R.styleable.ImageSlider_is_error_image,
                R.drawable.bit_error_image
            )
        selectedDot = typedArray.getResourceId(
            R.styleable.ImageSlider_is_selected_dot,
            R.drawable.tab_layout_indicator_selected
        )
        unselectedDot = typedArray.getResourceId(
            R.styleable.ImageSlider_is_unselected_dot,
            R.drawable.tab_layout_indicator_default
        )

        textAlign = typedArray.getEnum(
            R.styleable.ImageSlider_is_text_align,
            Paint.Align.CENTER
        )

        indicatorAlign = typedArray.getEnum(
            R.styleable.ImageSlider_is_indicator_align,
            Paint.Align.CENTER
        )

        if (touchListener != null) {
            binding.vpImageSlider.setOnTouchListener { v, event ->
                touchListener!!.onTouch(v, event)
                false
            }
        }

    }

    /**
     * Set image list to adapter.
     *
     * @param  imageList  the image list by user
     */
    fun setImageList(imageList: List<Photo5>, scaleType: ImageView.ScaleType? = null) {
            imageData = imageList

            viewPagerAdapter = ImageSliderVpAdapter(
                errorImage,
                placeholder,
                textAlign,
                scaleType
            ).also {
                binding.vpImageSlider.adapter = it
                it.submitList(imageList)
            }

            setupDots()
            if (autoCycle) {
                startSliding()
            }

    }

    private fun setupDots() = binding.apply {
        TabLayoutMediator(tlImageSlider, vpImageSlider) { tab, _ ->
            tab.text = ""
        }.attach()

        vpImageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage = position
                if (itemChangeListener != null) itemChangeListener!!.onItemChanged(position)
                startSliding()
            }

        })
    }

    /**
     * Start image sliding.
     *
     * @param  changeablePeriod  optional period value
     */
    fun startSliding(changeablePeriod: Long = period) {
        stopSliding()
        scheduleTimer(changeablePeriod)
    }

    /**
     * Stop image sliding.
     *
     */
    fun stopSliding() {
        swipeTimer.cancel()
        swipeTimer.purge()
    }

    private fun scheduleTimer(period: Long) {
        val update = Runnable {
            val lastIndex = imageData.lastIndex
            if (currentPage > lastIndex) {
                currentPage = 0
            }
            binding.vpImageSlider.setCurrentItem(currentPage++, true)
        }

        swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                post(update)
            }
        }, delay, period)
    }

    /**
     * Set item click listener for listen to image click
     *
     * @param  itemClickListener  interface callback
     */
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        viewPagerAdapter?.onClickListener = { item ->
            itemClickListener.onItemSelected(
                imageData.indexOfFirst { it.id == item.id }
            )
        }
    }

    /**
     * Set item change listener for listen to image click
     *
     * @param  itemChangeListener  interface callback
     */
    fun setItemChangeListener(itemChangeListener: ItemChangeListener) {
        this.itemChangeListener = itemChangeListener
    }

    /**
     * Set touch listener for listen to image touch
     *
     * @param  touchListener  interface callback
     */
    fun setTouchListener(touchListener: OnTouchListener) {
        this.touchListener = touchListener
        this.viewPagerAdapter!!.setTouchListener(touchListener)
    }

}