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
