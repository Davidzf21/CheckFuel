package gasofacount.main

import androidx.recyclerview.widget.RecyclerView
import gasofacount.main.backend.Gasolina
import gasofacount.main.databinding.CardViewDesignBinding

class GasolinaViewHolder(
    private val cardCellBinding: CardViewDesignBinding,
    private val clickListener: GasolinaClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindBook(gas: Gasolina)
    {
        cardCellBinding.textDate.text = gas.fecha
        cardCellBinding.textLitros.text = gas.litros.toString() + "L"
        cardCellBinding.textPrecio.text = gas.dinero.toString() + "€"

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(gas)
        }
    }
}