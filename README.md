# ScreenPlayFloresDeLujo

_Dando continuidad al Semillero de Automatización de SQA, explicaremos el presente reto el cual implementamos con el patrón de diseño para la automatización ScreenPlay. Este patrón cumple con todos los principios Solid, pone a trabajar al usuario en términos de tareas y no de interfaz. Este tiene arquitectura de Features + Runners, Step Definicions, Taks, Interaction, Quiestion e interface de usuario._

## Las herramientas usadas para su procedimiento fueron:

* IDEA Intellij

* Navegador Google Chrome con su chormedriver

* Lenguaje de programación Java

* Patrón de diseño ScreenPlay 

## Requerimiento del reto :bulb:

* Buscar los 5 productos no desde el excel sino desde el feature con examples.

* Utilizar un Background para realizar como mínimo 2 escenarios.

* Realizar un escenario fallido y uno exitoso sin examples.

## Pasos de la automatización :arrow_forward:

_Abrir el navegador y buscar la página https://floresdelujo.co/, desde el archivo features realizamos nuestro proceso de pruebas, se crean 3 uno para buscar el producto con el example, el segundo se realizará con el Background y el tercero realizará la búsqueda exitosa de un producto y el otro de forma fallida usando la clave “licores”._

## Paquetes, clases y métodos usados.

_Explicaremos el código implementado._

### Paquete Driver

_Clase GoogleChromeDriver._

_En la clase GoogleChromeDriver se crea un método ChromeDriver con parámetro de String o link, este nos permite abrir el navegador y realizar la búsqueda de la pagina https://floresdelujo.co/._
```
public static void chromeWebDriver(String url){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--ignore-certificate-errors");
    options.addArguments("--disable-infobars");
    driver = new ChromeDriver(options);
    driver.get(url);
}

```




