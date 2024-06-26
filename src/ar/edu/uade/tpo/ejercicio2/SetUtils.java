package ar.edu.uade.tpo.ejercicio2;

public class SetUtils {
    public static <T> Set<T> copySet(Set<T> original) {
        Set<T> copy = new Set<>();
        for (T item : original.getItems()) {
            copy.add(item);
        }
        return copy;
    }

    public static void main(String[] args) {
        Set<String> originalSet = new Set<>();
        originalSet.add("a");
        originalSet.add("b");
        originalSet.add("c");

        System.out.println("Original Set: " + originalSet);

        Set<String> copiedSet = copySet(originalSet);
        System.out.println("Copied Set: " + copiedSet);
    }
}
