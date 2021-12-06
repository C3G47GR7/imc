package com.softwarenlinea.imc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.softwarenlinea.imc.model.Persona;
import com.softwarenlinea.imc.repository.ImcRepositoryImp;

public class MainActivity extends AppCompatActivity {

    private TextView id;
    private EditText peso,altura,edad;
    private Button calcular,eliminar;
    private TextView imc;
    private TextView descripcion;
    private TextView pesoalturarecomendado;
    private TextView indicebasal;
    private RadioButton mujer, hombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ImcRepositoryImp imcRepositoryImp = new ImcRepositoryImp();

       // Button botonGuardar =(Button) findViewById(R.id.b_salvar);
      //  botonGuardar.setOnClickListener(new View.OnClickListener() {
       //     @Override
        //    public void onClick(View v) {
         //       imcRepositoryImp.crear( );
        //    }
        //});


        id= findViewById(R.id.tv_identificacion);
        peso = findViewById(R.id.txtpeso);
        altura = findViewById(R.id.txtaltura);
        edad = findViewById(R.id.txtedad);
        calcular = findViewById(R.id.btncalcular);
        eliminar = findViewById(R.id.btneliminar);
        imc = findViewById(R.id.txtimc);
        descripcion = findViewById(R.id.txtdescripcion);
        pesoalturarecomendado = findViewById(R.id.txtideal);
        mujer = (RadioButton) findViewById(R.id.rb_mujer);
        hombre= (RadioButton) findViewById(R.id.rb_hombre);
        indicebasal = findViewById(R.id.txtbasal);

    }
       public void operar(View view)
       {

        double npeso= Double.parseDouble(peso.getText().toString());
        double naltura= Double.parseDouble(altura.getText().toString());
        double nedad= Double.parseDouble(edad.getText().toString());
        double resultadoimc= npeso/(naltura*naltura);
        double resultadopideal= (naltura*100)-100;


        imc.setText("IMC: "+ String.format("%.2f",resultadoimc));
        pesoalturarecomendado.setText("Peso Ideal: "+ resultadopideal);


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

           double rindicebasal =  0;

        if (mujer.isChecked() == true) {
            rindicebasal = ((8.7 * npeso) + (25 * naltura) + 865);
           } else if (hombre.isChecked() == true) {

               rindicebasal = ((11.3 * npeso) + (16 * naltura) + 901);
           }

           indicebasal.setText("Metabolismo Basal: " +  rindicebasal);

    }
    public void borrar(View v)
    {
        id.setText(" ");
        peso.setText("");
        altura.setText("");
        imc.setText("");
        edad.setText("");
        descripcion.setText("");
        pesoalturarecomendado.setText("");
        indicebasal.setText("");
    }
}