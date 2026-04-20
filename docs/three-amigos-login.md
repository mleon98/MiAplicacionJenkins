# Resumen de Sesión: Three Amigos
**Funcionalidad**: Autenticación de Usuarios (Login)

## Participantes y Roles
*   **Product Owner (PO)**: Define el valor de negocio y los criterios de aceptación.
*   **Desarrollador (DEV)**: Evalúa la factibilidad técnica y los límites del sistema.
*   **QA Automation (QA)**: Define los escenarios de prueba, casos de borde y garantiza la testabilidad.

## Criterios de Aceptación (Discutidos)
1.  El usuario debe ingresar credenciales válidas (email y password) para acceder.
2.  Si las credenciales son incorrectas, debe mostrarse un mensaje de error genérico por seguridad.
3.  Después de 3 intentos fallidos, la cuenta no se bloquea aún (fuera de alcance para este MVP), pero se registra el evento.
4.  El sistema debe responder en menos de 200ms (SLA de performance).

## Ejemplos y Casos de Prueba (Discovery)
| Caso | Usuario | Contraseña | Resultado Esperado |
| :--- | :--- | :--- | :--- |
| Exitoso | `admin@mlsistemas.com` | `Admin123*` | Acceso Permitido |
| Fallido (Clave) | `admin@mlsistemas.com` | `Error404` | Acceso Denegado |
| Fallido (User) | `desconocido@mail.com` | `Cualquiera` | Acceso Denegado |
| Vacío | `` | `` | Error de Validación |
