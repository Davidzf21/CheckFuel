package gasofacount.main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import gasofacount.main.backend.AppDatabase
import gasofacount.main.backend.Gasolina
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val database = AppDatabase.getInstance(this)

        val myButton: Button = findViewById(R.id.save_btn)
        val myTextLitros: EditText = findViewById(R.id.editTextLitros)
        val myTextPrecio: EditText = findViewById(R.id.editTextDinero)

        val df = DecimalFormat("#.0")

        myButton.setOnClickListener {
            var litro = myTextLitros.getText().toString()
            if(litro == "") {
                Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
            } else {
                var litroDouble = df.format(litro.toDouble()).toDouble()

                val precio = myTextPrecio.text.toString()
                if (precio == "") {
                    Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
                } else {
                    var precioDouble = df.format(precio.toDouble()).toDouble()

                    val datetime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))

                    val gasolina = Gasolina(
                        fecha = datetime.toString(),
                        litros = litroDouble,
                        dinero = precioDouble
                    )

                    CoroutineScope(Dispatchers.IO).launch {
                        database.gasolinasDao().insert(gasolina)
                        this@AddItemActivity.finish()
                    }
                }
            }
        }
    }
}