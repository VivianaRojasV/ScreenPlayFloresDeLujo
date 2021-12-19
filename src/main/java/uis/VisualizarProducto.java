package uis;

import net.serenitybdd.screenplay.targets.Target;

public class VisualizarProducto {

    public static final Target NOMBRE = Target.the("").locatedBy( "//h1[contains(text(),'{0}')]");
}
