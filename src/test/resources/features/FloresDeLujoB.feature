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


