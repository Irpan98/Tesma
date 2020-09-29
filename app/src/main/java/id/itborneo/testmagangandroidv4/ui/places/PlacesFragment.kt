package id.itborneo.testmagangandroidv4.ui.places

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.response.PlaceContentItem
import id.itborneo.testmagangandroidv4.ui.MainViewModel
import id.itborneo.testmagangandroidv4.utils.EXTRA_PLACE
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils
import kotlinx.android.synthetic.main.fragment_places.*


class PlacesFragment : Fragment() {

    private val TAG = "PlacesFragment"
    private lateinit var adapter: PlacesAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()


    }


    private fun showLoading(showIt: Boolean = true) {
        val loadingView = requireActivity().findViewById<ProgressBar>(R.id.pBLoading)

        if (showIt) {

            loadingView.visibility = View.VISIBLE
        } else {
            loadingView.visibility = View.GONE
        }
    }

    private fun initAppbar() {
        MainViewUtils.initAppbar(requireActivity(), "List", false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initAppbar()
        getPlaces()
        initNavController(view)


    }


    private fun initRecyclerView() {
        rvPlaces.layoutManager = LinearLayoutManager(requireContext())
        adapter = PlacesAdapter {
            onPlaceItemSelected(it)
        }
        rvPlaces.adapter = adapter

    }

    private fun initViewModel() {

        viewModel = activity?.run {
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MainViewModel::class.java]
        } ?: throw Exception("Salah Activity")

    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }


    private fun updateUI(title: String, subTitle: String) {
        tvTitle.text = title
        tvSubTitle.text = subTitle
    }


    private fun onPlaceItemSelected(placeContentItem: PlaceContentItem) {
        actionMoveToDetail(placeContentItem)
    }


    private fun actionMoveToDetail(placeContentItem: PlaceContentItem) {
        val bundle = bundleOf(EXTRA_PLACE to placeContentItem)
        navController.navigate(R.id.action_placesFragment_to_detailPlaceFragment, bundle)

    }


    private fun getPlaces() {
        showLoading()
        viewModel.getPlaces().observe(requireActivity()) {
            showLoading(false)

            Log.d(TAG, "getPlaces $it")
            if (it != null) {
                it.placeData?.header?.title?.let { title ->

                    it.placeData.header.subtitle.let { subTitle ->
                        updateUI(title ?: "", subTitle ?: "")

                    }
                }

                adapter.setAllPlaces(it.placeData?.placeContent as List<PlaceContentItem>)
            }
        }
    }


}