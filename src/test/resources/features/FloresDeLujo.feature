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
