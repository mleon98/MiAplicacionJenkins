package com.mlsistemas.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    private Calculadora calculadora;

    // Se instancia un nuevo objeto antes de cada test para garantizar la atomicidad
    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Debería retornar la suma correcta de dos enteros")
    void testSumar() {
        // Arrange
        int a = 15;
        int b = 20;

        // Act
        int resultado = calculadora.sumar(a, b);

        // Assert
        assertEquals(35, resultado, "La suma de 15 + 20 debe ser 35");
    }

    @Test
    @DisplayName("Debería retornar la resta correcta de dos enteros")
    void testRestar() {
        // Arrange
        int a = 50;
        int b = 15;

        // Act
        int resultado = calculadora.restar(a, b);

        // Assert
        assertEquals(35, resultado, "La resta de 50 - 15 debe ser 35");
    }
}
