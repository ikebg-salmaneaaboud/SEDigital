package com.sedigital.gamr.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.mock.CartProvider;

/**
 * Pantalla que muestra el contenido del carrito.
 * Configura el listado de productos usando un RecyclerView.
 */
public class CartActivity extends AppCompatActivity {

    // Proveedor que devuelve los ítems del carrito (datos simulados)
    private CartProvider cartProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Botón de retorno en el header
        ImageView btnReturn = findViewById(R.id.header_return_icon);
        btnReturn.setOnClickListener(v -> onBackPressed());

        // Inicializa proveedor de carrito y carga el listado
        cartProvider = new CartProvider();
        initRecyclerView();
    }

    /**
     * Configura el RecyclerView del carrito.
     * Usa un GridLayoutManager con una sola columna
     * y asigna el adaptador que muestra los productos.
     */
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerCart);

        // Layout vertical de una columna
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        // Adaptador encargado de mostrar los ítems del carrito
        recyclerView.setAdapter(new CartAdapter(cartProvider.getCart()));
    }
}
