package co.edu.mripoll3cuc.listview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumenes extends AppCompatActivity {

    private ListView lv;
    private Resources resources;
    private String opcv[];
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        lv = findViewById(R.id.lstVolumen);
        resources = this.getResources();
        opcv = resources.getStringArray(R.array.opciones_volumen);
        ArrayAdapter<String> adapterv = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcv);
        lv.setAdapter(adapterv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                          switch (i) {
                                              case 0:
                                                  in = new Intent(Volumenes.this, Esfera.class);
                                                  startActivity(in);
                                                  break;
                                              case 1:
                                                  in = new Intent(Volumenes.this, Cilindro.class);
                                                  startActivity(in);
                                                  break;
                                          }
                                      }
                                  }
        );}
    }
