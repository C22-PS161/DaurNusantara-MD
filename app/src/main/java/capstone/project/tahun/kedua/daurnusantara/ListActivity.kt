package capstone.project.tahun.kedua.daurnusantara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import capstone.project.tahun.kedua.daurnusantara.adapter.AdapterCrafts
import capstone.project.tahun.kedua.daurnusantara.api.FileResponse
import capstone.project.tahun.kedua.daurnusantara.api.ListCrafts
import capstone.project.tahun.kedua.daurnusantara.databinding.ActivityListBinding
import capstone.project.tahun.kedua.daurnusantara.viewmodel.ViewModelList
import com.google.firebase.auth.FirebaseUser

class ListActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_RESULT="extra_person"
    }

    private lateinit var adapterCrafts: AdapterCrafts
    private lateinit var binding: ActivityListBinding
    private lateinit var viewModelList: ViewModelList
    private lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Hasil Pencarian"

        binding.namaKerajinan1.setOnClickListener {
            startActivity(Intent(this@ListActivity, DetailActivity::class.java))
        }

        //detailforCrafts()

        //val loginSession = intent.getParcelableExtra<LoginSession>(EXTRA_RESULT) as LoginSession
        //val users = intent.getParcelableExtra<ListCrafts>(EXTRA_RESULT) as ListCrafts
        //val layoutManager = LinearLayoutManager(this)
//        binding.listActivity.layoutManager
  //      val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
    //    binding.listActivity.addItemDecoration(itemDecoration)

      //  viewModelList.isLoading.observe(this, {
        //    showLoading(it)
       // })

        //viewModelList.setUser(loginSession.toString())
       // adapterCraftsSet()

//        viewModelList = ViewModelProvider(this@ListActivity).get(ViewModelList::class.java)

  //      viewModelList.getUser().observe(this, {
    //        adapterCrafts.setData(it)
      //      showLoading(false)
        //})
    }

    //private fun setListUserAdapter(listS: List<ListCrafts>) {
      //  val listUserItem = ArrayList<ListCrafts>()
        //for (zero in listS) {
          //  val listAdapt = ListCrafts(zero.id, zero.imageUrl, zero.name, zero.decription)
            //listUserItem.add(listAdapt)
        //}
       // val adapter = AdapterCrafts(listUserItem)
        //binding.listActivity.adapter = adapter
        //adapter.setOnItemClickCallback(object : AdapterCrafts.OnItemClickCallback {
          //  override fun onItemClicked(data: ListCrafts) {
            //    detailforCrafts(data)
            //}
        //})
        //showLoading(false)
    //}

   // private fun detailforCrafts() {
     //   startActivity(Intent(this@ListActivity, DetailActivity::class.java))
        //val intent = Intent(this@ListActivity, DetailActivity::class.java)
        //startActivity(intent)
    //}

 //   private fun getDataFromApi(query: String) {
   //     viewModelList.setUser(query)
    //}

//    private fun adapterCraftsSet() {
  //      binding.listActivity.layoutManager = LinearLayoutManager(this)
    //    adapterCrafts = AdapterCrafts()
      //  adapterCrafts.notifyDataSetChanged()
        //binding.listActivity.adapter = adapterCrafts
    //}

    //private fun showLoading(state: Boolean) {
      //  if (state == true) {
        //    binding.progressBar.visibility = View.VISIBLE
        //}
        //else {
          //  binding.progressBar.visibility = View.GONE
       // }
   // }
}