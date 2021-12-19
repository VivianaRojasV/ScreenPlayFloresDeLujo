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
