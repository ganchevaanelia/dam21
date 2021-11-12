package com.example.damsem6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptorOrase extends BaseAdapter {

    private List<Orase> lista;

    public AdaptorOrase(List<Orase> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size(); //numara atributele
    }

    @Override
    public Orase getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_orase,
                parent, false);
        TextView tNume = view.findViewById(R.id.nume);
        TextView tPopulatie = view.findViewById(R.id.populatie);
        TextView tDescriere = view.findViewById(R.id.descriere);

        Orase temp = lista.get(position);
        tNume.setText(temp.getNume());
        tPopulatie.setText(temp.getPopulatie()+"");
        tDescriere.setText(temp.getDescriere());

        return view;
    }
}
