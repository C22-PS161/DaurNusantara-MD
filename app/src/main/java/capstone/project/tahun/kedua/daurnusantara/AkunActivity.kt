package capstone.project.tahun.kedua.daurnusantara

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import capstone.project.tahun.kedua.danus.databinding.ActivityAkunBinding
import com.bumptech.glide.Glide

class AkunActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAkunBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAkunBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showLoading(true)

        val data = intent.getParcelableExtra<ListStory>(OBJECT) as DataKerajinan

        with(binding) {
            Glide.with(this@AkunActivity)
                .load(foto.photoUrl)
                .into(picture)
            nama.text = data.name
            email.text = data.email
        }
        showLoading(false)
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
