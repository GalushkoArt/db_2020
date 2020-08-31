package homework;

import java.util.Arrays;

public class DynamicIntegerArrayImpl implements DynamicIntegerArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int[] array;
    private int size;

    public DynamicIntegerArrayImpl() {
        this.array = new int[DEFAULT_INITIAL_CAPACITY];
    }

    public DynamicIntegerArrayImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity can't be lower than 0");
        } else {
            this.array = new int[initialCapacity];
        }
    }

    /**
     * Returns element at the specified position
     * @param index index of the element in array
     * @return element with the specified position
     * @throws IllegalArgumentException if index is negative
     * @throws IndexOutOfBoundsException if index is equal or higher than array size
     */

    @Override
    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index in array can't be negative");
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException("Index must be lower than array's size");
        }
        return array[index];
    }

    /**
     * Appends value to the end of the array
     * @param value value to be added to the end of the array
     */

    @Override
    public void add(int value) {
        if (array.length == size()) {
            expandArray();
        }
        array[size++] = value;
    }

    /**
     * Returns current size of the array
     * @return current array's size
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Expands the size of the array
     */

    private void expandArray() {
        this.array = Arrays.copyOf(array, array.length * 2 + 1);
    }
}