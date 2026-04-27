/**
*
*/
package aod.lab3;
/**
* Implementation av {@linkplain List}, men som har fyra sorteringsmetoder.
* <p>
* Dessa metoder skall <em>inte</em> vara destruktiva, dvs ändra i objektet
* som de anropas på (dvs {@code this}.
* De skall returnera en kopia av objektet {@code this} som är sorterat.
* <p>
* De sorteringsmetoder som skall implementeras är:
* <ol>
* <li> Bubbel Sort
* <li> Insertion Sort
* <li> Merge Sort
* <li> Quick Sort
* </ol>
*
* @author Emilia Forslin
* @author Anders Jackson
* @version 2026-04-23
*/
public interface SortableList<T extends Comparable<? super T>> extends List<T> {
/**
* Implementation av Bubbel Sort.
*
* Är inte destruktiv, dvs ändrar inte {@code this}.
*
* @return {@linkplain SortableList} som är sorterad med Bubbel Sort.
*/
SortableList<T> bubbelSort();
/**
* Implementation av Insertion Sort.
*
* Är inte destruktiv, dvs ändrar inte {@code this}.
*
* @return {@linkplain SortableList} som är sorterad enligt Insertion Sort.
*/
SortableList<T> insertionSort();
/**
* Implementation av MergeSort.
*
* Är inte destruktiv, dvs ändra inte {@code this}.
*
* @return {@linkplain SortableList} som är sorterad enligt Merge Sort.
*/
SortableList<T> mergeSort();
/**
* Implementation av Quick Sort.
*
* Är inte destruktiv, dvs ändrar inte {@code this}.
*
* @return {@linkplain SortableList} som är sorterad enligt QuickSort.
*/
SortableList<T> quickSort();
}