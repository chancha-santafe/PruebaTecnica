Protecto - Prueba Tecnica

El proyecto esta resuelto por 2 formaas

1.- Servlet
2.- RestController


Solucion 1: Servlet:

com.prueba.demo.servlet.TestingServlet.java

Metodo POST para la carga de los datos:

A continuacion se muestran como se hace la carga de los datos:
localhost:8080/loadList?list=4&list=2&list=3
En este ejemplo de cargan 3 elementos: 4, 2 y 3.
Si se vuelve a ejecutar el mismo metodo se suman a los datos ya cargados.

 
Metodo GET es el que resuelve la operacion. A dicho metodo hay que pasarle que tipo de operacion quiere hacer sobre ls lista de numeros:
Las posibilidades son: SUM, MULTIPLICATION, DIVISION Y SUBTRACTION.

localhost:8080/loadList?operation=SUBTRACTION
localhost:8080/loadList?operation=SUM 
Hay que mencionar que solo es posible una operacion sobre la lista de los elementos. Apenas se ejecute la operacion la lista se setea vacia. 
Si el nombre de la operacion no es correcto o si se quiere hacer una operacion sobre la lista vacia el resultado es 0.



Solucion 2: RestController:

com.prueba.demo.controller.TestController

EndPoint 1: GET. Se le envia un JSON con la lista de numeros a cargar.
localhost:8080/api/loadList
JSON:
{
    "listNumber": [3,2,1]
}


EndPoint 2: GET. Envio de la operacion que se quiere hacer y nos devuelve el resultado de la operacion.
localhost:8080/api/operation/SUM
localhost:8080/api/operation/MULTIPLICATION