package gasofacount.main.backend

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GasolinaDao {
    @Query("SELECT * FROM gasolina")
    fun getAllLive(): LiveData<List<Gasolina>>

    @Query("SELECT * FROM gasolina")
    fun getAll(): List<Gasolina>

    @Query("SELECT * FROM gasolina WHERE id = :id")
    fun getById(id: Int): Gasolina

    @Insert
    fun insert(gasolina: Gasolina)

    @Delete
    fun delete(gasolina: Gasolina)
}