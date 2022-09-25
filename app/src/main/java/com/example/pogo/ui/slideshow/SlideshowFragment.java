package com.example.pogo.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pogo.R;
import com.example.pogo.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.Locale;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    private ListView listView;

    public static ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        setupPokemon();
        initializedSearchWidgets(root);

        return root;
    }

    private void setupPokemon(){
        String[] pokemonNames = getResources().getStringArray(R.array.pokemon_list);
        int count = 0;
        if(pokemonList.isEmpty()){
            for(String pokemon: pokemonNames){
                Pokemon poke = new Pokemon(String.valueOf(count), pokemon);
                count++;
                pokemonList.add(poke);
            }
        }

    }

    private void initializedSearchWidgets(View view){
        SearchView searchView = (SearchView) view.findViewById(R.id.pokemonSearchIV);
        listView = (ListView) view.findViewById(R.id.pokemonListView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Pokemon> filteredPokemon = new ArrayList<>();
                for(Pokemon pokemon: pokemonList){
                    if(pokemon.getName().toLowerCase().contains(s.toLowerCase())){
                        filteredPokemon.add(pokemon);
                    }
                }
                PokemonAdapter adapter = new PokemonAdapter(getActivity().getApplicationContext(), 0, filteredPokemon);
                listView.setAdapter(adapter);
                return false;
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ItemClicked item = adapterView.getItemAtPosition(i);
//            }
//        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}