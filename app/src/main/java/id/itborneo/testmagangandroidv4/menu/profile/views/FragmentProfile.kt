package id.itborneo.testmagangandroidv4.menu.profile.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import id.itborneo.testmagangandroidv4.databinding.FragmentProfileBinding
import id.itborneo.testmagangandroidv4.menu.profile.viewmodels.ProfileViewModel


class FragmentProfile : Fragment() {


    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profile = viewModel

        viewModel.getProfile()

//        initAppbar()

    }


//    private fun initAppbar() {
//        MainViewUtils.initAppbar(requireActivity(), "Profile")
//
//    }

}