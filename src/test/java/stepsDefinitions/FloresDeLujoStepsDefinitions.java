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
