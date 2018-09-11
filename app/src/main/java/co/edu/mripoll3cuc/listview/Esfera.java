package co.edu.mripoll3cuc.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Esfera extends AppCompatActivity
{

    private TextView resultado;
    private EditText dato;
    private String operaciones [];
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        dato = findViewById(R.id.txtEsfera);
        resultado = findViewById(R.id.lblResultadoEsfera);
        resources = this.getResources();
    }

    public void calcularEsfera(View view)
    {
        String dat,res,op;
        double rad, result;
        if (validar())
        {
            op = "" + resources.getString(R.string.mensaje_volumen_esfera);
            rad = Double.parseDouble(dato.getText().toString());
            dat = "" + resources.getString(R.string.mensaje_valor_radio) + rad;
            result = (Math.PI*(4)*(Math.pow(rad,3)));
            result = (result/3);
            res = Integer.toString((int) result);
            resultado.setText("" + resources.getString(R.string.mensaje_resultado_radio) + String.format( "%.1f", result ));
            Operaciones o = new Operaciones(op,dat,res);
            o.calcular();
            Toast.makeText(this,resources.getString(R.string.mensaje_exitoso),Toast.LENGTH_SHORT).show();

        }
    }

    public boolean validar()
    {
        if(dato.getText().toString().isEmpty())
        {
            dato.setError(this.getResources().getString(R.string.error1));
            dato.requestFocus();
            return false;

        }
        if(Double.parseDouble( dato.getText().toString())==0)
        {
            dato.requestFocus();
            dato.setError(this.getResources().getString(R.string.error2));
            return false;
        }

        return true;
    }

    public void limpiar(View v)
    {
        borrar();
    }

    public void borrar()
    {
        resultado.setText("");
        dato.setText("");
        dato.requestFocus();
    }
}
