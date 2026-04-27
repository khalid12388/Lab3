package aod.lab3;

import java.util.Random;

public class TimeTest {

    public static void main(String[] args) {

    	int[] sizes = {500, 1000, 2000, 4000};

        System.out.println("RANDOM");
        runTests(sizes, "random");

        System.out.println("\nSORTED");
        runTests(sizes, "sorted");

        System.out.println("\nREVERSED");
        runTests(sizes, "reversed");
    }

    public static void runTests(int[] sizes, String type) {

        testAlgorithm("Bubble", sizes, type);
        testAlgorithm("Insertion", sizes, type);
        testAlgorithm("Merge", sizes, type);
        testAlgorithm("Quick", sizes, type);
    }

    public static void testAlgorithm(String name, int[] sizes, String type) {

        System.out.println("\n" + name);

        for (int size : sizes) {

            long total = 0;

            for (int i = 0; i < 5; i++) {

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
                }

                long end = System.nanoTime();

                total += (end - start);
            }

            long avg = total / 5;

            System.out.println(size + " " + avg);
        }
    }

    public static SortableLinkedList<Integer> createList(int size, String type) {

        SortableLinkedList<Integer> list = new SortableLinkedList<>();
        Random rand = new Random();

        if (type.equals("random")) {
            for (int i = 0; i < size; i++) {
                list.add(rand.nextInt(100000));
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