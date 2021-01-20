package id.itborneo.testmagangandroidv4.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.EXTRA_PLACE
import id.itborneo.testmagangandroidv4.databinding.FragmentListBinding
import id.itborneo.testmagangandroidv4.menu.list.adapter.ListPlaceAdapter
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.ListViewModel


class FragmentList : Fragment() {

    private val TAG = "PlacesFragment"
    private lateinit var adapter: ListPlaceAdapter
    private val viewModel: ListViewModel by viewModels()

    private lateinit var navController: NavController

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list = viewModel
        setupRecyclerView()

        viewModel.getListPlace()
        observeData()
        initNavController(view)

    }


    private fun setupRecyclerView() {

        adapter = ListPlaceAdapter {
            onPlaceItemSelected(it)
        }

        binding.rvPlaces.adapter = adapter

    }


    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }


    private fun onPlaceItemSelected(placeContentItem: PlaceModel) {
        actionMoveToDetail(placeContentItem)
    }


    private fun actionMoveToDetail(placeContentItem: PlaceModel) {
        val bundle = bundleOf(EXTRA_PLACE to placeContentItem)
        navController.navigate(R.id.action_placesFragment_to_detailPlaceFragment, bundle)

    }


    private fun observeData() {

        viewModel.listPlace.observe(viewLifecycleOwner, {
            val list = arrayListOf<Any>()
            list.clear()
            it?.let {
                list.add(it.header as Any)
                list.addAll(it.content as List<Any>)
                adapter.submitList(list)
            }
        })
//        showLoading()
//        viewModel.getPlaces().observe(requireActivity()) {
//            showLoading(false)
//
//            if (it != null) {
//                it.placeData?.header?.title?.let { title ->
//
//                    it.placeData.header.subtitle.let { subTitle ->
//                        updateUI(title, subTitle ?: "")
//
//                    }
//                }
//
//                adapter.submitList(it.placeData?.placeContent as List<PlaceContentItem>)
//
//
////                adapter.setAllPlaces()
//            }
//        }
    }


}