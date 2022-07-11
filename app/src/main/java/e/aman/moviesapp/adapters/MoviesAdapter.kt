package e.aman.moviesapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import e.aman.moviesapp.R
import e.aman.moviesapp.databinding.MoviesItemLayoutBinding
import e.aman.moviesapp.models.Movie

class MoviesAdapter(var ctx: Context , var list: ArrayList<Movie>): RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MoviesItemLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]

        Glide.with(ctx).load(item.image).placeholder(R.drawable.placeholder).into(holder.movieImageView)
        holder.movieNameText.text = item.title
        holder.movieYearText.text = item.year

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView:  MoviesItemLayoutBinding): RecyclerView.ViewHolder(itemView.root){
        var movieImageView = itemView.movieImage
        var movieNameText = itemView.movieTitle
        var movieYearText = itemView.movieYear
    }
}