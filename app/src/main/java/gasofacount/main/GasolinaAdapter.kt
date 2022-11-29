package gasofacount.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gasofacount.main.backend.Gasolina
import gasofacount.main.databinding.CardViewDesignBinding

class GasolinaAdapter(
    private val books: List<Gasolina>,
    private val clickListener: GasolinaClickListener
    )
    : RecyclerView.Adapter<GasolinaViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GasolinaViewHolder
    {
        val from = LayoutInflater.from(parent.context)
        val binding = CardViewDesignBinding.inflate(from, parent, false)
        return GasolinaViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: GasolinaViewHolder, position: Int)
    {
        holder.bindBook(books[position])
    }

    override fun getItemCount(): Int = books.size
}