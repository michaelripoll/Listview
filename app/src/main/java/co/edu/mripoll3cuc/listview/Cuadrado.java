package co.edu.mripoll3cuc.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cuadrado extends AppCompatActivity {

    private EditText dato;
    private TextView resultado;
    private String operaciones [];
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        dato = findViewById(R.id.txtCuadrado);
        resultado = findViewById(R.id.lblResultadoCuadrado);
        resources = this.getResources();

    }

    public void calcular(View V){
        String dat,res,op;

        if (validar())
        {
            op = "Area del cuadrado";
            double lado = Double.parseDouble(dato.getText().toString());
            dat = "Valor del lado : " + dato.getText().toString();
            double result = lado * lado;
            res = Integer.toString((int) result);
            resultado.setText("El area del cuadrado es " + String.format("%.1f", result));
            Operaciones o = new Operaciones(op, dat, res);
            o.calcular();
            Toast.makeText(this, resources.getString(R.string.mensaje_exitoso), Toast.LENGTH_SHORT).show();
            borrar();
        }
    }

    public boolean validar(){
        if(dato.getText().toString().isEmpty()){
            dato.setError(this.getResources().getString(R.string.error1));
            dato.requestFocus();
            return false;

        }
        if(Double.parseDouble( dato.getText().toString())==0){
            dato.requestFocus();
            dato.setError(this.getResources().getString(R.string.error2));
            return false;
        }

        return true;
    }

    public void limpiar(View v){
        borrar();
    }

    public void borrar(){
        resultado.setText("");
        dato.setText("");
        dato.requestFocus();
    }

}
