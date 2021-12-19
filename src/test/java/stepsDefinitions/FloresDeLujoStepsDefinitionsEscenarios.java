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
