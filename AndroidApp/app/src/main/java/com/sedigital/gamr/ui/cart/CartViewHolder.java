package com.sedigital.gamr.ui.cart;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.CartItem;

import java.util.ArrayList;

/**
 * ViewHolder para los elementos del carrito.
 * Se encarga de mostrar la información de cada juego en el carrito
 * y gestionar interacciones como eliminar un item.
 */
public class CartViewHolder extends RecyclerView.ViewHolder {

    // Elementos de la vista que representan el contenido de un item del carrito
    private final ImageView ivVideoGame;
    private final TextView tvVideoGameTitle;
    private final TextView tvVideoGameCategory;
    private final ImageView ivPlatform;
    private final TextView tvVideoGamePrice;
    private final ImageView ivRemoveCartItem;

    /**
     * Constructor que obtiene referencias a los elementos de la vista.
     * @param view layout de cada item del carrito
     */
    public CartViewHolder(View view) {
        super(view);
        ivVideoGame = view.findViewById(R.id.ivVideoGame);
        tvVideoGameTitle = view.findViewById(R.id.tvVideoGameTitle);
        tvVideoGameCategory = view.findViewById(R.id.tvVideoGameCategory);
        ivPlatform = view.findViewById(R.id.ivPlatform);
        tvVideoGamePrice = view.findViewById(R.id.tvVideoGamePrice);
        ivRemoveCartItem = view.findViewById(R.id.ivRemoveCartItem);
    }

    /**
     * Vincula los datos de un CartItem a los elementos visuales del ViewHolder.
     * También gestiona la acción de eliminar un item del carrito.
     * @param list lista completa de items en el carrito
     * @param position posición del item actual
     * @param adapter adaptador del RecyclerView para notificar cambios
     */
    public void render(ArrayList<CartItem> list, int position, RecyclerView.Adapter adapter) {
        CartItem cartItem = list.get(position);

        // Configura los elementos visuales con los datos del juego
        ivVideoGame.setImageResource(cartItem.getVideoGame().getCover());
        tvVideoGameTitle.setText(cartItem.getVideoGame().getTitle());
        tvVideoGameCategory.setText(cartItem.getVideoGame().getCategory());
        ivPlatform.setImageResource(cartItem.getPlatform());
        tvVideoGamePrice.setText(itemView.getContext().getString(
                R.string.price_format_euro, cartItem.getVideoGame().getPrice()));

        // Configura la acción para eliminar el item del carrito
        ivRemoveCartItem.setOnClickListener(v -> {
            int pos = getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                list.remove(pos);
                adapter.notifyItemRemoved(pos);
            }
        });
    }
}
