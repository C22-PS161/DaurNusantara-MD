package capstone.project.tahun.kedua.daurnusantara.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

@Parcelize
data class FileResponse(
   @field:SerializedName("crafts")
   val listCrafts: List<ListCrafts>
):Parcelable

@Parcelize
data class ListCrafts (
    @field:SerializedName("ID")
    val id: Int,

    @field:SerializedName("imageUrl")
    val imageUrl: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val decription: String
    ) : Parcelable


interface ApiService {
    @GET("/vision")
    fun searchImageGet(
        @Query("q") imageUrl: String
    ): Call<FileResponse>

    @Multipart
    @POST("/vision")
    fun upload(
        @Part file: MultipartBody.Part
    ): Call<FileResponse>
}