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

_Aquí tendremos los Target que contendran identificadores de pagina Xpath._

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
   
_Clase runner ejercicio 1_

```
package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\FloresDeLujo.feature",
        glue = "stepsDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class FloresDeLujoRunners {
}
```

_Clase runner ejercicio 2_

```
package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\FloresDeLujoB.feature",
        glue = "stepsDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class FloresDeLujoRunnersB {
}
```

_Clase runner ejercicio 3_

```
package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\FloresDeLujoEscenarios.feature",
        glue = "stepsDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class FloresDeLujoRunnersEscenarios {
}

```

_El paquete stepsdefinitions_

_Los Stepsdefinitions son los que contienen el código de los escenarios del feature las acciones como Given, When y Then._

_Clase Stepsdefinition ejercicio 1_

```
package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.GoogleChromeDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarEstilos;
import uis.VisualizarProducto;

public class FloresDeLujoStepsDefinitions {

    Actor actor = new Actor("Pepito Perez");

    @Given("^me encuentro en la pagina de FloresDeLujo$")
    public void meEncuentroEnLaPaginaDeFloresDeLujo() {
      actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://floresdelujo.co/")));
    }

    @When("^se ingresa al estilo amor para buscar (.*)$")
    public void seIngresaAlEstiloAmorParaBuscarRustic(String arregloFloral) {
        actor.attemptsTo(BuscarEstilos.floresDeLujo(arregloFloral));
    }

    @Then("^podre ver los productos (.*) en pantalla$")
    public void podreVerLosProductosRusticEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(VisualizarProducto.NOMBRE.of(producto)), WebElementStateMatchers.containsText(producto)));
    }

}
```

_Clase stepsdefinitions ejercicio 2_

```
package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.GoogleChromeDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarEstilos;
import uis.VisualizarProducto;

public class FloresDeLujoStepsDefinitionsB {

    Actor actor = new Actor(" Pepito Perez");

    @Given("^cargar pagina Flores de lujo$")
    public void cargarPaginaFloresDeLujo() {
      actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://floresdelujo.co/")));
    }

    @When("^ingresar al estilo amor para buscar (.*)$")
    public void ingresarAlEstiloAmorParaBuscar(String arregloFloral) {
        actor.attemptsTo(BuscarEstilos.floresDeLujo(arregloFloral));
    }

    @Then("^visualizo los productos (.*) en pantalla$")
    public void visualizLosProductosEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(VisualizarProducto.NOMBRE.of(producto)), WebElementStateMatchers.containsText(producto)));
    }

    @When("^ingreso al estilo amor para buscar (.*)$")
    public void ingresoAlEstiloAmorParaBuscar(String arregloFloral) {
        actor.attemptsTo(BuscarEstilos.floresDeLujo(arregloFloral));
    }

    @Then("^ver el producto (.*) en pantalla$")
    public void verElProductoEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(VisualizarProducto.NOMBRE.of(producto)), WebElementStateMatchers.containsText(producto)));
    }
}

```

_Clase stepsdefinitions ejercicio 3_

```
package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.GoogleChromeDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarEstilos;
import uis.VisualizarProducto;

public class FloresDeLujoStepsDefinitionsEscenarios {

    Actor actor = new Actor(" Pepito Perez");

    @Given("^cargue pagina Flores de lujo$")
    public void carguePaginaFloresDeLujo() {
      actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://floresdelujo.co/")));
    }

    @When("^entrar al estilo amor para buscar (.*)$")
    public void entrarAlEstiloAmorParaBuscar(String arregloFloral) {
        actor.attemptsTo(BuscarEstilos.floresDeLujo(arregloFloral));
    }

    @Then("^visualizare los productos (.*) en pantalla$")
    public void visualizareLosProductosEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(VisualizarProducto.NOMBRE.of(producto)), WebElementStateMatchers.containsText(producto)));
    }
    @Given("^cargue pagina de Flores de lujo$")
    public void carguePaginaDeFloresDeLujo() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://floresdelujo.co/")));
    }

    @When("^entrar al estilo licores para buscar (.*)$")
    public void entrarAlEstiloLicoresParaBuscar(String licores) {
        actor.attemptsTo(BuscarEstilos.floresDeLujo(licores));
    }

    @Then("^No visualizare los productos (.*) en pantalla$")
    public void noVisualizareLosProductosEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(VisualizarProducto.NOMBRE.of(producto)), WebElementStateMatchers.containsText(producto)));
    }
}

```

_Paquete features_

_En este paquete se describen las características y escenarios a probar haciendo uso del lenguaje Gherkin_

_Archivo feature ejercicio 1_

```
Feature: HU-001 Buscar arreglo en Flores De Lujo
  Yo como usuario de FL
  Quiero buscar un arreglo floral en la plataforma
  Para ver el nombre del producto en pantalla

  Scenario Outline: Buscar arreglo floral <NombreProducto>
    Given me encuentro en la pagina de FloresDeLujo
    When se ingresa al estilo amor para buscar <NombreProducto>
    Then podre ver los productos <NombreProducto> en pantalla

    Examples:
    |NombreProducto|
    |Rustic      |
    |fantasia    |
    |Rafaela   |
    |Cleopatra  |
    |Bianca    |
```

_Archivo feature ejercicio 2_

```
Feature: HU-001 Buscar arreglo en Flores De Lujo
  Yo como usuario de FL
  Quiero buscar un arreglo floral en la plataforma
  Para ver el nombre del producto en pantalla

  Background: Abrir pagina
    Given cargar pagina Flores de lujo
@Scenario1:
  Scenario Outline: Buscar arreglo floral
    When ingresar al estilo amor para buscar <flores>
    Then visualizo los productos <flores> en pantalla
    Examples:
      | flores |
      | Cleopatra |
@Scenario2:
  Scenario Outline: Buscar arreglo floral
    When ingreso al estilo amor para buscar <flores>
    Then ver el producto <flores> en pantalla
    Examples:
      | flores |
      | Rustic |

```

_Archivo feature 3_

```
Feature: HU-001 Buscar arreglo en Flores De Lujo
  Yo como usuario de FL
  Quiero buscar un arreglo floral en la plataforma
  Para ver el nombre del producto en pantalla

@ScenarioExits:
  Scenario Buscar arreglo floral
    Given cargue pagina Flores de lujo
    When entrar al estilo amor para buscar
    Then visualizare los productos en pantalla

@ScenarioFailed
  Scenario Buscar arreglo floral fallido
    Given cargue pagina de Flores de lujo
    When entrar al estilo licores para buscar
    Then no visualizare los productos en pantalla
```

_Aquí implementamos los conocimientos impartidos por la empresa SQA_
