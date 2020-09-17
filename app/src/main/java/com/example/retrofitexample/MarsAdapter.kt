package com.example.retrofitexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.model.Terrain
import kotlinx.android.synthetic.main.mars_item_list.view.*

class MarsAdapter(var mPassMars: Mars): RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {

    private var dataList = emptyList<Terrain>()

    fun updateListMars(mDataList: List<Terrain>){
        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class MarsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val imgTerrain = itemView.imageMars
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mPassMars.passMars(dataList[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.mars_item_list, parent, false)
        return MarsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {

        val mterrain : Terrain = dataList[position]
        Glide.with(holder.itemView.context).load(mterrain.imgSrc).into(holder.imgTerrain)

    }

    override fun getItemCount() = dataList.size

    interface Mars{
        fun passMars(mTerrain : Terrain)
    }

}
