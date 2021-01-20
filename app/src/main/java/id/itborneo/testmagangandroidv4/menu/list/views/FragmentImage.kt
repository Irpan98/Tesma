package id.itborneo.testmagangandroidv4.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.itborneo.testmagangandroidv4.databinding.FragmentImageBinding

class FragmentImage : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        fun getInstance(imageUrl: String?): Fragment {
            val bundle = Bundle()
            bundle.putString(EXTRA_DATA, imageUrl)
            val fragmentImage = FragmentImage()
            fragmentImage.arguments = bundle
            return fragmentImage
        }
    }

    private lateinit var binding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageUrl = arguments?.getString(EXTRA_DATA)
    }

}