package capstone.project.tahun.kedua.daurnusantara

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ViewModelFactorySetting (private val pref: Preference) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreferenceViewModel::class.java)){
            return PreferenceViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class: "+ modelClass.name)
    }
}