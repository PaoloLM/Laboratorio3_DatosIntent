package com.desarrollo.laboratorio3_datosintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.desarrollo.laboratorio3_datosintent.MainActivity.*;

public class DatosActivity extends AppCompatActivity {

    int opc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TextView vernombre = (TextView) findViewById(R.id.ver_nombre);
        TextView verapellido = (TextView) findViewById(R.id.ver_apellido);
        TextView verdireccion = (TextView) findViewById(R.id.ver_direccion);
        TextView vercelular = (TextView) findViewById(R.id.ver_telefono);
        TextView veremail = (TextView) findViewById(R.id.ver_email);
        ImageView verfoto = (ImageView) findViewById(R.id.ver_img_prev);

        vernombre.setText(objDatos.getNombre());
        verapellido.setText(objDatos.getApellido());
        verdireccion.setText(objDatos.getDireccion());
        vercelular.setText(objDatos.getCelular());
        veremail.setText(objDatos.getEmail());
        verfoto.setImageBitmap(objDatos.getImagen());



        Button btn_verdireccion = (Button) findViewById(R.id.btn_mapa);
        btn_verdireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse("geo:0.0?q=" + objDatos.getDireccion());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                if (mapIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(mapIntent);
                }
            }
        });

        /*Button btn_verubicacion = (Button) findViewById(R.id.btn_ubicacion);
        btn_verubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatosActivity.this,MapDireccion.class);
                startActivity(intent);
            }
        });*/
    }
}
