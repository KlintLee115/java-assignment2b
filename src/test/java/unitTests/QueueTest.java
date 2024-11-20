package unitTests;

/*
  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
  * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
  */

 import exceptions.EmptyQueueException;
 import implementations.MyQueue;
 import org.junit.jupiter.api.AfterEach;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import utilities.Iterator;

 import static org.junit.jupiter.api.Assertions.*;

 public class QueueTest {

     /**
      * @author klintlee
      */
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
     public void testPeekEmptyQueue() throws EmptyQueueException {
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
         assertArrayEquals(new Object[]{"1st Element", "2nd Element"}, expectedArray);
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
         assertArrayEquals(new String[]{"1st Element", "2nd Element"}, expectedArray);
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
