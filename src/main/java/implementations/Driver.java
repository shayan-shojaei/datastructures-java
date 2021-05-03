package implementations;

import org.junit.Assert;

public class Driver {
    public static void main(String[] args) {
        testList();
        testLinkedList();
        testStack();
        testQueue();
        testHashMap();
        testGraph();
    }

    public static void testList() {
        MyList<String> list = new MyList<>();
        list.add("Hey yo");
        list.add("what up?");
        list.add("nothin much hbu?");
        Assert.assertEquals("Hey yo", list.get(0));
        Assert.assertEquals("what up?", list.get(1));
        Assert.assertEquals("nothin much hbu?", list.get(2));
        Assert.assertEquals(3, list.size());
    }

    public static void testLinkedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        Assert.assertTrue(list.isEmpty());

        list.insertAtEnd("HEYYY");
        list.insertAtEnd("WHATUP");
        list.insertAtBeginning("MA MAN");
        list.insertAfter(list.search("WHATUP"), "YOOOO");
        Assert.assertFalse(list.isEmpty());

        Assert.assertEquals("YOOOO", list.search("WHATUP").next.key);
    }

    public static void testStack() {
        MyStack<Integer> stack = new MyStack<>();

        Assert.assertTrue(stack.isEmpty());

        stack.push(5);
        stack.push(8);
        stack.push(14);

        Assert.assertFalse(stack.isEmpty());

        Assert.assertEquals(14, stack.pop().intValue());
        Assert.assertEquals(8, stack.peek().intValue());
    }

    public static void testQueue() {
        MyQueue<String> queue = new MyQueue<>();

        Assert.assertTrue(queue.isEmpty());

        queue.enqueue("Shayan");
        queue.enqueue("Mmd");
        queue.enqueue("UnYekiMmd");
        Assert.assertFalse(queue.isEmpty());

        Assert.assertEquals("Shayan", queue.dequeue());
        Assert.assertEquals("Mmd", queue.peekFront());
        Assert.assertEquals("UnYekiMmd", queue.peekRear());
    }

    public static void testHashMap() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        Assert.assertEquals(0, hashMap.size());
        hashMap.put("Shayan", 50);
        hashMap.put("Mmd", 70);
        hashMap.put("UnYekiMmd", 65);
        Assert.assertEquals(3, hashMap.size());
        Assert.assertTrue(hashMap.containsKey("Mmd"));
        Assert.assertFalse(hashMap.containsKey("Ali"));
        Assert.assertEquals(65, hashMap.get("UnYekiMmd").intValue());
    }

    public static void testGraph() {
        MyGraph<String> graph = new MyGraph<>(); // following graph
        graph.addEdge("Shayan", "Ali", true);
        graph.addVertex("Mmd");
        graph.addVertex("UnYekiMmd");
        graph.addEdge("Ali", "UnYekiMmd", false);
        Assert.assertTrue(graph.hasEdge("Ali", "Shayan"));
        Assert.assertFalse(graph.hasVertex("Amin"));
        Assert.assertEquals(1, graph.getEdgesCount(true));
        Assert.assertEquals(3, graph.getEdgesCount(false));
    }


}
