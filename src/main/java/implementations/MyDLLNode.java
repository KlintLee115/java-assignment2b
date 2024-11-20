/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

/**
 * Represents a node in a doubly linked list data structure.
 * Each node contains an item and references to the next and previous nodes.
 * 
 * @param <E> the type of element stored in this node
 * @author Amani
 * @version 1.0
 */
public class MyDLLNode<E> {

    /** The data element stored in this node */
    public E item;

    /** Reference to the next node in the linked list */
    public MyDLLNode<E> next;

    /** Reference to the previous node in the linked list */
    public MyDLLNode<E> prev;

    /**
     * Constructs a new node with the specified item.
     * The next and previous references are initially null.
     *
     * @param item the data element to be stored in this node
     */
    public MyDLLNode(E item) {
        this.item = item;
    }
    

}
