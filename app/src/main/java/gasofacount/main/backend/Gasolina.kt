package gasofacount.main.backend

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime
import java.io.Serializable
import java.time.ZoneId

@Entity(tableName = "gasolina")
class Gasolina(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fecha: String,
    val litros: Double,
    val dinero: Double
    ) : Serializable

