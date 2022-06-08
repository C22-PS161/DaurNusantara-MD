package capstone.project.tahun.kedua.daurnusantara.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import capstone.project.tahun.kedua.daurnusantara.databinding.AdapterStoriesBinding
import com.bumptech.glide.Glide

class AdapterStories: RecyclerView.Adapter<AdapterStories.ListViewHolder>() {
    var mStories = ArrayList<>()

    fun dataSet(listStory: List<>){
        mStories.clear()
        mStories.addAll(listStory)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val bindLayer = AdapterStoriesBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        return ListViewHolder(bindLayer)
    }

    override fun onBindViewHolder(holder: AdapterStories.ListViewHolder, position: Int) {
        holder.bind(mStories[position])
    }

    override fun getItemCount(): Int = mStories.size

    inner class ListViewHolder(private val binding: AdapterStoriesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            with(binding) {
                Glide.with(itemView.context)
                    .load(.photoUrl)
                    .into(kerjainan)
                namaKerajinan.text = .name

                val compat: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    itemView.context as Activity,
                    Pair(binding.kerjainan, "imgTrans"),
                    Pair(binding.namaKerajinan, "username")
                )

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailStoryActivity::class.java)
                    intent.putExtra(DetailStoryActivity.OBJECT, )
                    itemView.context.startActivity(intent, compat.toBundle())
                }
            }
        }
    }
}