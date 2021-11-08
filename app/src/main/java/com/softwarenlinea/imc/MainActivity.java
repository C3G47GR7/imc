package com.softwarenlinea.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText peso,altura,edad;
    private Button calcular,eliminar;
    private TextView imc,descripcion,pesoalturarecomendado,indicebasal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.txtpeso);
        altura = findViewById(R.id.txtaltura);
        edad = findViewById(R.id.txtedad);
        calcular = findViewById(R.id.btncalcular);
        eliminar = findViewById(R.id.btneliminar);
        imc = findViewById(R.id.txtimc);
        descripcion = findViewById(R.id.txtdescripcion);
        pesoalturarecomendado = findViewById(R.id.txtideal);
        indicebasal = findViewById(R.id.txtbasal);
    }
       public void operar(View view)
       {

        double npeso= Double.parseDouble(peso.getText().toString());
        double naltura= Double.parseDouble(altura.getText().toString());
        double nedad= Double.parseDouble(edad.getText().toString());

        double resultadoimc= npeso/(naltura*naltura);

        imc.setText("IMC: "+ String.format("%.2f",resultadoimc));
        if(resultadoimc<18.5)
            descripcion.setText("Bajo Peso");
        else
        if (resultadoimc>=18.5 && resultadoimc<=24.9)
            descripcion.setText("Peso Normal");
        else
        if (resultadoimc>=25 && resultadoimc<=29.9)
            descripcion.setText("SobrePeso");
        else
        if (resultadoimc>=30 && resultadoimc<=34.9)
            descripcion.setText("Obesidad I");
        else
        if (resultadoimc>=35 && resultadoimc<=39.9)
            descripcion.setText("Obesidad II");
        else
        if (resultadoimc>=40 && resultadoimc<=49.9)
            descripcion.setText("Obesidad III");
        else
            if (resultadoimc>50)
                descripcion.setText("Obesidad IV");

    }
    public void borrar(View v)
    {
        peso.setText("");
        altura.setText("");
        imc.setText("");
        edad.setText("");
        descripcion.setText("");
        pesoalturarecomendado.setText("");
    }
}