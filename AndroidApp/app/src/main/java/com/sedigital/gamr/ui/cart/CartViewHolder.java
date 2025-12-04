package com.sedigital.gamr.ui.cart;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.CartItem;
import com.sedigital.gamr.data.model.VideoGame;
import com.sedigital.gamr.ui.gamedetail.GameDetailActivity;

import java.util.ArrayList;


public class CartViewHolder extends RecyclerView.ViewHolder {

    private final ImageView ivVideoGame;
    private final TextView tvVideoGameTitle;
    private final TextView tvVideoGameCategory;
    private final ImageView ivPlatform;
    private final TextView tvVideoGamePrice;
    private final ImageView ivRemoveCartItem;

    public CartViewHolder(View view) {
        super(view);
        ivVideoGame = view.findViewById(R.id.ivVideoGame);
        tvVideoGameTitle = view.findViewById(R.id.tvVideoGameTitle);
        tvVideoGameCategory = view.findViewById(R.id.tvVideoGameCategory);
        ivPlatform = view.findViewById(R.id.ivPlatform);
        tvVideoGamePrice = view.findViewById(R.id.tvVideoGamePrice);
        ivRemoveCartItem = view.findViewById(R.id.ivRemoveCartItem);
    }

    public void render(ArrayList<CartItem> list, int position, RecyclerView.Adapter adapter) {
        CartItem cartItem = list.get(position);

        ivVideoGame.setImageResource(cartItem.getVideoGame().getCover());
        tvVideoGameTitle.setText(cartItem.getVideoGame().getTitle());
        tvVideoGameCategory.setText(cartItem.getVideoGame().getCategory());
        ivPlatform.setImageResource(cartItem.getPlatform());
        tvVideoGamePrice.setText(itemView.getContext().getString(
                R.string.price_format_euro, cartItem.getVideoGame().getPrice()));

        ivRemoveCartItem.setOnClickListener(v -> {
            int pos = getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                list.remove(pos);
                adapter.notifyItemRemoved(pos);
            }
        });
    }

}
