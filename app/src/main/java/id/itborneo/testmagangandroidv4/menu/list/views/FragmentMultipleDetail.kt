package id.itborneo.testmagangandroidv4.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import id.itborneo.testmagangandroidv4.databinding.FragmentMultipleDetailBinding
import id.itborneo.testmagangandroidv4.menu.list.adapter.ViewPagerAdapter
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.MultipleDetailViewModel
import id.itborneo.testmagangandroidv4.utils.ViewModelFragmentFactory
import id.itborneo.testmagangandroidv4.utils.anim.ParallaxPageTransformer


class FragmentMultipleDetail : Fragment() {

    private lateinit var placeItem: PlaceModel
    private lateinit var itemType: String
    private lateinit var binding: FragmentMultipleDetailBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val args: FragmentMultipleDetailArgs by navArgs()
    private val viewModel: MultipleDetailViewModel by viewModels { ViewModelFragmentFactory(args.dataPlace as PlaceModel) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMultipleDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.place = viewModel
        setupMultipleImage()

    }

    private fun setupMultipleImage() {
        args.dataPlace?.media?.let {
            viewPagerAdapter = ViewPagerAdapter(childFragmentManager, it)
            binding.viewPager.adapter = viewPagerAdapter
            binding.viewPager.setPageTransformer(false, ParallaxPageTransformer())
            binding.dotsIndicator.setViewPager(binding.viewPager)
        }
    }


}