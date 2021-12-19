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
### Paquete tasks

_Este paquete contiene las tareas que son acciones de alto nivel que definen el conjunto de interacciones dentro del lengueje. Aqui creamos dos clases Buscar estilos y Seleccionar productos._

_Código Clase Buscar estilos_

```
package tasks;


import driver.GoogleChromeDriver;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uis.InicioFloresDeLujo;


import java.util.List;

public class BuscarEstilos implements Task  {
    private String producto;

    public BuscarEstilos (String producto){
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(InicioFloresDeLujo.OPCIONAMOR)
            );
        actor.attemptsTo(
            Click.on(InicioFloresDeLujo.PRODUCTO.of(producto))
        );
    }

    public static BuscarEstilos floresDeLujo(String producto){

        return Instrumented.instanceOf(BuscarEstilos.class).withProperties(producto);
    }

}

```
_Código Clase Seleccionar Productos_

```
package tasks;


import driver.GoogleChromeDriver;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class SeleccionarProductos implements Task  {


    private String producto;

    public SeleccionarProductos(String producto){
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
        );

    }

    public static SeleccionarProductos enlinio(String producto){

        return Instrumented.instanceOf(SeleccionarProductos.class).withProperties(producto);
    }

    public List<WebElement> enlistarProductos(){

        String elementoEncontrado;
        List<WebElement> listaDeProductos;
        listaDeProductos = GoogleChromeDriver.driver.findElements(By.xpath("//div[@class='detail-container']//span [@class='title-section']"));
        //elementoEncontrado = listaDeProductos.get(0).getText();
        return  listaDeProductos;

    }

    public String elementoSeleccionadoAleatoriamente(){
        int numeroAleatorio;
        numeroAleatorio = (int) (Math.random()*3);
        String elemento;
        elemento = enlistarProductos().get(numeroAleatorio).getText();
        return elemento;
    }
}

```

### Paquete uis

_Aquí tendremos los Target que contendran identificadores de pagina Xpath. _

_Codigo Clase Inicio flores de lujo_

```
package uis;

import net.serenitybdd.screenplay.targets.Target;

public class InicioFloresDeLujo {

    public static final Target PRODUCTO = Target.the("").locatedBy("//h2[@class='woocommerce-loop-product__title' and contains(.,'{0}')]");
    public static final Target OPCIONAMOR = Target.the("").locatedBy("//a[@class='et_pb_button et_pb_promo_button' and @href='https://floresdelujo.co/arreglos-florales-de-amor-en-medellin/']");
}

```
_Codigo Clase visualizar producto_

```
package uis;

import net.serenitybdd.screenplay.targets.Target;

public class VisualizarProducto {

    public static final Target NOMBRE = Target.the("").locatedBy( "//h1[contains(text(),'{0}')]");
}
```

### Paquete runners y stepsdefinitions

_El paquete runners es el encargado de ejecutar todos es escenarios cargados en features se especifican qué ejecutar y cómo hacerlo._
   

