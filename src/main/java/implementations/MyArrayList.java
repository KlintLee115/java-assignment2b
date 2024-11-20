/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Implementation of a dynamic array data structure.
 * This class implements the ListADT interface and provides
 * basic operations for a dynamic array, similar to Java's ArrayList.
 *
 * @param <E> the type of elements stored in this list
 *
 * @author klint
 *
 * @version 1.0
 */
public class MyArrayList<E> implements ListADT<E> {


    private static final int default_capacity = 12;
    private E[] array;
    private int size;

    /**
     * Creates an array of object using e as its Generic name with a length of default_capacity
     * Initializes size to 0
     */
    public MyArrayList() {
        this.array = (E[]) new Object[default_capacity];
        this.size = 0;
    }

    /**
     * Returns the elements in this array list
     *
     * @return the size of the elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Will remove the elements in the arraylist
     * sets the size to 0 / empty
     */
    @Override
    public void clear() {
        array = (E[]) new Object[default_capacity];
        size = 0;
    }


    /**
     * Adds element in the arraylist in the position specified
     *
     * @param index where the element is inserted
     * @param toAdd object element to be inserted
     * @throws NullPointerException      if the element that was added is null
     * @throws IndexOutOfBoundsException if index is not in the range and outside of the size
     * @return a boolean TRUE if the element was added
     */
    @Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Element to add cannot be null.");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = (E) toAdd;
        size++;
        return true;
    }

    /**
     * Function adds an element to end of the array
     *
     * @param toAdd object element to be added
     * @throws NullPointerException      if the element that was added is null
     * @throws IndexOutOfBoundsException **THIS WAS NOT IMPLEMENTED IN THIS FUNCTION - remove
     * @return a boolean TRUE if the element was added
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Element to add cannot be null.");
        }
        ensureCapacity();
        array[size] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("List to be added cannot be null.");
        }
        ensureCapacity();
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        return array[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        E itemToBeRemoved = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;

        return itemToBeRemoved;
    }

    @Override
    public E remove(Object toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Elements that we want to remove cannot be null.");
        }
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(array[i])) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Element that we want to remove cannot be null.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        E previousElement = array[index];
        array[index] = toChange;
        return previousElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Value to find cannot be null.");
        }
        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        if (toHold.length < size) {
            return (E[]) Arrays.copyOf(array, size, toHold.getClass());
        }
        System.arraycopy(array, 0, toHold, 0, size);
        return toHold;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex;


        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (currentIndex >= size) {
                throw new NoSuchElementException("No More elements found.");

            }
            return array[currentIndex++];

        }

    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }

}

