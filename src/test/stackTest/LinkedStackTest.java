package test.stackTest;

import material.linear.stack.LinkedStack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for LinkedStack
 * 
 * @author Rackumi
 */
public class LinkedStackTest{

    @Test
    public void testSize(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        assertEquals(stack.size(), 0);
        for (int i=0;i<10;i++) {
            stack.push(i);
            assertEquals(stack.size(), i+1);
        }
    }

    @Test
    public void testIsEmpty(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testTopException(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.top();
    }

    @Test
    public void testTop(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        assertEquals((int)stack.top(),1);
        stack.push(2);
        assertEquals((int)stack.top(),2);
    }

    @Test
    public void testPush(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        for(int i=0; i<10; i++){
            stack.push(i);
            assertEquals((int)stack.top(), i);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPopException(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.pop();
    }

    @Test
    public void testPop(){
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        assertEquals((int)stack.pop(), 2);
        assertEquals((int)stack.top(), 1);
    }
    
}
