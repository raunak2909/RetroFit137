package gov.rajasthan.retrofit137

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gov.rajasthan.retrofit137.databinding.ColorRowBinding
import gov.rajasthan.retrofit137.model.ColorModel

class RecyclerColorAdapter
    (val context: Context,
     val arrColors : ArrayList<ColorModel>) : RecyclerView.Adapter<RecyclerColorAdapter.ViewHolder>() {
    class ViewHolder(val binding: ColorRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ColorRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrColors.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cardColor.setCardBackgroundColor(context.getColor(arrColors[position].colorPath))

        holder.binding.cardColor.setOnClickListener {

            (context as MainActivity).getColorWallpaper(arrColors[position].colorCode)

        }
    }


}