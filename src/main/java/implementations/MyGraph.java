package implementations;

import java.util.*;

class MyGraph<T> {

    private Map<T, List<T>> map = new HashMap<>();

    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);

        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection) {
            count /= 2;
        }
        return count;
    }

    public boolean hasVertex(T s) {
        return map.containsKey(s);
    }

    public boolean hasEdge(T s, T d) {
        return map.get(s).contains(d);
    }

}