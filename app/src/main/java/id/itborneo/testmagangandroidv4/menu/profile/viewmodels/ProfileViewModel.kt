package id.itborneo.testmagangandroidv4.menu.profile.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.testmagangandroidv4.networks.RemoteDataSource
import id.itborneo.testmagangandroidv4.networks.repository.ProfileRepository
import id.itborneo.testmagangandroidv4.networks.response.UserResponse

class ProfileViewModel : ViewModel() {

    private val repo = ProfileRepository.getInstance(RemoteDataSource.getInstance())
//    private lateinit var user: LiveData<UserResponse>

    var isLoading: ObservableField<Boolean> = ObservableField()

    var userName: ObservableField<String?> = ObservableField()
    var fullName: ObservableField<String?> = ObservableField()
    var email: ObservableField<String?> = ObservableField()
    var phone: ObservableField<String?> = ObservableField()
    var avatar: ObservableField<String?> = ObservableField()

    fun getProfile() {
        isLoading.set(true)
        repo.getUser {
            it.userData.let { user ->
                userName.set(user?.username)
                fullName.set(user?.fullname)
                email.set(user?.email)
                phone.set(user?.phone)
                avatar.set(user?.avatar)

            }
        }
    }


}