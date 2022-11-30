package gasofacount.main

import gasofacount.main.backend.Gasolina

interface GasolinaClickListener
{
    fun onClick(gas: Gasolina)

    fun setOnLongClickListener(gas: Gasolina)
}