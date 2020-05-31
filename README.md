# Compilador minimazado de Python

## Proyectos ##
1. En este proyecto se construyo el primer componente de un compilador, un
  analizador léxico. Se utilizo el generador de analizadores léxico JFlex.
  El lenguaje en el que esta escrito el código fuente es una versión minimizada de python; p.
2. En este proyecto se construyo el analizador sintáctico que verifica la secuencia de átomos,
  que reconoce el analizador léxico, tenga sentido bajo la gramática de p. Las herramientas utilizadas 
  fueron byaccj y jflex.
3. En este proyecto se agrego al reconocimiento sintáctico la generación del árbol de sintaxis abstracta
  (AST Abstract Syntax Tree). Basandonos en el patrón Compuesto para darle estructura al AST y en el 
  despacho dinámico que ofrece Java para obtener el comportamiento específico de cada nodo.
4. En este proyecto se realizo el análisis dependiente de contexto, es decir, que todo identificador sea definido antes de ser usado y que los operadores se utilicen con tipos adecuados, en caso contrario reportar el error.

## Equipo: KAAB ##

- García Argueta Jaime Daniel jaimegarciaargueta@ciencias.unam.mx
- Flores González Luis Brandon iluis@ciencias.unam.mx
- Ulises Manuel Cardenas ulises.ssb@ciencias.unam.mx
