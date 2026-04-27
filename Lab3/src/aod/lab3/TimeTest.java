package aod.lab3;

import java.util.Random;

/**
 * Program som testar sorteringsalgoritmernas körtider.
 */
public final class TimeTest {

    private static final int REPEATS = 5;
    private static final int RANDOM_BOUND = 100000;
    private static final int[] SIZES = {500, 1000, 2000, 4000};

    private TimeTest() {
    }

    public static void main(final String[] args) {
        System.out.println("RANDOM");
        runTests(SIZES, "random");

        System.out.println("\nSORTED");
        runTests(SIZES, "sorted");

        System.out.println("\nREVERSED");
        runTests(SIZES, "reversed");
    }

    public static void runTests(final int[] sizes, final String type) {
        testAlgorithm("Bubble", sizes, type);
        testAlgorithm("Insertion", sizes, type);
        testAlgorithm("Merge", sizes, type);
        testAlgorithm("Quick", sizes, type);
    }

    public static void testAlgorithm(final String name, final int[] sizes,
            final String type) {

        System.out.println("\n" + name);

        for (int size : sizes) {
            long total = 0;

            for (int i = 0; i < REPEATS; i++) {
                SortableLinkedList<Integer> list = createList(size, type);

                long start = System.nanoTime();

                switch (name) {
                    case "Bubble":
                        list.bubbelSort();
                        break;
                    case "Insertion":
                        list.insertionSort();
                        break;
                    case "Merge":
                        list.mergeSort();
                        break;
                    case "Quick":
                        list.quickSort();
                        break;
                    default:
                        break;
                }

                long end = System.nanoTime();
                total += end - start;
            }

            long avg = total / REPEATS;
            System.out.println(size + " " + avg);
        }
    }

    public static SortableLinkedList<Integer> createList(final int size,
            final String type) {

        SortableLinkedList<Integer> list = new SortableLinkedList<>();
        Random rand = new Random();

        if (type.equals("random")) {
            for (int i = 0; i < size; i++) {
                list.add(rand.nextInt(RANDOM_BOUND));
            }
        }

        if (type.equals("sorted")) {
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
        }

        if (type.equals("reversed")) {
            for (int i = size; i > 0; i--) {
                list.add(i);
            }
        }

        return list;
    }
}
