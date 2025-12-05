package com.sedigital.gamr.ui.catalog;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.VideoGame;
import com.sedigital.gamr.ui.gamedetail.GameDetailActivity;

/**
 * ViewHolder que representa cada elemento del catálogo de videojuegos.
 * Se encarga de mostrar título, categoría, precio e imagen de portada.
 * Gestiona la navegación a GameDetailActivity al hacer clic en el item.
 */
public class CatalogViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvVideoGameTitle;
    private final TextView tvVideoGameCategory;
    private final TextView tvVideoGamePrice;
    private final ImageView ivVideoGameCover;

    /**
     * Constructor que obtiene referencias a los elementos de la vista.
     * @param view layout de cada item del catálogo
     */
    public CatalogViewHolder(View view) {
        super(view);
        tvVideoGameTitle = view.findViewById(R.id.tvVideoGameTitle);
        tvVideoGameCategory = view.findViewById(R.id.tvVideoGameCategory);
        tvVideoGamePrice = view.findViewById(R.id.tvVideoGamePrice);
        ivVideoGameCover = view.findViewById(R.id.ivVideoGame);
    }

    /**
     * Vincula los datos de un VideoGame con los elementos visuales.
     * Configura la navegación a GameDetailActivity al pulsar sobre el item.
     * @param videoGame videojuego a mostrar
     */
    public void render(VideoGame videoGame) {
        tvVideoGameTitle.setText(videoGame.getTitle());
        tvVideoGameCategory.setText(videoGame.getCategory());
        tvVideoGamePrice.setText(itemView.getContext().getString(
                R.string.price_format_euro, videoGame.getPrice()));
        ivVideoGameCover.setImageResource(videoGame.getCover());

        // Configura el click para abrir la pantalla de detalle del juego
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), GameDetailActivity.class);
            intent.putExtra("title", videoGame.getTitle());
            intent.putExtra("category", videoGame.getCategory());
            intent.putExtra("price", videoGame.getPrice());
            intent.putExtra("developer", videoGame.getDeveloper());
            intent.putExtra("rating", videoGame.getRating());
            intent.putExtra("description", videoGame.getDescription());
            intent.putExtra("cover", videoGame.getCover());
            intent.putIntegerArrayListExtra("images", videoGame.getImages());
            itemView.getContext().startActivity(intent);
        });
    }
}
