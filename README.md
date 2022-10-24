# ProductHandler
App in Android Studio that handles CRUD with SQLite

## Details

Se deberá crear un proyecto en Android para poder administrar productos de cualquier tipo, es decir, poder dar de alta, actualizar, eliminar y consultar productos.

Para dicho proyecto, se deberá contar con las siguientes características:

- Al correr el proyecto, se deberá mostrar el listado de productos mostrando por cada producto lo siguiente:
    -	Nombre
    -	Precio
    -	Cantidad disponible en inventario
    -	Botón de Borrado
    -	Botón de Actualizar

- Por encima del listado, mostrar un botón que diga “Agregar”, una vez presionado el botón, se deberá mandar a otra Activity, en la cuál se mostrarán los campos para poder dar de alta un producto (nombre, precio, cantidad disponible en inventario), por lo que cuando se ingrese información y después se presione guardar, se deberá regresar a la activity principal con el listado, mostrando el nuevo producto.
 
- Cuando desde el activity principal se presiona el botón de Actualizar, se deberá mostrar otra activity con los campos llenos con la información actual, el usuario podrá modificar algún campo de información y después presionar guardar para que se redirija al usuario al activity principal mostrando el listado con la información del producto seleccionado actualizada.

- Al presionar el botón de Borrar, se deberá preguntar antes al usuario si de verdad desea borrar el producto, si confirma, se volverá a cargar la lista de productos ya sin el producto eliminado.

- Dicha información de los productos deberá ser almacenada en una base de datos de SQLIte.

## Evaluation

-	Activity Principal mostrando el listado junto con lo especificado (15%)

-	Activity para agregar un producto (15%)

-	Activity para actualizar un producto (15%)

-	Uso de Fragments (15%)

-	Uso de SQLite (15%)

-	Todos los integrantes del equipo sepan responder a las preguntas sobre el código (10%)

## Due to

Antes del Viernes 4 de Noviembre.
