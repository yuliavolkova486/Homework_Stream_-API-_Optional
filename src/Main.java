import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------task1------------------------------");

        List<Integer> ints = new ArrayList<>();
        ints.add(93);
        ints.add(-411);
        ints.add(12);
        ints.add(50);
        ints.add(346);
        ints.add(899);
        ints.add(21);
        ints.add(-10);
        ints.add(1);

        findMinMax(
                ints.stream(),
                Integer::compareTo,
                (min, max) -> System.out.printf("min: " + min + ", max: " + max + "\n")
        );

        System.out.println("-----------------------------task2------------------------------");
        findEvenNumber(ints);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> tList = stream.sorted(order).collect(toList());
        if (!tList.isEmpty()) {
            minMaxConsumer.accept(tList.get(0), tList.get((tList.size()) - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void findEvenNumber(List<Integer> list) {
        int x = (int) list.stream().filter((y)->(y % 2)==0).count();
        System.out.println("Количество четных чисел = " + x + " : "
                + list.stream().filter((y)->(y % 2)==0).collect(toList()));
    }
}




