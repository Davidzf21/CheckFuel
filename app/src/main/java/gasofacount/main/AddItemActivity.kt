package gasofacount.main

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import gasofacount.main.backend.AppDatabase
import gasofacount.main.backend.Gasolina
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val database = AppDatabase.getDatabase(this)

        val myButton: Button = findViewById(R.id.save_btn)
        val myTextLitros: EditText = findViewById(R.id.editTextLitros)
        val myTextPrecio: EditText = findViewById(R.id.editTextDinero)

        myButton.setOnClickListener {
            var litroDouble: Double = 0.0
            var precioDouble: Double = 0.0
            var litro = myTextLitros.getText().toString()
            println(litro)
            if(litro == "") {
                Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
            } else {
                litroDouble = litro.toDouble()

                val precio = myTextPrecio.text.toString()
                if (precio == "") {
                    Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
                } else {
                    precioDouble = precio.toDouble()

                    val datetime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))

                    val gasolina = Gasolina(
                        fecha = datetime.toString(),
                        litros = litroDouble,
                        dinero = precioDouble
                    )

                    CoroutineScope(Dispatchers.IO).launch {
                        database.gasolinas().insert(gasolina)
                        this@AddItemActivity.finish()
                    }
                }
            }
        }
    }
}