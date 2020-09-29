package id.itborneo.testmagangandroidv4.ui.placesDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.response.PlaceContentItem
import id.itborneo.testmagangandroidv4.utils.EXTRA_PLACE
import id.itborneo.testmagangandroidv4.utils.SliderUtils.PlaceDetailSlider
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils
import kotlinx.android.synthetic.main.fragment_detail_place.*


class DetailPlaceFragment : Fragment() {

    private val TAG = "DetailPlaceFragment"
    private lateinit var placeItem: PlaceContentItem
    private lateinit var itemType: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_place, container, false)
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
        Log.d(TAG, "updateUI $placeItem")
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
                PlaceDetailSlider(
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