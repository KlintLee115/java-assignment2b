package unitTests;

import implementations.MyDLL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author klintlee
 */
// DLLTest is a test class for the MyDLL class which implements a doubly linked list.
public class DLLTest {
    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
     */

    private MyDLL<String> myLinkedList;

    //Default constructor for the MyDLLTest class.
    public DLLTest() {
    }

    //set up before the execution
    @BeforeEach
    public void setUp() {
        myLinkedList = new MyDLL<String>();
    }

    //This method sets the  myLinkedList to null after the execution of setup
    @AfterEach
    public void tearDown() {
        myLinkedList = null;
    }

    /**
     * Test of size method, of class MyDLL.
     */
    @Test
    public void testSize() {
        assertEquals(0, myLinkedList.size());
        myLinkedList.add("1st Element");
        assertEquals(1, myLinkedList.size());
        myLinkedList.add("2nd Element");
        assertEquals(2, myLinkedList.size());


    }

    /**
     * Test of clear method, of class MyDLL.
     */
    @Test
    public void testClear() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        assertNotNull(myLinkedList.head);
        assertNotNull(myLinkedList.tail);
        myLinkedList.clear();
        assertNull(myLinkedList.head);
        assertNull(myLinkedList.tail);
    }

    @Test
    public void testAddNull() {
        assertThrows(NullPointerException.class, () -> {

            myLinkedList.add(null);
        });
    }

    /**
     * Test of add method, of class MyDLL.
     */
    @Test
    public void testAddAtIndex_int_Object() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        myLinkedList.add(1, "New Element");
        assertEquals("1st Element", myLinkedList.get(0));
        assertEquals("New Element", myLinkedList.get(1));
        assertEquals("2nd Element", myLinkedList.get(2));

    }

    @Test
    public void testAddNullIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {

            myLinkedList.add("1st Element");
            myLinkedList.add("2nd Element");
            myLinkedList.add(4, "New Element");
        });
    }

    /**
     * Test of add method, of class MyDLL.
     */
    @Test
    public void testAdd_Object() {
        assertTrue(myLinkedList.add("1st Element"));
        assertEquals(1, myLinkedList.size());
        assertEquals("1st Element", myLinkedList.get(0));

    }

    /**
     * Test of addAll method, of class MyDLL.
     */
    @Test
    public void testAddAll() {
        MyDLL<String> toAdd = new MyDLL<>();
        toAdd.add("1st Element");
        toAdd.add("2nd Element");
        myLinkedList.addAll(toAdd);
        assertEquals(2, myLinkedList.size());
        assertEquals("1st Element", myLinkedList.get(0));
        assertEquals("2nd Element", myLinkedList.get(1));
    }

    @Test
    public void getOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {

            myLinkedList.get(2);
        });
    }

    /**
     * Test of get method, of class MyDLL.
     */
    @Test
    public void testGet() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        assertEquals("1st Element", myLinkedList.get(0));
        assertEquals("2nd Element", myLinkedList.get(1));
    }

    /**
     * Test of remove method, of class MyDLL.
     */
    @Test
    public void testRemoveByIndex_int() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        myLinkedList.add("Element to Remove");
        String removed = (String) myLinkedList.remove(2);
        assertEquals("Element to Remove", removed);
        assertEquals(2, myLinkedList.size());

    }

    @Test
    public void removeOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myLinkedList.remove(3);
        });
    }

    /**
     * Test of remove method, of class MyDLL.
     */
    @Test
    public void testRemove_Object() {
        myLinkedList.add("1st Element");
        myLinkedList.add("Element to Remove");
        myLinkedList.add("2nd Element");
        String removed = (String) myLinkedList.remove("Element to Remove");
        assertEquals("Element to Remove", removed);
        assertEquals(2, myLinkedList.size());
    }

    /**
     * Test of set method, of class MyDLL.
     */
    @Test
    public void testSet() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        myLinkedList.add("3rd Element");
        assertEquals(3, myLinkedList.size());
        String expected = (String) myLinkedList.set(0, "New Element");
        assertEquals("1st Element", expected);
        assertEquals("New Element", myLinkedList.get(0));
        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void setOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {

            myLinkedList.set(0, "Testing Element");
        });
    }


    /**
     * Test of isEmpty method, of class MyDLL.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(myLinkedList.isEmpty());
        myLinkedList.add("Testing Element");
        assertFalse(myLinkedList.isEmpty());
    }

    /**
     * Test of contains method, of class MyDLL.
     */
    @Test
    public void testContains() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        assertTrue(myLinkedList.contains("1st Element"));
        assertTrue(myLinkedList.contains("2nd Element"));
        assertFalse(myLinkedList.contains("Testing Element"));
    }

    /**
     * Test of toArray method, of class MyDLL.
     */
    @Test
    public void testToArray_ObjectArr() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        String[] array = new String[2];
        array = (String[]) myLinkedList.toArray(array);
        assertEquals(2, array.length);
        assertEquals("1st Element", array[0]);
    }

    /**
     * Test of toArray method, of class MyDLL.
     */
    @Test
    public void testToArray_0args() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");

        Object[] array = myLinkedList.toArray();
        assertEquals(2, array.length);
        assertEquals("1st Element", array[0]);
    }

    /**
     * Test of iterator method, of class MyDLL.
     */
    @Test
    public void testIterator() {
        myLinkedList.add("1st Element");
        myLinkedList.add("2nd Element");
        Iterator<String> i1 = myLinkedList.iterator();

        assertTrue(i1.hasNext());
        assertEquals("1st Element", i1.next());
        assertTrue(i1.hasNext());
        assertEquals("2nd Element", i1.next());
        assertFalse(i1.hasNext());

    }

}