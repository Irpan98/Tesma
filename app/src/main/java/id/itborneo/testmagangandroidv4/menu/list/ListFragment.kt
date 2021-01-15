package id.itborneo.testmagangandroidv4.menu.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.EXTRA_PLACE
import id.itborneo.testmagangandroidv4.databinding.FragmentPlacesBinding
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.ListViewModel
import id.itborneo.testmagangandroidv4.networks.response.PlaceContentItem
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils


class ListFragment : Fragment() {

    private val TAG = "PlacesFragment"
    private lateinit var adapter: PlacesAdapter
    private val viewModel: ListViewModel by viewModels()

    private lateinit var navController: NavController

    private lateinit var binding: FragmentPlacesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPlacesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
////        initViewModel()
//
//
//    }


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
        binding.list = viewModel
        setupRecyclerView()
        initAppbar()
        observeData()
        initNavController(view)


    }


    private fun setupRecyclerView() {

        adapter = PlacesAdapter {
            onPlaceItemSelected(it)
        }

        binding.rvPlaces.adapter = adapter

    }

//    private fun initViewModel() {
//
////        viewModel = activity?.run {
////            ViewModelProvider(
////                this,
////                ViewModelProvider.NewInstanceFactory()
////            )[ListViewModel::class.java]
////        } ?: throw Exception("Salah Activity")
//
//    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }


    private fun updateUI(title: String, subTitle: String) {
        binding.tvTitle.text = title
        binding.tvSubTitle.text = subTitle
    }


    private fun onPlaceItemSelected(placeContentItem: PlaceContentItem) {
        actionMoveToDetail(placeContentItem)
    }


    private fun actionMoveToDetail(placeContentItem: PlaceContentItem) {
        val bundle = bundleOf(EXTRA_PLACE to placeContentItem)
        navController.navigate(R.id.action_placesFragment_to_detailPlaceFragment, bundle)

    }


    private fun observeData() {
        showLoading()
        viewModel.getPlaces().observe(requireActivity()) {
            showLoading(false)

            if (it != null) {
                it.placeData?.header?.title?.let { title ->

                    it.placeData.header.subtitle.let { subTitle ->
                        updateUI(title, subTitle ?: "")

                    }
                }

                adapter.setAllPlaces(it.placeData?.placeContent as List<PlaceContentItem>)
            }
        }
    }


}