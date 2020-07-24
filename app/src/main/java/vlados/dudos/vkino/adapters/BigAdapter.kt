package vlados.dudos.vkino.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.big_view.view.*
import vlados.dudos.vkino.Case.filterId
import vlados.dudos.vkino.Case.filterList
import vlados.dudos.vkino.InfoActivity
import vlados.dudos.vkino.R
import vlados.dudos.vkino.models.Genre
import vlados.dudos.vkino.models.Result

class BigAdapter(val context: Context, val listNew: List<Result>, val listFilter: List<Genre>, val listMovie: List<Result>): RecyclerView.Adapter<BigAdapter.BigView>(),
    MovieAdapter.OnClickListener,
    NewsAdapter.OnClickListener, FilterAdapter.OnClickListener{

    override fun click(data: Result){
        context.startActivity(Intent(context, InfoActivity::class.java))
    }

    override fun click(data: Genre) {

    }

    override fun clickM(data: Result){
        context.startActivity(Intent(context, InfoActivity::class.java))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigView {
        return BigView(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.big_view, parent, false)
        )
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: BigView, position: Int) {
        holder.itemView.rv_new.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.itemView.rv_filter.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.itemView.rv_movie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        holder.itemView.rv_new.adapter =
            NewsAdapter(listNew, this)
        holder.itemView.rv_filter.adapter =
            FilterAdapter(listFilter, this)

        holder.itemView.rv_movie.adapter =
            MovieAdapter(listMovie, listFilter, this)
    }

    class BigView(view: View): RecyclerView.ViewHolder(view)
}