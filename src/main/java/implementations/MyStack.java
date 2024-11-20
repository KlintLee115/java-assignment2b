/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import utilities.Iterator;
import utilities.StackADT;

import java.util.EmptyStackException;


/**
 * Implementation of a stack data structure using an array list.
 * This class implements the StackADT interface and provides
 * basic operations for a stack.
 *
 * @param <E> the type of elements stored in this stack
 *
 * @author Nathan
 */
public class MyStack<E> implements StackADT<E> {

    /** The array list to store stack elements */
    private final MyArrayList<E> array;
    
    /**
     * Creates a new MyArrayList and assigns it to the array variable
     */
    public MyStack() {
        array=new MyArrayList<>();
    }
    
    /**
     * Adds an element to the end of the stack
     * @param toAdd function to add element
     * @throws NullPointerException fires when the element being added is null
     */
    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Element to add cannot be null");
        }
         array.add(toAdd);
    }
    
    /**LIFO
     * Pops / removes and returns the top element of the stack
     * @return the array removing the top element of the stack
     * @throws EmptyStackException if this function is invoked and the stack is empty
     */
    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.remove(size() - 1);
    }
    
    /**
     * Returns the topmost element of the stack without deletion
     * @return the topmost element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() throws EmptyStackException {
         if (isEmpty()) {
            throw new EmptyStackException();
        }
         
        return array.get(size() - 1);
    }
    
    /**
     * Clears / deletes the whole array elements
     */
    @Override
    public void clear() {
        array.clear();
    }

    /**
     * Returns a boolean true if the stack is empty
     * @return bool TRUE if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * Returns the elements in the array
     * @return the elements in the array -> MyArrayList
     */
    @Override
    public Object[] toArray() {
        return array.toArray();
    }
    
    /**
     * 
     * @param holder where the elements is stored
     * @return the elements in the array
     * @throws NullPointerException if the array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
       return array.toArray(holder);
    }
    
    /**
     *
     * @param toFind the element whose presence in this stack is to be tested
     * @return true if this stack contains the specified element
     * @throws NullPointerException if the array is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return array.contains(toFind);
    }

    /**
     * Returns the 1-based position where an element is on this stack.
     * If the element toFind occurs as an item in this stack, this method returns
     * the distance from the top of the stack of the occurrence nearest the top of the stack;
     * the topmost element on the stack is considered to be at distance 1.
     * The equals method is used to compare toFind to the items in this stack.
     * @param toFind the element to search for
     * @return the 1-based position from the top of the stack where the element is located;
     *         the return value -1 indicates that the element is not on the stack
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public int search(Object toFind) {
        for (int i = 0; i < size(); i++) {
            if (toFind.equals(array.get(i))) {
                return size() - i;
            }
        }
        return -1;
    }

    /**
     * Returns an iterator over the elements in this stack in proper sequence
     * @return an iterator over the elements in this stack in proper sequence
     */
    @Override
    public Iterator iterator() {
        return array.iterator();
    }

    /**
     * Returns an iterator over the elements in this stack in proper sequence
     * @return an iterator over the elements in this stack in proper sequence
     */
    @Override
    public boolean equals(StackADT<E> that) {
         if (this.size() != that.size()) {
            return false;
        }
          Iterator<E> firstIterator = this.iterator();
        Iterator<E> secondIterator = that.iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            if (!firstIterator.next().equals(secondIterator.next())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns an int, size of the elements in an array
     * @return the array size
     */
    @Override
    public int size() {
        return array.size();
    }
}