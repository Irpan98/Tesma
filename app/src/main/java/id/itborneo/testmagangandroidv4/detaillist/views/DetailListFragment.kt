package id.itborneo.testmagangandroidv4.detaillist.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import id.itborneo.testmagangandroidv4.data.EXTRA_PLACE
import id.itborneo.testmagangandroidv4.databinding.FragmentDetailPlaceBinding
import id.itborneo.testmagangandroidv4.networks.response.PlaceContentItem
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils
import id.itborneo.testmagangandroidv4.utils.sliderUtils.ImageSlider
import kotlinx.android.synthetic.main.fragment_detail_place.*


class DetailListFragment : Fragment() {

    private lateinit var placeItem: PlaceContentItem
    private lateinit var itemType: String
    private lateinit var binding: FragmentDetailPlaceBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailPlaceBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
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

    private fun initGetDataIntent(arguments: Bundle?) {
        val intentPlace = arguments?.getParcelable<PlaceContentItem>(EXTRA_PLACE) ?: return
        placeItem = intentPlace
        itemType = placeItem.type ?: "images"
    }

    private fun updateUI() {
        placeItem.apply {
            tvTitle.text = this.title
            tvSubTitle.text = this.content

        }

        if (placeItem.type == "image") {
            viewPager.visibility = View.GONE

            Glide.with(requireContext())
                .load(placeItem.image)
                .into(ivDetailPlace)
        } else {

            val images = placeItem.media
            val slider = images?.let {
                ImageSlider(
                    requireContext(), viewPager, SliderDots,
                    it
                )
            }
            slider?.initialize()
        }
    }

    private fun initAppbar() {
        if (itemType == "images") {
            MainViewUtils.initAppbar(requireActivity(), "Detail Single")

        } else {
            MainViewUtils.initAppbar(requireActivity(), "Detail Multiple")

        }
    }


}