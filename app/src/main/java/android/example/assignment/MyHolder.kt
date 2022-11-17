package android.example.assignment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageDetail : ImageView = itemView.findViewById(R.id.image)
    val nameDetail : TextView = itemView.findViewById(R.id.text)

}