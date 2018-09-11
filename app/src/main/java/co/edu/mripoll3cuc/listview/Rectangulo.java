package co.edu.mripoll3cuc.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rectangulo extends AppCompatActivity
{

    private TextView resultado;
    private EditText dato1, dato2;
    private String operaciones [];
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        dato1 = findViewById(R.id.txtBase);
        dato2 = findViewById(R.id.txtAltura);
        resultado = findViewById(R.id.lblResultadoRectangulo);
        resources = this.getResources();
    }

    public void calcularRectangulo(View view)
    {
        String op,dt1,dt2,res,dat;
        double base,altura, result;
        if (validar())
        {
            op = "" + resources.getString(R.string.mensaje_area_rectangulo);
            base = Double.parseDouble(dato1.getText().toString());
            altura = Double.parseDouble(dato2.getText().toString());
            dt1 = "" + resources.getString(R.string.mensaje_valor_base) + base;
            dt2 = "" + resources.getString(R.string.mensaje_valor_altura) + altura;
            dat = dt1 +"\n"+dt2;
            result = (base*altura);
            res = Integer.toString((int) result);
            resultado.setText("" + resources.getString(R.string.mensaje_resultado_r) + String.format( "%.1f", result ));
            Operaciones o = new Operaciones(op,dat,res);
            o.calcular();
            Toast.makeText(this,resources.getString(R.string.mensaje_exitoso),Toast.LENGTH_SHORT).show();

        }
    }

    public boolean validar()
    {
        if(dato1.getText().toString().isEmpty())
        {
            dato1.setError(this.getResources().getString(R.string.error1));
            dato1.requestFocus();
            return false;
        }
        if(Double.parseDouble( dato1.getText().toString())==0)
        {
            dato1.requestFocus();
            dato1.setError(this.getResources().getString(R.string.error2));
            return false;
        }

        if(dato2.getText().toString().isEmpty())
        {
            dato2.setError(this.getResources().getString(R.string.error1));
            dato2.requestFocus();
            return false;
        }
        if(Double.parseDouble( dato2.getText().toString())==0)
        {
            dato2.requestFocus();
            dato2.setError(this.getResources().getString(R.string.error2));
            return false;
        }
        return true;
    }

    public void limpiarRectangulo(View v)
    {
        borrar2();
    }

    public void borrar2()
    {
        resultado.setText("");
        dato1.setText("");
        dato2.setText("");
        dato1.requestFocus();
    }
}
