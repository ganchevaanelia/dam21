package com.example.damsem6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private AdaptorOrase adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=findViewById(R.id.listview);
       // adaptor=new AdaptorOrase(getList());
      //  listview.setAdapter(adaptor);

        JSONReader reader = new JSONReader();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read("https://jsonkeeper.com/b/HXJ5", new IResponse() {
                    @Override
                    public void onSucces(List<Orase> orase) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adaptor = new AdaptorOrase(orase);
                                listview.setAdapter(adaptor);
                                Toast.makeText(MainActivity.this, orase.toString(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(String msj) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msj,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
        thread.start();

    }

    private List<Orase> getList(){
        ArrayList<Orase> lista = new ArrayList<>();
        Orase oras1 = new Orase("Bucuresti",856858f, "Capitala Romaniei");
        Orase oras2 = new Orase("Ploiesti", 23436f, "Oras mic");

        lista.add(oras1);
        lista.add(oras2);
        return lista;
    }
}