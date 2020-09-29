package id.itborneo.testmagangandroidv4.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.response.UserData
import id.itborneo.testmagangandroidv4.ui.main.MainViewModel
import id.itborneo.testmagangandroidv4.utils.main.MainViewUtils
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private val TAG = "ProfileFragment"
    private lateinit var viewModel: MainViewModel
    private lateinit var user: UserData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initGetDataUser()
        initAppbar()

    }

    private fun initViewModel() {

        viewModel = activity?.run {
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MainViewModel::class.java]
        } ?: throw Exception("Salah Activity")

    }

    private fun initGetDataUser() {
        viewModel.getUser().observe(requireActivity()) {
            Log.d(TAG, "getUser $it")
            if (it != null) {
                user = it.userData ?: return@observe
                updateUI()
            }
        }
    }

    private fun updateUI() {
        if (::user.isInitialized.not()) return

        user.apply {
            tvName.text = user.username
            tvFullName.text = user.fullname
            tvEmail.text = user.email
            tvPhoneNumber.text = user.phone
            Glide.with(requireContext())
                .load(avatar)
                .circleCrop()
                .into(ivProfil)
        }


    }

    private fun initAppbar() {
        MainViewUtils.initAppbar(requireActivity(), "Profile")

    }

}