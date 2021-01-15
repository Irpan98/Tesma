package id.itborneo.testmagangandroidv4.networks.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("data")
	val userData: UserData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class UserData(

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("fullname")
	val fullname: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
