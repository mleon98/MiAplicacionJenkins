# language: es
@ecommerce
Característica: Carrito de Compras
  Como usuario autenticado
  Quiero agregar productos a mi carrito
  Para realizar una compra posteriormente

  Antecedentes:
    Dado que el usuario "juan.perez@mail.com" ha iniciado sesión

  Escenario: Agregar un producto con stock disponible
    Dado que existe el producto "Smartphone Samsung" con stock de 5 unidades
    Cuando el usuario agrega 2 unidades al carrito
    Entonces el carrito debería mostrar 2 artículos
    Y el stock restante del producto debería ser 3

  Esquema del escenario: Intentar agregar productos excediendo límites o stock
    Dado que existe el producto "<producto>" con stock de <stock_disponible> unidades
    Cuando el usuario intenta agregar <cantidad_a_agregar> unidades al carrito
    Entonces el sistema debería mostrar el mensaje "<mensaje_esperado>"
    Y el carrito debería tener <items_finales> artículos

    Ejemplos:
      | producto   | stock_disponible | cantidad_a_agregar | mensaje_esperado              | items_finales |
      | Laptop     | 10               | 11                 | Límite excedido: Máximo 10    | 0             |
      | Mouse      | 2                | 5                  | Solo quedan 2 unidades        | 2             |
      | Teclado    | 0                | 1                  | Producto agotado              | 0             |
