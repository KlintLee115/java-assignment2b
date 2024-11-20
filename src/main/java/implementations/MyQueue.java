/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * This class represents a Queue implementation using a doubly linked list as the underlying data structure.
 * It implements the QueueADT interface, providing the necessary methods to operate a queue.
 *
 * @param <E> the type of elements held in this queue
 * 
 * @author KlintLee115
 */
public class MyQueue<E> implements QueueADT<E> {
    
    /** The underlying data structure to store the elements of the queue */
    private MyDLL<E> elements;

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        elements = new MyDLL<>();
    }

    /**
     * Adds an item to the end of the queue.
     *
     * @param toAdd the item to be added to the queue
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("New element cannot be null");
        elements.add(toAdd);
    }

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the item at the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return elements.remove(0);
    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return the item at the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E peek() throws EmptyQueueException {
        if (elements.isEmpty()) throw new EmptyQueueException();
        return elements.get(0);
    }

    /**
     * Removes all items from the queue.
     */
    @Override
    public void dequeueAll() {
        elements.clear();
    }

    /**
     * Returns {@code true} if the queue contains no items.
     *
     * @return {@code true} if the queue contains no items
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     *
     * @return an iterator over the elements in this queue in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    /**
     * Compares the specified object with this queue for equality.
     * To be equal, two queues must contain equal items appearing in the same order.
     *
     * @param that the queue to be compared to this queue
     * @return {@code true} if the specified object is equal to this queue
     */
    @Override
    public boolean equals(QueueADT that) {
        if (this == that) return true;
        if (that == null || this.size() != that.size()) return false;

        Iterator<E> originalIter = this.iterator();
        Iterator<E> compareIter = that.iterator();

        while (originalIter.hasNext() && compareIter.hasNext()) {
            if (!originalIter.next().equals(compareIter.next())) {
                return false;
            }
        }
        return !originalIter.hasNext() && !compareIter.hasNext();
    }

    /**
     * Returns an array containing all of the elements in this queue in proper sequence.
     *
     * @return an array containing all of the elements in this queue
     */
    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue in proper sequence;
     * the type of the returned array is that of the specified array.
     *
     * @param holder the array into which the elements of this queue are to be stored, if it is big enough;
     *        otherwise, a new array of the same  type is allocated for this purpose
     * @return an array containing the elements of this queue
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        return elements.toArray(holder);
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * This operation is only implemented when a fixed length queue is required. It will not be implemented for this scenario
     *
     * @return {@code true} if queue is at capacity, otherwise {@code false}
     */
    @Override
    public boolean isFull() {
        return false;  // This queue implementation does not have a fixed capacity
    }
}