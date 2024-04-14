package dev.ivan_belyaev.film_by_id.presentation.adapter.film_reviews

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.ivan_belyaev.filmbyid.R

class ReviewsListAdapter  :
    ListAdapter<ReviewsModel, ReviewsListAdapter.ReviewsViewHolder>(ReviewsDiffUtil) {

    class ReviewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: ReviewsModel) {
            try {
                view.findViewById<TextView>(R.id.textViewTitle).text = model.title
                view.findViewById<TextView>(R.id.textViewAuthor).text = model.author
                view.findViewById<TextView>(R.id.textViewType).text = model.type
                view.findViewById<TextView>(R.id.textViewData).text = model.date.removeRange(10, 24)
                view.findViewById<TextView>(R.id.textViewReview).text = model.review
            } catch (e: Exception) {
                Log.d("LOGTAG", e.toString() + e.cause + e.message)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReviewsViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_reviews_rec_view, viewGroup, false)
        return ReviewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }
}