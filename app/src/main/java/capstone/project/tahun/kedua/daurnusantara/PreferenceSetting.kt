package capstone.project.tahun.kedua.daurnusantara

import android.content.Context
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import capstone.project.tahun.kedua.daurnusantara.databinding.SettingPreferenceBinding

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferenceSetting : AppCompatActivity(){
    private lateinit var bind: SettingPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = SettingPreferenceBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val pref = Preference.getInstance(dataStore)
        val prefViewModel = ViewModelProvider(this, ViewModelFactorySetting(pref)).get(PreferenceViewModel::class.java)
        prefViewModel.getThemeSetting().observe(this, { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                bind.switchTheme.isChecked = true
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                bind.switchTheme.isChecked = false
            }
        })

        bind.switchTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
            prefViewModel.saveThemeSetting(isChecked)
        }
    }
}