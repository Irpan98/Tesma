package id.itborneo.testmagangandroidv4.menu.gallery

import android.content.res.Resources
import android.os.Bundle
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
import id.itborneo.testmagangandroidv4.data.EXTRA_GALLERY
import id.itborneo.testmagangandroidv4.databinding.FragmentGalleryBinding
import id.itborneo.testmagangandroidv4.menu.gallery.viewmodels.GalleryViewModel
import id.itborneo.testmagangandroidv4.networks.response.GalleryDataItem
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils
import kotlinx.android.synthetic.main.fragment_gallery.*


@Suppress("UNCHECKED_CAST")
class GalleryFragment : Fragment() {

    private val viewModel: GalleryViewModel by viewModels()
    private val TAG = "GalleryFragment"
    private lateinit var adapter: GalleryAdapter
    private lateinit var navController: NavController
    private lateinit var binding: FragmentGalleryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gallery = viewModel

        initNavController(view)

//        initViewModel()
        initRecyclerView()
        initGetDataGallery()
        initAppbar()


    }

    private fun initAppbar() {
        MainViewUtils.initAppbar(requireActivity(), "Gallery")

    }

    private fun initGetDataGallery() {
        showLoading()
        viewModel.getGallery().observe(requireActivity()) {
            showLoading(false)
            if (it != null) {
                val galleryData = it.data
                adapter.setAllPlaces(it.data as List<GalleryDataItem>)
            }
        }
    }

//    private fun initViewModel() {
//
//        viewModel = activity?.run {
//            ViewModelProvider(
//                this,
//                ViewModelProvider.NewInstanceFactory()
//            )[GalleryViewModel::class.java]
//        } ?: throw Exception("Salah Activity")
//
//    }

    fun getScreenWidth() =
        Resources.getSystem().displayMetrics.widthPixels


    private fun initRecyclerView() {

        adapter = GalleryAdapter {
            onGalleryItemClicked(it)
        }
        rvGallery.adapter = adapter
        val layoutManager = GridAutofitLayoutManager(requireContext(), getScreenWidth() / 3)
        rvGallery.layoutManager = layoutManager
    }

    private fun onGalleryItemClicked(item: GalleryDataItem) {
        actionMoveToDetail(item)
    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun actionMoveToDetail(item: GalleryDataItem) {
        val bundle = bundleOf(EXTRA_GALLERY to item)
        navController.navigate(R.id.action_galleryFragment_to_galleryDetailFragment, bundle)

    }


    private fun showLoading(showIt: Boolean = true) {
        val loadingView = requireActivity().findViewById<ProgressBar>(R.id.pBLoading)

        if (showIt) {

            loadingView.visibility = View.VISIBLE
        } else {
            loadingView.visibility = View.GONE
        }
    }

}