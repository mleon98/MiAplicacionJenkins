package com.mlsistemas.stepdefinitions;

import com.mlsistemas.core.Calculadora;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraSteps {

    private Calculadora calculadora;
    private int resultado;

    @Dado("que tengo una calculadora")
    public void queTengoUnaCalculadora() {
        calculadora = new Calculadora();
    }

    @Cuando("sumo {int} y {int}")
    public void sumoY(int a, int b) {
        resultado = calculadora.sumar(a, b);
    }

    @Cuando("resto {int} y {int}")
    public void restoY(int a, int b) {
        resultado = calculadora.restar(a, b);
    }

    @Entonces("el resultado debe ser {int}")
    public void elResultadoDebeSer(int esperado) {
        assertEquals(esperado, resultado, "El resultado calculado no coincide con el esperado");
    }
}
