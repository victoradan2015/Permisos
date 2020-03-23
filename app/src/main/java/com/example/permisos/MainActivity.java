package com.example.permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch switch1, switch2, switch3, switch4, switch5;
    private int STORAGE_PERMISSION_CODE = 1;
    private int CAMERA_PERMISSION_CODE = 1;
    private int STORAGE_PERMISSION_CODE_CONTACTOS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRequest = findViewById(R.id.button);

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);

        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                }else{
                    requestStoragePermission();
                }
            }

        });


    }

    public void onclick(View view) {
        if(view.getId()==R.id.switch1)
        {
            if(switch1.isChecked())
            {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                }else{
                    requestStoragePermission();
                }
            }else
            {
                Toast.makeText(MainActivity.this,"Desactivado", Toast.LENGTH_LONG).show();
            }
        }
        if(view.getId()==R.id.switch2)
        {
            if (switch2.isChecked()) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                } else {
                    usarCamara();
                }
            } else {
                Toast.makeText(MainActivity.this, "Desactivado", Toast.LENGTH_LONG).show();
            }
        }
        if(view.getId()==R.id.switch3)
        {
            if(switch3.isChecked())
            {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                }else{
                    leercontactos();
                }
            }else
            {
                Toast.makeText(MainActivity.this,"Desactivado", Toast.LENGTH_LONG).show();
            }
        }
    }
//////////////////PARA ACCEDER AL STORAGE
    private void requestStoragePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para curar el COVID-19").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE_CONTACTOS);
        }
    }
    ///////////////METODO PARA LA CAMARA
    private void usarCamara() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para curar el COVID-19").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
        }
    }
///////////////METODO PARA LEER LOS CONTACTOS
    private void leercontactos() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para curar el COVID-19").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},STORAGE_PERMISSION_CODE_CONTACTOS);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},STORAGE_PERMISSION_CODE_CONTACTOS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Permiso concedido",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Permiso Negado",Toast.LENGTH_LONG).show();
        }
    }



}
