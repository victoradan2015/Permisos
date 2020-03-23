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
    private int SEND_SMS_PERMISSION_CODE = 1;
    private int ACCESS_FINE_LOCATION_PERMISSION_CODE = 1;
    private int WRITE_CONTACTS_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch4 = findViewById(R.id.switch4);
        switch5 = findViewById(R.id.switch5);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            switch1.setTextColor(0xFF0F3CE7);
            switch1.setChecked(true);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            switch2.setTextColor(0xFF0F3CE7);
            switch2.setChecked(true);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            switch3.setTextColor(0xFF0F3CE7);
            switch3.setChecked(true);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            switch4.setTextColor(0xFF0F3CE7);
            switch4.setChecked(true);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            switch5.setTextColor(0xFF0F3CE7);
            switch5.setChecked(true);
        }

    }

    public void onclick(View view) {
        if(view.getId()==R.id.switch1)
        {
            if(switch1.isChecked())
            {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                }else{
                    permiso_almacenamiento_externo();
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
                    permiso_camara();
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
                    perimiso_enviar_sms();
                }
            }else
            {
                Toast.makeText(MainActivity.this,"Desactivado", Toast.LENGTH_LONG).show();
            }
        }
        if(view.getId()==R.id.switch4)
        {
            if(switch4.isChecked())
            {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                }else{
                    permiso_location();
                }
            }else
            {
                Toast.makeText(MainActivity.this,"Desactivado", Toast.LENGTH_LONG).show();
            }
        }
        if(view.getId()==R.id.switch5)
        {
            if(switch5.isChecked())
            {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Ya tienes este permiso!", Toast.LENGTH_LONG).show();
                }else{
                    permiso_leer_contactos();
                }
            }else
            {
                Toast.makeText(MainActivity.this,"Desactivado", Toast.LENGTH_LONG).show();
            }
        }
    }
//////////////////PARA ACCEDER AL ALMACENAMIENTO EXTERNO
    private void permiso_almacenamiento_externo() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas aceptar que la app pueda acceder al almacenamiento externo").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
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
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
        }
        switch1.setTextColor(0xFF0F3CE7);
    }
///////////////METODO PARA LA CAMARA
    private void permiso_camara() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para usar la camara").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
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
        switch2.setTextColor(0xFF0F3CE7);
    }
///////////////METODO PARA MANDAR LOS SMS
    private void perimiso_enviar_sms() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para mandar sms").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_CODE);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_CODE);
        }
        switch3.setTextColor(0xFF0F3CE7);
    }

    ///////////////METODO PARA ACCEDER A UBICACION
    private void permiso_location() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para acceder a tu Ubicacion").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},ACCESS_FINE_LOCATION_PERMISSION_CODE);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},ACCESS_FINE_LOCATION_PERMISSION_CODE);
        }
        switch4.setTextColor(0xFF0F3CE7);
    }

///////////////METODO PARA LEER CONTACTOS
    private void permiso_leer_contactos() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_CONTACTS)){
            new AlertDialog.Builder(this).setTitle("Necesitas este Permiso.").setMessage("Necesitas este permiso para leer tus contactos").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_CONTACTS},WRITE_CONTACTS_PERMISSION_CODE);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_CONTACTS},WRITE_CONTACTS_PERMISSION_CODE);
        }
        switch5.setTextColor(0xFF0F3CE7);
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
