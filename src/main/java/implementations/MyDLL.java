/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.NoSuchElementException;


/**
 * Implementation of a doubly linked list data structure.
 * This class implements the ListADT interface and provides
 * basic operations for a doubly linked list.
 *
 * @param <E> the type of elements stored in this list
 * @author Alen
 * @version 1.0
 */
public class MyDLL<E> implements ListADT<E> {

    /** The first node in the list */
    public MyDLLNode<E> head;

    /** The last node in the list */
    public MyDLLNode<E> tail;

    /** The current number of elements in the list */
    private int size;

    /**
     * Constructs an empty doubly linked list.
     * Initializes head and tail to null and size to 0.
     */
    public MyDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from this list, making it empty.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right.
     *
     * @param index index at which the specified element is to be inserted
     * @param toAdd element to be inserted
     * @return true if the element was successfully added
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt; size())
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Element to add cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            } else {
                tail = newNode;
            }
            head = newNode;
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = current.next;

            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param toAdd element to be added to the end of this list
     * @return true if the element was successfully added
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Element to add cannot be null");
        }
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;

    }

    /**
     * Adds all elements from the specified list to this list.
     *
     * @param toAdd list containing elements to be added to this list
     * @return true if all elements were successfully added
     * @throws NullPointerException if the specified list is null
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Added list must not be null.");
        }

        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt;= size())
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        MyDLLNode<E> current = head;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt;= size())
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        MyDLLNode<E> current = head;
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }
        size--;
        return current.item;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     *
     * @param toRemove element to be removed from this list, if present
     * @return true if this list contained the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Null elements cannot be removed.");
        }
        MyDLLNode<E> current = head;

        while (current != null) {
            if (current.item.equals(toRemove)) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev;
                    }
                }
                size--;
                return current.item;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param toChange element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &lt;= size())
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Null elements cannot be changed.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldValue = current.item;
        current.item = toChange;
        return oldValue;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param toFind element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Null elements cannot be searched.");
        }
        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.item.equals(toFind)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Null elements cannot be contained in an array.");
        }
        int listSize = size();
        if (listSize <= toHold.length) {
            MyDLLNode<E> current = head;
            for (int i = 0; i < listSize; i++) {
                toHold[i] = current.item;
                current = current.next;
            }

        }
        return toHold;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray() {
        int listSize = size();
        Object[] arrayList = new Object[listSize];
        MyDLLNode<E> current = head;
        for (int i = 0; i < listSize; i++) {
            arrayList[i] = current.item;
            current = current.next;
        }
        return arrayList;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    /**
     * Private inner class to implement the Iterator interface for the MyDLL class.
     */
    private class MyIterator implements Iterator<E> {
        private int currentIndex = 0;
        private boolean hasNext = true;
        private MyDLLNode<E> current = head;

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return hasNext;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements found.");
            }
            E result = current.item;
            current = current.next;
            currentIndex++;

            if (current == null) {
                hasNext = false;
            }
            return result;
        }
    }


}
