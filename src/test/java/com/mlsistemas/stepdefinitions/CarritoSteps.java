package com.mlsistemas.stepdefinitions;

import com.mlsistemas.core.StoreService;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;

public class CarritoSteps {

    private StoreService storeService = new StoreService();
    private String currentProduct;

    @Dado("que el usuario {string} ha iniciado sesión")
    public void usuarioIniciadoSesion(String usuario) {
        // Simulado: asumimos sesión activa
    }

    @Dado("que existe el producto {string} con stock de {int} unidades")
    public void existeProductoConStock(String producto, int stock) {
        this.currentProduct = producto;
        storeService.setStock(producto, stock);
    }

    @Cuando("el usuario agrega {int} unidades al carrito")
    public void agregaUnidades(int cantidad) {
        storeService.addToCart(currentProduct, cantidad);
    }

    @Cuando("el usuario intenta agregar {int} unidades al carrito")
    public void intentaAgregarUnidades(int cantidad) {
        storeService.addToCart(currentProduct, cantidad);
    }

    @Entonces("el carrito debería mostrar {int} artículos")
    public void carritoMuestraArticulos(int cantidad) {
        Assertions.assertEquals(cantidad, storeService.getCartItemsCount());
    }

    @Y("el stock restante del producto debería ser {int}")
    public void stockRestanteEs(int stockEsperado) {
        Assertions.assertEquals(stockEsperado, storeService.getStock(currentProduct));
    }

    @Entonces("el sistema debería mostrar el mensaje {string}")
    public void sistemaMuestraMensaje(String mensajeEsperado) {
        Assertions.assertEquals(mensajeEsperado, storeService.getLastMessage());
    }

    @Y("el carrito debería tener {int} artículos")
    public void carritoTieneArticulos(int cantidad) {
        Assertions.assertEquals(cantidad, storeService.getCartItemsCount());
    }
}
