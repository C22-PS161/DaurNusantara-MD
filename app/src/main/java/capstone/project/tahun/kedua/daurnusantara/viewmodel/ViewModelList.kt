package capstone.project.tahun.kedua.daurnusantara.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import capstone.project.tahun.kedua.daurnusantara.api.ApiConfig
import capstone.project.tahun.kedua.daurnusantara.api.FileResponse
import capstone.project.tahun.kedua.daurnusantara.api.ListCrafts
import com.google.firebase.auth.FirebaseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelList: ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading
    val listUsers = MutableLiveData<List<ListCrafts>>()

    fun setUser(imageUrl: String) {
        val asyncClient = ApiConfig.getApiService().searchImageGet(imageUrl)
        asyncClient.enqueue(object : Callback<FileResponse> {
            override fun onResponse(
                call: Call<FileResponse>,
                response: Response<FileResponse>
            ) {
                if(response.isSuccessful) {
                   val responseBody = response.body()
                    if(responseBody != null) {
                        val listCatch = ArrayList<ListCrafts>()
                        for (each in responseBody.listCrafts) {
                            val tiap = ListCrafts(each.id, each.imageUrl, each.name, each.decription)
                            listCatch.add(tiap)
                        }
                        listUsers.postValue(listCatch)
                    }
                }
                else {
                    Log.e(TAG,"onFailure: ${response.message()}" )
                }
            }
            override fun onFailure(call: Call<FileResponse>, t: Throwable) {

            }
        })
    }

    fun getUser(): LiveData<List<ListCrafts>> {
        return listUsers
    }

    companion object {
        private val TAG = ViewModelList::class.java.simpleName
    }

}