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
