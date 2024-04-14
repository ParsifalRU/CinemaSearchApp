package dev.ivan_belyaev.all_films_api.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.ivan_belyaev.all_films.R
import dev.ivan_belyaev.all_films_api.presentation.viewmodel.AllFilmsViewModel

class AllFilmsListAdapter(private val viewModel: AllFilmsViewModel) :
    ListAdapter<AllFilmsModel, AllFilmsListAdapter.PostersViewHolder>(AllFilmsDiffUtil) {

    class PostersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: AllFilmsModel) {
            view.findViewById<TextView>(R.id.all_films_textView).text = model.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostersViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_film_names_rec_view, viewGroup, false)
        return PostersViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostersViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        if (model.name != ""){
            holder.itemView.setOnClickListener {
                viewModel.navigateToFilmByIdScreen(model.id)
            }
        }
    }
}