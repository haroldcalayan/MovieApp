package com.haroldcalayan.movieapp.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.haroldcalayan.movieapp.BR
import com.haroldcalayan.movieapp.R
import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.databinding.AdapterMovieItemBinding

class MovieAdapter(private var data: List<MovieItem>, private var listener: MovieAdapterListener) :
    RecyclerView.Adapter<MovieAdapter.MovieAdapterAdapterViewHolder>() {

    interface MovieAdapterListener {
        fun onItemClick(item: MovieItem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapterAdapterViewHolder {
        val binding: AdapterMovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_movie_item,
            parent,
            false
        )
        return MovieAdapterAdapterViewHolder(binding)
    }

    fun sortMovieItemByTitle(item: List<MovieItem>) {
        data = item.sortedBy {
            it.title
        }
        notifyDataSetChanged()
    }

    fun sortMovieItemByReleaseDate(item: List<MovieItem>) {
        data = item.sortedBy {
            it.releaseDate
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieAdapterAdapterViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener { listener.onItemClick(data[position]) }
        if (data[position].isOnMyWatchList) {
            holder.onMyWatchListTextView.visibility = View.VISIBLE
        }
    }

    override fun getItemCount() = data.size

    class MovieAdapterAdapterViewHolder(private val binding: AdapterMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val onMyWatchListTextView = binding.textviewOnWatchList
        
        fun bind(item: MovieItem) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}