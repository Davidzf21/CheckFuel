package gasofacount.main.backend

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gasolina (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fecha: String,
    val litros: Double,
    val dinero: Double
)

