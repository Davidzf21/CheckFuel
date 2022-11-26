package gasofacount.main.backend

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import gasofacount.main.backend.Gasolina

@Dao
interface GasolinaDao {
    @Query("SELECT * FROM gasolina")
    fun getAll(): LiveData<List<Gasolina>>

    @Insert
    fun insert(vararg gasolinas: Gasolina)

}