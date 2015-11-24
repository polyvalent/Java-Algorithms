package dataStructures;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class StackTest {

    Random r = new Random();
    int iterations = 10000;

    @Test
    public void test() throws Exception {
        java.util.Stack<Integer> javastack = new java.util.Stack<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < iterations; i++) {
            Integer item = r.nextInt();
            stack.push(item);
            javastack.push(item);
        }

        for (int i = 0; i < iterations; i++) {
            int choice = r.nextInt(4);
            try {
                switch (choice) {
                    case 0:
                        assertThat(stack.peek(), is(javastack.peek()));
                        break;
                    case 1:
                        assertThat(stack.pop(), is(javastack.pop()));
                        break;
                    case 2:
                        Integer searchItem = r.nextInt();
                        assertThat(stack.search(searchItem), is(javastack.search(searchItem)));
                        break;
                    case 3:
                        assertThat(stack.empty(), is(javastack.empty()));
                        break;
                    default:
                        searchItem = r.nextInt();
                        assertThat(stack.search(searchItem), is(javastack.search(searchItem)));
                        break;
                }
            } catch (EmptyStackException e) {
                continue;
            }
        }

        while (!stack.empty() && !javastack.empty()) {
            assertThat(stack.pop(), is(javastack.pop()));
        }

        assertThat(stack.size(), is(javastack.size()));
        assertThat(stack.size(), is(0));
        assertThat(javastack.size(), is(0));

    }
}