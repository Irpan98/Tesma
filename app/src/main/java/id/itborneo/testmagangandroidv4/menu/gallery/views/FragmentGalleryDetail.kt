package id.itborneo.testmagangandroidv4.menu.gallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import id.itborneo.testmagangandroidv4.data.EXTRA_GALLERY
import id.itborneo.testmagangandroidv4.databinding.FragmentGalleryDetailBinding
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.menu.gallery.viewmodels.GalleryDetailViewModel
import id.itborneo.testmagangandroidv4.utils.ViewModelFragmentFactory


class FragmentGalleryDetail : Fragment() {

    private lateinit var galleryItem: GalleryModel
    private lateinit var binding: FragmentGalleryDetailBinding

    private val viewModel: GalleryDetailViewModel by viewModels {
        ViewModelFragmentFactory(
            galleryItem
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    private fun initGetDataIntent(arguments: Bundle?) {

        val intentPlace = arguments?.getParcelable<GalleryModel>(EXTRA_GALLERY) ?: return
        galleryItem = intentPlace


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initGetDataIntent(arguments)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gallery = viewModel
    }




}