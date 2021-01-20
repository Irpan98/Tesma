package id.itborneo.testmagangandroidv4.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import id.itborneo.testmagangandroidv4.databinding.FragmentSingleDetailBinding
import id.itborneo.testmagangandroidv4.menu.list.adapter.ViewPagerAdapter
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.SingleDetailViewModel
import id.itborneo.testmagangandroidv4.utils.ViewModelFragmentFactory


class FragmentSingleDetail : Fragment() {

    private lateinit var placeItem: PlaceModel
    private lateinit var itemType: String
    private lateinit var binding: FragmentSingleDetailBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val args: FragmentSingleDetailArgs by navArgs()
    private val viewModel: SingleDetailViewModel by viewModels { ViewModelFragmentFactory(args.dataPlace as PlaceModel) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        initGetDataIntent(arguments)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.place = viewModel
//        updateUI()


    }

//    private fun initGetDataIntent(arguments: Bundle?) {
//        val intentPlace = arguments?.getParcelable<PlaceModel>(EXTRA_PLACE) ?: return
//        placeItem = intentPlace
//        itemType = placeItem.type ?: "images"
//    }
//
//    private fun updateUI() {
//        placeItem.apply {
//            binding.tvTitle.text = this.title
//            binding.tvSubTitle.text = this.content
//
//        }
//
//        if (placeItem.type == "image") {
//            binding.viewPager.visibility = View.GONE
//
//            Glide.with(requireContext())
//                .load(placeItem.image)
//                .into(binding.ivDetailPlace)
//        } else {
//
//
//            viewPagerAdapter = ViewPagerAdapter(childFragmentManager, placeItem.media)
//            binding.viewPager.adapter = viewPagerAdapter
//            binding.viewPager.setPageTransformer(false, ParallaxPageTransformer())
//            binding.dotsIndicator.setViewPager(binding.viewPager)
//        }
//    }


}