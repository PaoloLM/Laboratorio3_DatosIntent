package com.desarrollo.laboratorio3_datosintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ClsDatos objDatos = new ClsDatos();
    private int CAMERA_PIC_REQUEST = 1;
    Bitmap imagen;

    public static ArrayList<ClsDatos> ListaDatos;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_PIC_REQUEST) {
            if (resultCode == RESULT_OK) {
                imagen = (Bitmap) data.getExtras().get("data");
                ImageView foto = (ImageView) findViewById(R.id.img_prev);
                foto.setImageBitmap(imagen);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EXPLANAR BOTON IMAGEN Y PREVIEW

        Button btn_camera = (Button) findViewById(R.id.btn_imagen);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });


        Button btn_verdatos = (Button) findViewById(R.id.btn_send);
        btn_verdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Almacenar datos en clases

                EditText txtnombre = (EditText) findViewById(R.id.txt_nombre);
                EditText txtapellido = (EditText) findViewById(R.id.txt_apellido);
                EditText txtdireccion = (EditText) findViewById(R.id.txt_direccion);
                EditText txtcelular = (EditText) findViewById(R.id.txt_telefono);
                EditText txtemail = (EditText) findViewById(R.id.txt_email);

                objDatos.setNombre(txtnombre.getText().toString());
                objDatos.setApellido(txtapellido.getText().toString());
                objDatos.setDireccion(txtdireccion.getText().toString());
                objDatos.setCelular(txtcelular.getText().toString());
                objDatos.setEmail(txtemail.getText().toString());
                objDatos.setImagen(imagen);

                Intent intent = new Intent(MainActivity.this,DatosActivity.class);
                startActivity(intent);
            }
        });
    }
}

