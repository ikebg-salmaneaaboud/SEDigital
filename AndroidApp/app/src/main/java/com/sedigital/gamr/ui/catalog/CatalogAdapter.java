package com.sedigital.gamr.ui.catalog;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.VideoGame;

import java.util.ArrayList;

/**
 * Adaptador para el RecyclerView del catálogo de videojuegos.
 * Se encarga de crear y vincular cada elemento visual que representa un VideoGame.
 */
public class CatalogAdapter extends RecyclerView.Adapter<CatalogViewHolder> {

    // Lista de videojuegos a mostrar en el catálogo
    private final ArrayList<VideoGame> videoGames;

    /**
     * Constructor que recibe la lista de videojuegos.
     * @param videoGames lista de VideoGame a mostrar
     */
    public CatalogAdapter(ArrayList<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    /**
     * Se llama cuando se necesita crear un nuevo ViewHolder.
     * Infla el layout de cada elemento de videojuego.
     */
    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CatalogViewHolder(layoutInflater.inflate(R.layout.item_videogame, parent, false));
    }

    /**
     * Vincula los datos del VideoGame con la vista correspondiente.
     * @param holder ViewHolder que representa cada item visual
     * @param position posición del VideoGame en la lista
     */
    @Override
    public void onBindViewHolder(@NonNull CatalogViewHolder holder, int position) {
        VideoGame videoGame = videoGames.get(position);
        holder.render(videoGame);
    }

    /**
     * Retorna la cantidad total de videojuegos en la lista.
     * @return número de elementos a mostrar
     */
    @Override
    public int getItemCount() {
        return videoGames.size();
    }
}
