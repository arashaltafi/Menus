package com.arash.altafi.menus.slider.slider5

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import com.arash.altafi.menus.databinding.ComponentItemImageSliderBinding
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource

class ImageSliderVpAdapter(
    private var errorImage: Int,
    private var placeholder: Int,
    private var textAlign: Paint.Align,
    private var scaleType: ImageView.ScaleType? = null
) : BaseAdapter<ComponentItemImageSliderBinding, BaseAdapter.VHolder<
        ComponentItemImageSliderBinding,
        Photo5>, Photo5>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ComponentItemImageSliderBinding
        get() = ComponentItemImageSliderBinding::inflate

    private var touchListener: View.OnTouchListener? = null
    var onClickListenerPlayingVideo: ((Boolean) -> Unit)? = null
    var onClickListenerShare: ((Photo5, Bitmap, String) -> Unit)? = null

    private var player: ExoPlayer? = null

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        onPause()
    }

    override fun onViewDetachedFromWindow(holder: VHolder<ComponentItemImageSliderBinding, Photo5>) {
        super.onViewDetachedFromWindow(holder)
        holder.binding?.apply {
            videoPlayer.player?.pause()
        }
    }

    override fun onViewAttachedToWindow(holder: VHolder<ComponentItemImageSliderBinding, Photo5>) {
        super.onViewAttachedToWindow(holder)
        holder.binding?.apply {
            videoPlayer.player?.pause()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(
        holder: VHolder<ComponentItemImageSliderBinding, Photo5>,
        position: Int
    ) {
        val context = holder.itemView.context
        val item = getItem(position)

        binding?.apply {
            ivImageSlider.toShow()

            Glide
                .with(context)
                .load(item.imageUrl)
                .placeholder(placeholder)
                .error(errorImage)
                .into(ivImageSlider)

            val isVideo = item.videoUrl.isNullOrEmpty().not()

            if (item.videoUrl?.isNotEmpty() == true) {
                llClick.toGone()
                visualizer.toGone()
                if (player?.isPlaying == true && videoPlayer.isShow()) {
                    ivImagePlayer.toGone()
                    ivFullScreen.toGone()
                    ivShare.toGone()
                } else {
                    ivImagePlayer.setIcon(R.drawable.ic_play)
                    ivImagePlayer.toShow()
                    ivFullScreen.toShow()
                    ivShare.toShow()
                }
            } else if (item.audioUrl?.isNotEmpty() == true) {
                llClick.toGone()
                if (player?.isPlaying == true && videoPlayer.isShow()) {
                    ivImagePlayer.toGone()
                    ivFullScreen.toGone()
                    ivShare.toGone()
                } else {
                    ivImagePlayer.setIcon(R.drawable.ic_baseline_audiotrack_24)
                    ivImagePlayer.toShow()
                    ivFullScreen.toShow()
                    ivShare.toShow()
                }
            } else {
                ivImagePlayer.toGone()
                ivFullScreen.toGone()
                ivShare.toGone()

                if (item.hasUrlOrAction == true) {
                    llClick.toShow()
                    tvHelper.text = "Press ..."
                } else
                    llClick.toGone()
            }

            llClick.setOnClickListener {
                ivImageSlider.performClick()
            }

            ivShare.setOnClickListener {
                val url = if (isVideo) item.videoUrl else item.audioUrl
                url?.let {
                    onClickListenerShare?.invoke(item, ivImageSlider.drawable.toBitmap(), url)
                }
            }

            ivFullScreen.setOnClickListener {
                //TODO Open Media in New Page
            }

            videoPlayer.setFullscreenButtonClickListener {
                videoPlayer.player?.pause()
                player?.pause()
                //TODO Open Media in New Page
            }

            ivImagePlayer.setOnClickListener {
                val trackSelector = DefaultTrackSelector(context)
                player = ExoPlayer.Builder(context)
                    .setTrackSelector(trackSelector)
                    .setSeekBackIncrementMs(5000)
                    .setSeekForwardIncrementMs(10000)
                    .build()

                val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(context)

                val mediaSource: ProgressiveMediaSource = if (isVideo)
                    ProgressiveMediaSource.Factory(dataSourceFactory)
                        .createMediaSource(MediaItem.fromUri(item.videoUrl.toString()))
                else
                    ProgressiveMediaSource.Factory(dataSourceFactory)
                        .createMediaSource(MediaItem.fromUri(item.audioUrl.toString()))

                onClickListenerPlayingVideo?.invoke(true)

                if (item.title.isNotEmpty()) {
                    tvTitle.toShow()
                    tvTitle.text = item.title
                } else
                    tvTitle.toGone()

                videoPlayer.toShow()
                ivImageSlider.toGone()
                ivImagePlayer.toGone()
                ivShare.toGone()
                ivFullScreen.toGone()

                player?.setMediaSource(mediaSource)
                player?.prepare()
                player?.playWhenReady = true

                videoPlayer.player = player
                videoPlayer.requestFocus()
                videoPlayer.setShowFastForwardButton(true)
                videoPlayer.setShowNextButton(false)
                videoPlayer.setShowPreviousButton(false)
                videoPlayer.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT
                if (isVideo.not()) {
                    ivBackground.toShow()

                    Glide
                        .with(context)
                        .load(item.imageUrl)
                        .placeholder(placeholder)
                        .error(errorImage)
                        .into(ivBackground)

                    videoPlayer.useArtwork = false
                } else {
                    ivBackground.toGone()
                    videoPlayer.useArtwork = true
                }
                player?.addListener(object : Player.Listener {
                    override fun onIsPlayingChanged(isPlaying: Boolean) {
                        super.onIsPlayingChanged(isPlaying)
                        if (isPlaying) {
                            onPlay()
                            onClickListenerPlayingVideo?.invoke(true)
                            runAfter(500, {
                                visualizer.resumeAnimation()
                            })
                        } else {
                            onPause()
                            visualizer.pauseAnimation()
                        }
                    }

                    override fun onPlaybackStateChanged(state: Int) {
                        when (state) {
                            Player.STATE_BUFFERING -> {
                                onClickListenerPlayingVideo?.invoke(true)
                                progressBar.toShow()
                            }
                            Player.STATE_READY -> {
                                onClickListenerPlayingVideo?.invoke(true)
                                progressBar.toGone()
                            }
                            Player.STATE_ENDED -> {
                                onClickListenerPlayingVideo?.invoke(false)
                                videoPlayer.toGone()
                                ivImageSlider.toShow()
                                ivImagePlayer.toShow()
                                ivFullScreen.toShow()
                                ivShare.toShow()
                            }
                            Player.STATE_IDLE -> {
                                onClickListenerPlayingVideo?.invoke(false)
                                videoPlayer.toGone()
                                ivImageSlider.toShow()
                                ivImagePlayer.toShow()
                                ivFullScreen.toShow()
                                ivShare.toShow()
                            }
                            Player.COMMAND_INVALID -> {
                                onClickListenerPlayingVideo?.invoke(false)
                                videoPlayer.toGone()
                                ivImageSlider.toShow()
                                ivImagePlayer.toShow()
                                ivFullScreen.toShow()
                                ivShare.toShow()
                            }
                            else -> {}
                        }
                    }
                })
            }

            ivImageSlider.setOnClickListener { onClickListener?.invoke(item) }

            if (touchListener != null) {
                ivImageSlider.setOnTouchListener { v, event ->
                    touchListener?.onTouch(v, event)
                    false
                }
            }
        }
    }

    /**
     * Set touch listener for listen to image touch
     *
     * @param  touchListener  interface callback
     */
    fun setTouchListener(touchListener: View.OnTouchListener) {
        this.touchListener = touchListener
    }

    fun onPlay() {
        binding?.apply {
            videoPlayer.player?.playWhenReady
        }
    }

    fun onPause() {
        binding?.apply {
            videoPlayer.player?.pause()
            player?.pause()
        }
    }

    fun onDestroy() {
        binding?.apply {
            videoPlayer.player?.release()
            player?.release()
            videoPlayer.player?.pause()
        }
    }

}