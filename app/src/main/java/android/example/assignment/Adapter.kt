package android.example.assignment

import android.content.Context
import android.example.assignment.model.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class Adapter(val context: Context, val dataList: List<Data>) : RecyclerView.Adapter<MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyHolder(view)
    }
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val data = dataList[position]

        holder.nameDetail.text = data.name
        Glide.with(context).load(data.icon).error(R.drawable.facebook_image).into(holder.imageDetail)

    }
    override fun getItemCount(): Int {
            return dataList.size
    }


}