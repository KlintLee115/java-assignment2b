package unitTests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.NoSuchElementException;

import exceptions.EmptyQueueException;
import implementations.MyArrayList;
import implementations.MyDLL;
import implementations.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    private MyArrayList<String> myList;

    @BeforeEach
    public void setUp() {
        myList = new MyArrayList<>();
    }

    @AfterEach
    public void tearDown() {
        myList = null;
    }

    public ArrayListTest() {
    }

    /**
     * Test of size method, of class MyArrayList.
     */
    @Test
    public void testSize() {
        assertEquals(0, myList.size());
        myList.add("1st Element");
        assertEquals(1, myList.size());
        myList.add("2nd Element");
        assertEquals(2, myList.size());
    }

    /**
     * Test of clear method, of class MyArrayList.
     */
    @Test
    public void testClear() {
        myList.add("1st Element");
        myList.add("2nd Element");
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testAddNull() {
        assertThrows(NullPointerException.class, () -> {
            myList.add(null);
        });
    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testAddATIndex_int_Object() {
        myList.add("1st Element");
        myList.add("2nd Element");
        myList.add(1, "New Element");
        assertEquals("1st Element", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals("2nd Element", myList.get(2));
    }

    @Test()
    public void testAddToIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.add(1, "New Element");
        });
    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testAdd_Object() {
        assertTrue(myList.add("1st Element"));
        assertEquals(1, myList.size());
        assertEquals("1st Element", myList.get(0));
    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test
    public void testAddAll() {
        MyArrayList<String> toAdd = new MyArrayList<>();
        toAdd.add("1st Element");
        toAdd.add("2nd Element");

        assertTrue(myList.addAll(toAdd));
        assertEquals(2, myList.size());
        assertEquals("1st Element", myList.get(0));
        assertEquals("2nd Element", myList.get(1));

    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test
    public void testGet() {
        myList.add("1st Element");
        myList.add("2nd Element");
        assertEquals("1st Element", myList.get(0));
        assertEquals("2nd Element", myList.get(1));
    }

    @Test()
    public void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {

            myList.get(4);
        });
    }

    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemoveAtIndex_int() {
        myList.add("1st Element");
        myList.add("2nd Element");
        assertEquals("1st Element", myList.remove(0));
        assertEquals(1, myList.size());
        assertEquals("2nd Element", myList.get(0));
    }

    public void testRemoveOutOfBounds() {
        myList.remove(0);
    }

    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemove_Object() {
        myList.add("1st Element");
        myList.add("2nd Element");

        String removed = (String) myList.remove("1st Element");
        assertNotNull(removed);
        assertEquals("1st Element", removed);
        assertEquals(1, myList.size());
        assertEquals("2nd Element", myList.get(0));
    }

    /**
     * Test of set method, of class MyArrayList.
     */
    @Test
    public void testSet() {
        myList.add("1st Element");
        myList.add("2nd Element");
        assertEquals("1st Element", myList.set(0, "New Element"));
        assertEquals("New Element", myList.get(0));
        assertEquals("2nd Element", myList.get(1));
    }

    /**
     * Test of isEmpty method, of class MyArrayList.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(myList.isEmpty());

        myList.add("An Element");
        assertFalse(myList.isEmpty());
    }

    /**
     * Test of contains method, of class MyArrayList.
     */
    @Test
    public void testContains() {
        myList.add("1st Element");
        myList.add("2nd Element");

        assertTrue(myList.contains("1st Element"));
        assertFalse(myList.contains("Non Existant Element"));
    }

    /**
     * Test of toArray method, of class MyArrayList.
     */
    @Test
    public void testToArray_ObjectArr() {
        myList.add("1st Element");
        myList.add("2nd Element");

        String[] testArray = new String[2];
        testArray = (String[]) myList.toArray(testArray);
        assertEquals("1st Element", testArray[0]);
        assertEquals("2nd Element", testArray[1]);
    }

    /**
     * Test of toArray method, of class MyArrayList.
     */
    @Test
    public void testToArray_0args() {
        myList.add("1st Element");
        myList.add("2nd Element");
        Object[] testArray = myList.toArray();
        assertEquals("1st Element", testArray[0]);
        assertEquals("2nd Element", testArray[1]);
    }

    /**
     * Test of iterator method, of class MyArrayList.
     */
    @Test
    public void testIterator() {
        myList.add("1st Element");
        myList.add("2nd Element");

        Iterator<String> iterator = myList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("1st Element", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("2nd Element", iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test()
    public void testIteratorNoSuchElement() {
        assertThrows(NoSuchElementException.class, () -> {

            Iterator<String> i1 = myList.iterator();
            i1.next();
        });
    }

    //MyDLLTest is a test class for the MyDLL class which implements a doubly linked list.
    public static class DLLTest {
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

        ;

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

    public static class QueueTest {
        private MyQueue<String> myQueue;

        public QueueTest() {
        }

        @BeforeEach
        public void setUp() {
            myQueue = new MyQueue<>();
        }

        @AfterEach
        public void tearDown() {
            myQueue = null;
        }

        /**
         * Test of enqueue method, of class MyQueue.
         */
        @Test
        public void testEnqueue() {
            myQueue.enqueue("1st Element");
            assertFalse(myQueue.isEmpty());
            assertEquals(1, myQueue.size());

            myQueue.enqueue("2nd Element");
            assertEquals(2, myQueue.size());
        }

        @Test
        public void testEnqueueNull() {
            assertThrows(NullPointerException.class, () -> {
                myQueue.enqueue(null);
            });
        }

        /**
         * Test of dequeue method, of class MyQueue.
         */
        @Test
        public void testDequeue() throws EmptyQueueException {
            myQueue.enqueue("1st Element");
            assertFalse(myQueue.isEmpty());
            myQueue.dequeue();
            assertTrue(myQueue.isEmpty());
        }

        /**
         * Test of peek method, of class MyQueue.
         */
        @Test
        public void testPeek() throws EmptyQueueException {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");
            assertEquals("1st Element", myQueue.peek());
            myQueue.dequeue();
            assertEquals("2nd Element", myQueue.peek());
        }

        @Test
        public void testPeekEmptyQueue() {
            assertThrows(EmptyQueueException.class, () -> {
                myQueue.peek();
            });
        }

        /**
         * Test of dequeueAll method, of class MyQueue.
         */
        @Test
        public void testDequeueAll() {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");
            assertFalse(myQueue.isEmpty());
            myQueue.dequeueAll();
            assertTrue(myQueue.isEmpty());
            assertEquals(0, myQueue.size());
        }

        /**
         * Test of isEmpty method, of class MyQueue.
         */
        @Test
        public void testIsEmpty() {
            assertTrue(myQueue.isEmpty());
            myQueue.enqueue("1st Item");
            assertFalse(myQueue.isEmpty());
        }

        /**
         * Test of iterator method, of class MyQueue.
         */
        @Test
        public void testIterator() {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");
            Iterator<String> i1 = myQueue.iterator();
            assertTrue(i1.hasNext());
            assertEquals("1st Element", i1.next());

            assertTrue(i1.hasNext());
            assertEquals("2nd Element", i1.next());

            assertFalse(i1.hasNext());

        }

        /**
         * Test of equals method, of class MyQueue.
         */
        @Test
        public void testEquals() throws EmptyQueueException {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");
            MyQueue<String> myQueue2 = new MyQueue<>();
            myQueue2.enqueue("1st Element");
            myQueue2.enqueue("2nd Element");

            assertTrue(myQueue.equals(myQueue2));
            myQueue.dequeue();
            assertFalse(myQueue.equals(myQueue2));
        }

        /**
         * Test of toArray method, of class MyQueue.
         */
        @Test
        public void testToArray_0args() {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");

            Object[] expectedArray = myQueue.toArray();
            assertArrayEquals(new Object[]{"1st Element","2nd Element"}, expectedArray);
        }

        /**
         * Test of toArray method, of class MyQueue.
         */
        @Test
        public void testToArray_ObjectArr() {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");

            String[] array = new String[2];
            String[] expectedArray = (String[]) myQueue.toArray(array);
            assertArrayEquals(new String[]{"1st Element","2nd Element"}, expectedArray);
        }
        @Test
        public void testToArrayWithNullHolder() {
            assertThrows(NullPointerException.class, () -> {
                myQueue.toArray(null);
            });
        }

        /**
         * Test of size method, of class MyQueue.
         */
        @Test
        public void testSize() throws EmptyQueueException {
            myQueue.enqueue("1st Element");
            myQueue.enqueue("2nd Element");
            myQueue.enqueue("3rd Element");

            assertEquals(3, myQueue.size());
            myQueue.dequeue();
            assertEquals(2, myQueue.size());
        }

        /**
         * Test of isFull method, of class MyQueue.
         */
        @Test
        public void testIsFull() {
            assertFalse(myQueue.isFull());
        }

    }
}
