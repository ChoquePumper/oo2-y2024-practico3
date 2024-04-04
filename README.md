# Objetos 2 - Intro Refactoring

Escribamos código que otro desarrollador pueda entender! Refactorizamos para:
- Simplificar el Código
- Remover Código Duplicado
- Mejorar el Diseño
- Transformar algo procedural en OO
- Reducir acoplamiento
- Mejorar Cohesión
- Separar en capas
- Hacerlo mas expresivo/legible (nombrar el código)
- Remover código muerto

Todo esto puedo hacerse con seguridad únicamente si tengo buena covertura de tests.

Algunos links de interes:

- [Refactoring Catalog](https://refactoring.com/catalog/)
- [Smells](https://sourcemaking.com/refactoring/smells)
- [Technical Debt](https://en.wikipedia.org/wiki/Technical_debt)

## Introducción

- Extract Method: Dándole semántica a conjuntos de colaboraciones
- Números mágicos: Dándole semántica a las constantes
- Simplificando condicionales: Un único nivel de indentación. *else* no es necesario.
- Parámetros
    - De entrada: programación defensiva
    - De salida: No usamos más *null*. Optional o Listas vacias.
- Collecting parameters: Filtrando colleciones polimórficas.

## Ejercicios

Algunos ejercicios tienen tests y otros hay que escribirlos. En dos ejercicios propongo los pasos que deben ejecutar
para refactorizar.

- Ejercicio 1: Utilicemos polimorfismo.
    - Escribamos Tests.
- Ejercicio 2, Pasos a realizar:
    - Movamos la lectura del archivo csv a otra clase.
    - Mejoremos el for utizando el foreach.
    - Transformemos el método estático en método de instancia (agreguemos constructor e inicialicemos ahi).
    - Removamos código duplicado utilizando expresiones lambda.
    - Removamos las constantes duplicadas.
- Ejercicio 3: Utilicemos polimorfismo y collecting parameters.
    - Escribamos tests. Hagamos lo mínimo para que nos permita testear. Por ejemplo, no usar *sysout*, retornar un
      *String* con e reporte. Esto nos permite asertar contra el valor de retorno.
    - Incorporemos la jerarquía de gastos para utilizar polimorfismo.
    - Apliquemos polimorfismo para eliminar el switch.
    - Apliquemos polimorfismo (collecting parameter) para eliminar preguntar por el tipo para el calculo del monto de comida.
    - Apliquemos polimorfismo (collecting parameter) para eliminar preguntar por el tipo para la marca de exceso.
- Ejercicio 4: Removamos el uso de *null*.

El ejercicio 2 fue tomado de [lamchau](https://github.com/lamchau/refactoring-exercise).