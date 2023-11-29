package gov.rajasthan.retrofit137

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gov.rajasthan.retrofit137.databinding.WallRowBinding
import gov.rajasthan.retrofit137.model.WallpaperModel

class RecyclerWallAdapter(val context: Context, val arrWalls: ArrayList<WallpaperModel>) : RecyclerView.Adapter<RecyclerWallAdapter.ViewHolder>() {
    class ViewHolder(val binding: WallRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WallRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrWalls.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(arrWalls[position].src!!.portrait).into(holder.binding.imgWall)
    }
}