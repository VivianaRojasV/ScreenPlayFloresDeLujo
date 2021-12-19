package uis;

import net.serenitybdd.screenplay.targets.Target;

public class InicioFloresDeLujo {

    public static final Target PRODUCTO = Target.the("").locatedBy("//h2[@class='woocommerce-loop-product__title' and contains(.,'{0}')]");
    public static final Target OPCIONAMOR = Target.the("").locatedBy("//a[@class='et_pb_button et_pb_promo_button' and @href='https://floresdelujo.co/arreglos-florales-de-amor-en-medellin/']");
}
