package co.edu.mripoll3cuc.listview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Areas extends AppCompatActivity
{

    private ListView lv;
    private Resources resources;
    private String opca[];
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        lv = (ListView) findViewById(R.id.lstAreas);
        resources = this.getResources();
        opca = resources.getStringArray(R.array.opciones_areas);
        ArrayAdapter<String> adaptera = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opca);
        lv.setAdapter(adaptera);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        in = new Intent(Areas.this, Cuadrado.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Areas.this, Rectangulo.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}
