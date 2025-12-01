package com.sedigital.gamr.ui.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.CartItem;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private final ArrayList<CartItem> cartAdapterArrayList;

    public CartAdapter(ArrayList<CartItem> cartAdapterArrayList) {
        this.cartAdapterArrayList = cartAdapterArrayList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CartViewHolder(layoutInflater.inflate(R.layout.item_cart, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartAdapterArrayList.get(position);
        holder.render(cartItem);
    }

    @Override
    public int getItemCount() {
        return cartAdapterArrayList.size();
    }
}
