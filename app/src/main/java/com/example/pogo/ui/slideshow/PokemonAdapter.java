package com.example.pogo.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.pogo.R;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(@NonNull Context context, int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon pokemon = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pokemon_cell, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.pokemonName);
//        ImageView sprite = (ImageView) convertView.findViewById(R.id.pokemonImage);

        name.setText(pokemon.getName());
//        sprite.setImageResource(pokemon.getImage());

        return convertView;
    }
}
