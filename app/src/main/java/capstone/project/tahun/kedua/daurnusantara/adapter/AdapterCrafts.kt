package capstone.project.tahun.kedua.daurnusantara.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import capstone.project.tahun.kedua.daurnusantara.DetailActivity
import capstone.project.tahun.kedua.daurnusantara.api.FileResponse
import capstone.project.tahun.kedua.daurnusantara.api.ListCrafts
import capstone.project.tahun.kedua.daurnusantara.databinding.AdapterCraftsBinding
import com.bumptech.glide.Glide

class AdapterCrafts :RecyclerView.Adapter<AdapterCrafts.ListViewHolder>(){
    var mList = ArrayList<ListCrafts>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(listCrafts: List<ListCrafts>) {
        mList.clear()
        mList.addAll(listCrafts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val bindingLayer = AdapterCraftsBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        return ListViewHolder(bindingLayer)
    }

    override fun onBindViewHolder(holder: AdapterCrafts.ListViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int = mList.size

    inner class ListViewHolder(private val binding: AdapterCraftsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listCrafts: ListCrafts) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(listCrafts.imageUrl)
                    .into(kerjainan)
                namaKerajinan.text = listCrafts.name

                //itemView.setOnClickListener {
                  //  val intent = Intent(itemView.context, DetailActivity::class.java)
                    //intent.putExtra(DetailActivity.OBJECT, listCrafts)
                    //itemView.context.startActivity(intent)
               // }
            }
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data : ListCrafts)
    }

}