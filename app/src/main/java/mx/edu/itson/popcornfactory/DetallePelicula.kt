package mx.edu.itson.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*
import android.os.Bundle


class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var ns = 0;
        var id = -1;
        var title = "";

        if (bundle != null){
            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("nombre"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatLeft.setText("$ns seats available ")
            id = bundle.getInt("pos")
        }

        if(ns == 0){
            buyTicket.isEnabled = false
        } else {
            buyTicket.setOnClickListener{
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("nombre", title)

                this.startActivity(intent)
            }
        }
    }
}