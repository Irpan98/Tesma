package id.itborneo.testmagangandroidv4.detailgallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.EXTRA_GALLERY
import id.itborneo.testmagangandroidv4.databinding.FragmentGalleryDetailBinding
import id.itborneo.testmagangandroidv4.networks.response.GalleryDataItem
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils


class DetailGalleryFragment : Fragment() {

    private lateinit var galleryItem: GalleryDataItem
    private lateinit var binding: FragmentGalleryDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    private fun initGetDataIntent(arguments: Bundle?) {

        val intentPlace = arguments?.getParcelable<GalleryDataItem>(EXTRA_GALLERY) ?: return
        galleryItem = intentPlace


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
        galleryItem.apply {
            binding.tvTitle.text = this.caption


            Picasso.get()
                .load(galleryItem.image)
                .placeholder(R.drawable.loading_image)
                .fit()
                .into(binding.ivDetailPlace)
        }

    }

}