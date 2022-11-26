package gasofacount.main.backend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gasofacount.main.R

class GasolinaDbAdapter(private val mList: List<Gasolina>) : RecyclerView.Adapter<GasolinaDbAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textViewDate.text = ItemsViewModel.fecha
        holder.textViewLitros.text = ItemsViewModel.litros.toString()
        holder.textViewPrecio.text = ItemsViewModel.dinero.toString()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewDate: TextView = itemView.findViewById(R.id.textDate)
        val textViewLitros: TextView = itemView.findViewById(R.id.textLitros)
        val textViewPrecio: TextView = itemView.findViewById(R.id.textPrecio)
    }
}
