# systemACME
Contiene código que permite gestionar el salario de un empleado con datos ingresados desde un archivo de texto.
Descripción de la Solución.
El lenguaje de programación utilizado es Java, es una aplicación de consola, para las pruebas unitarias se utilizó JUnit. Consta de tres paquetes: en el paquete controlador esta la clase que contiene los métodos para calcular el salario a pagar, un paquete con una clase en donde se encuentra el ejecutable del programa y finalmente el paquete 
que contiene la clase en donde están las pruebas unitarias.
Arquitectura.
Se utilizó el patrón arquitectónico de capas, en la capa de presentación no existe una interfaz ya que es una aplicación por consola y en la capa de negocio se encuentra el la clase que contiene toda la funcionalidad que implementa la aplicación para calcular el salario de un empleado.
Enfoque y Metodología.
Ya que se trata de una aplicación pequeña en este caso se utilizó como enfoque de desarrollo el modelo en cascada en donde se realizó como primer punto el análisis del enunciado del programa, se establecieron los datos que se recibe como entrada y que es lo que se requiere como datos de salida, diseño de la solución, la codificación y finalmente las pruebas de validación.
Instrucciones para ejecutar el programa
1. Ejecutar la clase EjecutableSystemACME.
2. En la consola se le pedirá que ingrese la dirección en donde se encuentra el archivo de texto. Aquí debe copiar todo el path del archivo.
3. Se muestra el total a pagar a un empleado.
