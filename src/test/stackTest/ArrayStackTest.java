package test.stackTest;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import material.linear.stack.ArrayStack;
import org.junit.Test;

/**
 * Test for class ArrayStack
 *
 * @author Rackumi
 */
public class ArrayStackTest{

    @Test
    public void testIsEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        assertTrue(stack.isEmpty());
        stack.push(3);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopException(){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        stack.pop();
    }

    @Test
    public void testPop(){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        stack.push(1);
        stack.push(2);
        int salida = stack.pop();
        assertEquals(salida, 2);
        salida = stack.pop();
        assertEquals(salida, 1);
    }

    @Test
    public void testSize(){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        assertEquals(stack.size(), 0);
        for(int i=0; i<10; i++){
            stack.push(i);
            assertEquals(stack.size(), i+1);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testTopException(){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        stack.top();
    }

    @Test
    public void testTop(){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        for(int i=0; i<3; i++){
            stack.push(i);
        }
        assertEquals(stack.top().intValue(), 2);
    }

    @Test
    public void testPush(){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        for(int i=0; i<6; i++){
            stack.push(i);
        }
        assertEquals(stack.size(), 6);
    }

}
