package aod.lab3;

/**
 * Interface för en enkel lista.
 * Innehåller metoder för att lägga till, hämta, ändra och ta bort element.
 *
 * @author Khalid Abdi Hashi
 * @date 2026-04-10
 */
public interface List<T> extends Iterable<T> {

    /**
     * Lägger till ett element sist i listan.
     *
     * @param data elementet som ska läggas till
     */
    void add(T data);

    /**
     * Lägger till ett element på en specifik position i listan.
     *
     * @param data elementet som ska läggas till
     * @param index positionen där elementet ska läggas till
     */
    void add(T data, int index);

    /**
     * Hämtar elementet på en specifik position.
     *
     * @param index positionen i listan
     * @return elementet på angiven position
     */
    T get(int index);

    /**
     * Ändrar värdet på en specifik position i listan.
     *
     * @param data det nya värdet
     * @param index positionen som ska ändras
     */
    void set(T data, int index);

    /**
     * Tar bort det sista elementet i listan.
     */
    void remove();

    /**
     * Tar bort elementet på en specifik position i listan.
     *
     * @param index positionen för elementet som ska tas bort
     */
    void remove(int index);

    /**
     * Returnerar antalet element i listan.
     *
     * @return listans storlek
     */
    int size();

    /**
     * Tömmer listan på alla element.
     */
    void clear();
}
