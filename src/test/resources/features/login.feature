# language: es
@auth
Característica: Autenticación de Usuarios
  Como usuario del sistema ML Sistemas
  Quiero ingresar mis credenciales
  Para acceder a las funcionalidades privadas de la plataforma

  Escenario: Inicio de sesión exitoso
    Dado que el usuario está en la página de login
    Cuando ingresa el usuario "admin@mlsistemas.com" y la clave "Admin123*"
    Entonces debería ser redirigido al panel de control

  Esquema del escenario: Intento de inicio de sesión con credenciales inválidas
    Dado que el usuario está en la página de login
    Cuando ingresa el usuario "<usuario>" y la clave "<clave>"
    Entonces debería ver un mensaje de error diciendo "<mensaje>"

    Ejemplos:
      | usuario                | clave      | mensaje                        |
      | admin@mlsistemas.com   | error123   | Credenciales incorrectas       |
      | noexiste@mail.com      | clave123   | Credenciales incorrectas       |
      |                        |            | El usuario es obligatorio       |
