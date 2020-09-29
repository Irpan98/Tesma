package id.itborneo.testmagangandroidv4.ui.galleryDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.response.GalleryDataItem
import id.itborneo.testmagangandroidv4.utils.EXTRA_GALLERY
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils
import kotlinx.android.synthetic.main.fragment_detail_place.*


class GalleryDetailFragment : Fragment() {

    private lateinit var galleryItem: GalleryDataItem

    private val TAG = "GalleryDetailFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery_detail, container, false)
    }


    private fun initGetDataIntent(arguments: Bundle?) {

        val intentPlace = arguments?.getParcelable<GalleryDataItem>(EXTRA_GALLERY) ?: return
        galleryItem = intentPlace

        Log.d(TAG, "initGetDataIntent $galleryItem")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initGetDataIntent(arguments)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppbar()
        updateUI()
    }

    private fun initAppbar() {
        MainViewUtils.initAppbar(requireActivity(), "Detail Gallery")

    }

    private fun updateUI() {
        if (::galleryItem.isInitialized.not()) return
        Log.d(TAG, "updateUI $galleryItem")
        galleryItem.apply {
            tvTitle.text = this.caption
            Glide.with(requireContext())
                .load(galleryItem.image)
                .apply(RequestOptions().placeholder(R.drawable.loading_image))
                .into(ivDetailPlace)
        }

    }

}