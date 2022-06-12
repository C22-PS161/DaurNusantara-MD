package capstone.project.tahun.kedua.daurnusantara

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import capstone.project.tahun.kedua.daurnusantara.databinding.ActivityAkunBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AkunActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAkunBinding
    private lateinit var preferenceSession: PreferenceSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAkunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showLoading(false)

        tampil()

        binding.keluar.setOnClickListener {
            logoutNow()
            finish()
        }
    }

    private fun tampil(){
        val user = Firebase.auth.currentUser
        user?.let {
            val emaile = user.email
            binding.email.text = emaile
        }
    }

    private fun logoutNow() {
        preferenceSession = PreferenceSession(this)
        preferenceSession.sesiDelete()
        Log.d(".HomeActivity", "Periksa : ${preferenceSession.sesiGet()}")
        val toLogin = Intent(this@AkunActivity, LoginActivity::class.java)
        startActivity(toLogin)
        finish()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingBar.visibility = View.VISIBLE
        }else{
            binding.loadingBar.visibility = View.GONE
        }
    }

    companion object{
        const val OBJECT = "object"
    }
}