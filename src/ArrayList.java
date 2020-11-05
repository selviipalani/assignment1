import java.util.Arrays;

public class ArrayList <E> implements List<E> {
    public static int size;
    public E[] array;

    public ArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Get function that returns item at specified position
     *
     * @param pos
     * @return item at specificied index
     * @throws Exception
     */
    @Override
    public E get(int pos) {
        return array[pos];
    }

    /**
     * Add function that adds an item to array list at end of array
     *
     * @param item
     * @return boolean
     */
    @Override
    public boolean add(E item) {
        if (size == array.length) {
            E[] newArr = (E[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[size++] = (E) item;
        return true;
    }

    /**
     * Add function that adds an item to the array list at a specified position
     *
     * @param pos
     * @param item
     */
    @Override
    public void add(int pos, E item) {
        for (int i = size; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = item;
        ++size;
    }

    /**
     * Remove function that removes an item from the array list at a specified index
     *
     * @param pos
     * @return T item
     */
    @Override
    public E remove(int pos) {
        E item = array[pos];

        for (int i = pos + 1; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return item;
    }

    /**
     * Sizr funtion returns size
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
