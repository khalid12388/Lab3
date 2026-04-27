package aod.lab3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * En lista som bygger på min LinkedList och som även kan sortera elementen.
 * Sorteringsmetoderna ändrar inte originallistan utan returnerar en sorterad
 * kopia.
 *
 * @param <T> typen av element som måste kunna jämföras
 */
public final class SortableLinkedList<T extends Comparable<? super T>>
        implements SortableList<T> {

    private List<T> storage;

    public SortableLinkedList() {
        storage = new LinkedList<>();
    }

    @Override
    public void add(final T data) {
        storage.add(data);
    }

    @Override
    public void add(final T data, final int index) {
        storage.add(data, index);
    }

    @Override
    public T get(final int index) {
        return storage.get(index);
    }

    @Override
    public void set(final T data, final int index) {
        storage.set(data, index);
    }

    @Override
    public void remove() {
        storage.remove();
    }

    @Override
    public void remove(final int index) {
        storage.remove(index);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }

    private SortableLinkedList<T> copyList() {
        SortableLinkedList<T> copy = new SortableLinkedList<>();

        for (T element : this) {
            copy.add(element);
        }

        return copy;
    }

    @Override
    public SortableList<T> bubbelSort() {
        SortableLinkedList<T> sorted = copyList();

        for (int i = 0; i < sorted.size(); i++) {
            for (int j = 0; j < sorted.size() - 1 - i; j++) {

                if (sorted.get(j).compareTo(sorted.get(j + 1)) > 0) {
                    T temp = sorted.get(j);
                    sorted.set(sorted.get(j + 1), j);
                    sorted.set(temp, j + 1);
                }
            }
        }

        return sorted;
    }

    @Override
    public SortableList<T> insertionSort() {
        SortableLinkedList<T> sorted = copyList();

        for (int i = 1; i < sorted.size(); i++) {

            T key = sorted.get(i);
            int j = i - 1;

            while (j >= 0 && sorted.get(j).compareTo(key) > 0) {
                sorted.set(sorted.get(j), j + 1);
                j--;
            }

            sorted.set(key, j + 1);
        }

        return sorted;
    }

    @Override
    public SortableList<T> mergeSort() {
        ArrayList<T> list = new ArrayList<>();

        for (T element : this) {
            list.add(element);
        }

        mergeSortHelper(list, 0, list.size() - 1);

        SortableLinkedList<T> sorted = new SortableLinkedList<>();

        for (T element : list) {
            sorted.add(element);
        }

        return sorted;
    }

    private void mergeSortHelper(final ArrayList<T> list, final int left,
            final int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortHelper(list, left, mid);
            mergeSortHelper(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    private void merge(final ArrayList<T> list, final int left, final int mid,
            final int right) {

        ArrayList<T> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).compareTo(list.get(j)) <= 0) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(list.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    @Override
    public SortableList<T> quickSort() {
        ArrayList<T> list = new ArrayList<>();

        for (T element : this) {
            list.add(element);
        }

        quickSortHelper(list, 0, list.size() - 1);

        SortableLinkedList<T> sorted = new SortableLinkedList<>();

        for (T element : list) {
            sorted.add(element);
        }

        return sorted;
    }

    private void quickSortHelper(final ArrayList<T> list, final int low,
            final int high) {
        if (low < high) {

            int pivotIndex = partition(list, low, high);

            quickSortHelper(list, low, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, high);
        }
    }

    private int partition(final ArrayList<T> list, final int low,
            final int high) {

        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (list.get(j).compareTo(pivot) <= 0) {
                i++;

                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
