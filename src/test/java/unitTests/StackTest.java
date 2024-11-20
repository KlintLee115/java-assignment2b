package unitTests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implementations.MyStack;
import utilities.Iterator;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private MyStack<String> myStack;
    
    public StackTest() {
    }
    
    @BeforeEach
    public void setUp() {
        myStack = new MyStack<>();
    }
    
    @AfterEach
    public void tearDown() {
        myStack = null;
    }

    /**
     * Test of push method, of class MyStack.
     */
    @Test
    public void testPush() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        assertEquals("2nd Element", myStack.peek());
    }
    
    @Test
    public void testPushNull() {
        assertThrows(NullPointerException.class, () -> {
            myStack.push(null);
        });
    }


    /**
     * Test of pop method, of class MyStack.
     */
    @Test
    public void testPop() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        assertEquals("2nd Element", myStack.pop());
        assertEquals("1st Element", myStack.pop());
        assertTrue(myStack.isEmpty()); 
    }
    
    @Test
    public void testPopEmptyStack() {
        assertThrows(EmptyStackException.class, () -> {
            myStack.pop();
        });
    }

    /**
     * Test of peek method, of class MyStack.
     */
    @Test
    public void testPeek() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        assertEquals("2nd Element", myStack.peek());
        
    }
    
    @Test
    public void testPeekEmptyStack() {
        assertThrows(EmptyStackException.class, () -> {
            myStack.peek();
        });
    }

    /**
     * Test of clear method, of class MyStack.
     */
    @Test
    public void testClear() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        
        myStack.clear();
        assertTrue(myStack.isEmpty());
    }

    /**
     * Test of isEmpty method, of class MyStack.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(myStack.isEmpty());
        myStack.push("1st Element");
        assertFalse(myStack.isEmpty());
    }

    /**
     * Test of toArray method, of class MyStack.
     */
    @Test
    public void testToArray_0args() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        
        Object[] expectedArray = {"1st Element", "2nd Element"};
        assertArrayEquals(expectedArray, myStack.toArray()); 
    }

    /**
     * Test of toArray method, of class MyStack.
     */
    @Test
    public void testToArray_ObjectArr() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        String[] array = new String[2];
        String[] expectedArray = {"1st Element", "2nd Element"};
        
        assertArrayEquals(expectedArray, myStack.toArray(array));
    }

    /**
     * Test of contains method, of class MyStack.
     */
    @Test
    public void testContains() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        
        assertTrue(myStack.contains("1st Element"));
        assertFalse(myStack.contains("Element doesn't exist"));
    }
    
    @Test
    public void testToArrayWithNullHolder() {
        assertThrows(NullPointerException.class, () -> {
            myStack.toArray(null);
        });
    }

    /**
     * Test of search method, of class MyStack.
     */
    @Test
    public void testSearch() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        myStack.push("3rd Element");
        
        assertEquals(1, myStack.search("3rd Element"));
        assertEquals(2, myStack.search("2nd Element"));
        assertEquals(3, myStack.search("1st Element"));
        assertEquals(-1, myStack.search("4th Element"));
    }
  

    /**
     * Test of iterator method, of class MyStack.
     */
    @Test
    public void testIterator() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        
        Iterator<String> iterator = myStack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("1st Element", iterator.next());
        assertEquals("2nd Element", iterator.next());
        assertFalse(iterator.hasNext());
    }

    /**
     * Test of equals method, of class MyStack.
     */
    @Test
    public void testEquals() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        
        MyStack<String> secondStack = new MyStack<>();
        secondStack.push("1st Element");
        secondStack.push("2nd Element");
        
        assertTrue(myStack.equals(secondStack));
    }

    /**
     * Test of size method, of class MyStack.
     */
    @Test
    public void testSize() {
        myStack.push("1st Element");
        myStack.push("2nd Element");
        
        assertEquals(2, myStack.size());
    }
    
}
