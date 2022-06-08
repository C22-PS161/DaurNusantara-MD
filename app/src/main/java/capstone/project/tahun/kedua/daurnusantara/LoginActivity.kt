package capstone.project.tahun.kedua.daurnusantaranus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import capstone.project.tahun.kedua.daurnusantara.EmailEditText
import capstone.project.tahun.kedua.daurnusantara.PasswordEditText
import capstone.project.tahun.kedua.daurnusantara.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var passwordEditText: PasswordEditText
    private lateinit var emailEditText: EmailEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Masuk"
        showLoading(false)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        passwordEditText = PasswordEditText(this)
        emailEditText = EmailEditText(this)
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingBar.visibility = View.VISIBLE
        }else{
            binding.loadingBar.visibility = View.GONE
        }
    }
}