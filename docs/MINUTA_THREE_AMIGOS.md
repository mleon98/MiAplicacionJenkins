# Minuta de Sesión Three Amigos: Funcionalidad de Carrito de Compras

**Fecha:** 20 de Abril, 2026
**Participantes:**
- **Product Owner:** Esthela Business
- **Desarrollador:** Carlos Code
- **Tester (QA):** Pedro Proof

## 1. Objetivo de la Sesión
Definir los criterios de aceptación y escenarios para la funcionalidad de "Agregar al Carrito", asegurando que todos los roles tengan una visión compartida del comportamiento esperado.

## 2. Definición de la Funcionalidad
Como usuario registrado, quiero poder agregar productos al carrito de compras desde la página de catálogo para poder proceder al pago posteriormente.

## 3. Criterios de Aceptación Discutidos
- El usuario debe estar autenticado para agregar productos.
- Solo se pueden agregar productos con stock disponible.
- El carrito debe actualizar el total (subtotal e impuestos) cada vez que se agrega un producto.
- Se debe mostrar una notificación visual de "Producto Agregado".
- Existe un límite de 10 unidades por cada SKU para evitar compras masivas por bots (seguridad).

## 4. Ejemplos y Casos de Borde (Brainstorming)
- **Caso Exitoso:** Agrego 2 unidades de un producto con stock 10. Resultado: Se agregan.
- **Stock Justo:** Agrego 5 unidades cuando quedan 5. Resultado: Se agregan. Siguiente intento falla.
- **Superar Límite por SKU:** Intento agregar 11 unidades. Resultado: Mensaje de error, se limita a 10.
- **Stock Insuficiente:** Intento agregar 5 pero solo hay 2. Resultado: Se agregan solo 2 y se avisa al usuario.

## 5. Decisiones Tomadas
- Se utilizará un mensaje "Toast" para la confirmación.
- El cálculo del total se hará en el backend para evitar manipulaciones.
- Si el usuario no está logueado, se le redirige al login y luego vuelve al producto (Deep linking).
