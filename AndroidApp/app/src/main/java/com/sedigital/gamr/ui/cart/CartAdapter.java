package com.sedigital.gamr.ui.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.CartItem;

import java.util.ArrayList;

/**
 * Adaptador para mostrar los elementos del carrito en un RecyclerView.
 * Se encarga de crear, vincular y contar los elementos visuales del carrito.
 */
public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    // Lista de productos en el carrito que se mostrarán en el RecyclerView
    private final ArrayList<CartItem> cartAdapterArrayList;

    /**
     * Constructor del adaptador.
     * @param cartAdapterArrayList lista de items del carrito a mostrar.
     */
    public CartAdapter(ArrayList<CartItem> cartAdapterArrayList) {
        this.cartAdapterArrayList = cartAdapterArrayList;
    }

    /**
     * Se llama cuando se necesita crear un nuevo ViewHolder.
     * Infla el layout de cada item del carrito.
     */
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CartViewHolder(layoutInflater.inflate(R.layout.item_cart, parent, false));
    }

    /**
     * Vincula los datos del item del carrito con la vista correspondiente.
     * @param holder ViewHolder que representa cada elemento visual
     * @param position posición del item en la lista
     */
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.render(cartAdapterArrayList, position, this);
    }

    /**
     * Retorna la cantidad total de elementos en el carrito.
     * @return número de items en la lista
     */
    @Override
    public int getItemCount() {
        return cartAdapterArrayList.size();
    }
}
