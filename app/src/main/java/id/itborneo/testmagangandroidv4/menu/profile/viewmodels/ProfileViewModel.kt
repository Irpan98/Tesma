package id.itborneo.testmagangandroidv4.menu.profile.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.testmagangandroidv4.networks.repository.ProfileRepository

class ProfileViewModel : ViewModel() {

    private val profileRepository = ProfileRepository(viewModelScope)


    var isLoading: ObservableField<Boolean> = ObservableField()

    var userName: ObservableField<String?> = ObservableField()
    var fullName: ObservableField<String?> = ObservableField()
    var email: ObservableField<String?> = ObservableField()
    var phone: ObservableField<String?> = ObservableField()
    var avatar: ObservableField<String?> = ObservableField()

    fun getProfile() {
        isLoading.set(true)
        profileRepository.getProfile({
            isLoading.set(false)

            it?.let { user ->
                userName.set(user.username)
                fullName.set(user.fullname)
                email.set(user.email)
                phone.set(user.phone)
                avatar.set(user.avatar)

            }
        }, {
            isLoading.set(false)

        })
    }


}