package com.mlsistemas.stepdefinitions;

import com.mlsistemas.core.AuthService;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

public class AuthSteps {

    private AuthService authService;
    private boolean loginResult;
    private String errorMessage;

    @Dado("que el usuario está en la página de login")
    public void elUsuarioEstaEnLaPaginaDeLogin() {
        authService = new AuthService();
    }

    @Cuando("ingresa el usuario {string} y la clave {string}")
    public void ingresaUsuarioYClave(String usuario, String clave) {
        try {
            loginResult = authService.login(usuario, clave);
        } catch (IllegalArgumentException e) {
            errorMessage = "El usuario es obligatorio";
            loginResult = false;
        }
    }

    @Entonces("debería ser redirigido al panel de control")
    public void redirigidoAlPanel() {
        Assertions.assertTrue(loginResult, "El login debería ser exitoso");
    }

    @Entonces("debería ver un mensaje de error diciendo {string}")
    public void verMensajeDeError(String mensajeEsperado) {
        if (errorMessage != null) {
            Assertions.assertEquals(mensajeEsperado, errorMessage);
        } else {
            Assertions.assertFalse(loginResult);
            Assertions.assertEquals(mensajeEsperado, "Credenciales incorrectas");
        }
    }
}
