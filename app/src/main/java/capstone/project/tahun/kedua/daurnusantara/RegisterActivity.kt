package capstone.project.tahun.kedua.daurnusantara

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import capstone.project.tahun.kedua.daurnusantara.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
   lateinit var binding : ActivityRegisterBinding
   lateinit var auth: FirebaseAuth

    override fun onCreate(savedIntanceState: Bundle?){
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedIntanceState)

        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.toString()

            //validasi email
            if(email.isEmpty()){
                binding.editEmail.error = "Email harus diisi"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            //validasi email yang tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editEmail.error = "Email harus diisi"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                binding.editPassword.error = "Email harus diisi"
                binding.editPassword.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email, password)
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}