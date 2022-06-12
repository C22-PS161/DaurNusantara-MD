package capstone.project.tahun.kedua.daurnusantara

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginSession(
    @field:SerializedName("identifier")
    @Expose
    var email: String? = null,
    @field:SerializedName("password")
    @Expose
    var password: String? = null
) : Parcelable
