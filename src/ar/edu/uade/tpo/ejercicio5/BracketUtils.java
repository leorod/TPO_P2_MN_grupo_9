package ar.edu.uade.tpo.ejercicio5;

import ar.edu.uade.tpo.common.Stack;

public class BracketUtils {
    private static final String ALLOWED_CHARS = "()'";

    /**
     * Complejidad: O(N + N^2) => O(N^2), ya que hay 2 iteraciones sobre strings en forma anidada (En forma general).
     * No obstante, en este caso ALLOWED_CHARS es constante, por lo que el costo de recorrerlo nunca será mayor a 3,
     * por lo que la complejidad real sería de O(3N), siempre y cuando no se modifique esa constante (en cuyo caso la complejidad
     * debería ser recalculada)
     * Todo el resto de instrucciones ejecutadas en la función son constantes.
     * Ver detalle línea por línea en comentarios dentro de la función.
     * @param input
     * @return
     */
    public static boolean isBalanced(String input) {
        Stack<Character> auxStack = new DynamicStack();
        boolean quoteOpen = false;
        boolean balanced = true;
        char[] chars = input.toCharArray(); // => O(N) : La implementación de Java de String.toCharArray() itera linealmente sobre los caracteres
        char ch;
        for (int i = 0; i < chars.length && balanced; i++) { // => O(N) : Nuevamente itero linealmente sobre los caracteres
            ch = chars[i];
            if (ALLOWED_CHARS.indexOf(ch) == -1) { // => O(N) : La implementación de Java de String.indexOf() itera linealmente sobre los caracteres
                throw new IllegalArgumentException("El string utilizado contiene caracteres inválidos. Sólo pueden usarse: \"(\", \")\" y \"'\"");
            }
            if (ch == '\'') { // => O(C) : Tanto la condicion del if como el interior son constantes
                quoteOpen = !quoteOpen;
            }
            if (!quoteOpen) { // => O(C)
                if (ch == '(') { // => O(C)
                    auxStack.add(ch); // => O(C)
                } else if (ch == ')') { // => O(C)
                    if (auxStack.isEmpty()) { // => O(C)
                        balanced = false;
                    } else {
                        auxStack.remove(); // => O(C)
                    }
                }
            }
        }
        return balanced && auxStack.isEmpty(); // => O(C)
    }
}
