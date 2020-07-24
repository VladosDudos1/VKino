package vlados.dudos.vkino.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.filter_view.view.*
import vlados.dudos.vkino.Case.filterId
import vlados.dudos.vkino.R
import vlados.dudos.vkino.models.Genre

class FilterAdapter(val list: List<Genre>, val onClickListaner: OnClickListener) :
    RecyclerView.Adapter<FilterAdapter.FilterView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterView {
        return FilterView(
            LayoutInflater.from(parent.context).inflate(
                R.layout.filter_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilterView, position: Int) {

        if (position == 0) {
            holder.itemView.filter_img.visibility = View.VISIBLE
            holder.itemView.text_filter.visibility = View.GONE
        } else {
            holder.itemView.text_filter.visibility = View.VISIBLE
            holder.itemView.filter_img.visibility = View.GONE
            holder.itemView.text_filter.text = list[position].name.capitalize()

        }

        holder.itemView.fr.setOnClickListener {
            onClickListaner.click(list[position])

            if (position == 0) {

            } else {
                filterId = list[position].id
            }
        }
    }

    class FilterView(view: View) : RecyclerView.ViewHolder(view)

    interface OnClickListener {
        fun click(data: Genre)
    }
}