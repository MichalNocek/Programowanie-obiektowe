import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> lista2 = new ArrayList<>();

        ListIterator<Integer> iterator = lista1.listIterator(lista1.size());

        while (iterator.hasPrevious()) {
            Integer liczba = iterator.previous();
            lista2.add(liczba);
        }

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2 (odwrotność): " + lista2);
    }
}
