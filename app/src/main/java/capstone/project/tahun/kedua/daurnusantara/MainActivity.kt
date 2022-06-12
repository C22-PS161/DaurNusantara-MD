package capstone.project.tahun.kedua.daurnusantara

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import capstone.project.tahun.kedua.daurnusantara.api.ApiConfig
import capstone.project.tahun.kedua.daurnusantara.api.FileResponse
import capstone.project.tahun.kedua.daurnusantara.api.ListCrafts
import capstone.project.tahun.kedua.daurnusantara.databinding.ActivityMainBinding
import capstone.project.tahun.kedua.daurnusantara.viewmodel.ViewModelList
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  fileResponse: FileResponse
    private lateinit var viewModelList: ViewModelList

    private lateinit var currentPhotoPath:String

    private var getFile: File? = null

    companion object {
        const val LOGIN_SESSION = "login_session"

        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Daur Nusantara"
       // val loginSession = intent.getParcelableExtra<LoginSession>(LOGIN_SESSION) as LoginSession
       // val filee = intent.getParcelableExtra<FileResponse>(LOGIN_SESSION) as FileResponse

        showLoading(false)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }

        binding.cameraButton.setOnClickListener { startCamera() }

        binding.uploadButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, ListActivity::class.java))
        }

       // binding.uploadButton.setOnClickListener { uploadImage() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.akun -> {
                moveToAccount()
            }
            R.id.tema -> {
                moveToTheme()
            }
        }
    }

    private fun moveToTheme() {
        startActivity(Intent(this@MainActivity, PreferenceSetting::class.java))
    }

    private fun moveToAccount() {
        startActivity(Intent(this@MainActivity, AkunActivity::class.java))
    }

    private fun startCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.resolveActivity(packageManager)
        createCustomTempFile(application).also {
            val photoUri:Uri = FileProvider.getUriForFile(
                this@MainActivity,
                "capstone.project.tahun.kedua.daurnusantara",
                it
            )
            currentPhotoPath = it.absolutePath
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            launcherIntentCamera.launch(intent)
        }
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == RESULT_OK) {
            val myFile = File(currentPhotoPath)
            getFile = myFile
            val result = BitmapFactory.decodeFile(getFile?.path)
            binding.previewImageView.setImageBitmap(result)
        }
    }

    private fun uploadImage() {
        if (getFile != null) {
            showLoading(true)
            val file = reduceFileImage(getFile as File)
            val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                "photo",
                file.name,
                requestImageFile
            )

            val service = ApiConfig.getApiService().upload(imageMultipart)

            service.enqueue(object : Callback<FileResponse> {
                override fun onResponse(
                    call: Call<FileResponse>,
                    response: Response<FileResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if(responseBody != null) {
                            showLoading(false)
                            val intent = Intent(this@MainActivity, ListActivity::class.java)
                            intent.putExtra(ListActivity.EXTRA_RESULT, file)
                            startActivity(intent)
                            finish()
                        }
                    }
                    else {
                        showLoading(false)

                    }
                }
                override fun onFailure(call: Call<FileResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "gagal server", Toast.LENGTH_SHORT).show()
                }
            })
        }
        else {
            Toast.makeText(this@MainActivity, "Anda belum memasukkan berkas gambar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLoading(state: Boolean) {
        if (state == true) {
            binding.progressBar.visibility = View.VISIBLE
        }
        else {
            binding.progressBar.visibility = View.GONE
        }
    }

}