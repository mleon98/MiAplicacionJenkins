package com.mlsistemas.core;

import java.util.HashMap;
import java.util.Map;

public class StoreService {
    private Map<String, Integer> inventory = new HashMap<>();
    private int cartItems = 0;
    private String lastMessage = "";

    public void setStock(String product, int stock) {
        inventory.put(product, stock);
    }

    public int getStock(String product) {
        return inventory.getOrDefault(product, 0);
    }

    public boolean addToCart(String product, int quantity) {
        int currentStock = getStock(product);
        
        if (currentStock == 0) {
            lastMessage = "Producto agotado";
            return false;
        }
        
        if (quantity > 10) {
            lastMessage = "Límite excedido: Máximo 10";
            return false;
        }
        
        if (quantity > currentStock) {
            lastMessage = "Solo quedan " + currentStock + " unidades";
            cartItems += currentStock;
            inventory.put(product, 0);
            return false;
        }
        
        inventory.put(product, currentStock - quantity);
        cartItems += quantity;
        lastMessage = "Producto agregado";
        return true;
    }

    public int getCartItemsCount() {
        return cartItems;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
