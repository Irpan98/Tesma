package id.itborneo.testmagangandroidv4.menu.gallery.views

import android.content.res.Resources
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
import id.itborneo.testmagangandroidv4.data.EXTRA_GALLERY
import id.itborneo.testmagangandroidv4.databinding.FragmentGalleryBinding
import id.itborneo.testmagangandroidv4.menu.gallery.GridAutofitLayoutManager
import id.itborneo.testmagangandroidv4.menu.gallery.adapters.GalleryAdapter
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.menu.gallery.viewmodels.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*


class FragmentGallery : Fragment() {

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

        setupRecyclerView()
        viewModel.getGallery()
        observeData()


    }




    private fun observeData() {
        viewModel.listGallery.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun getScreenWidth() =
        Resources.getSystem().displayMetrics.widthPixels


    private fun setupRecyclerView() {

        adapter = GalleryAdapter {
            onGalleryItemClicked(it)
        }
        rvGallery.adapter = adapter
        val layoutManager = GridAutofitLayoutManager(requireContext(), getScreenWidth() / 3)
        rvGallery.layoutManager = layoutManager
    }

    private fun onGalleryItemClicked(item: GalleryModel) {
        actionMoveToDetail(item)
    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun actionMoveToDetail(item: GalleryModel) {
        val bundle = bundleOf(EXTRA_GALLERY to item)
        navController.navigate(R.id.action_galleryFragment_to_galleryDetailFragment, bundle)

    }


}