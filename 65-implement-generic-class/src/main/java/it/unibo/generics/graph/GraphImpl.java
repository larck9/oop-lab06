package it.unibo.generics.graph;
import it.unibo.generics.graph.api.Graph;
import java.util.*;

public class GraphImpl<N> implements Graph<N> {

    private Map<N, Set<N>> graphMap;

    public GraphImpl() {
        this.graphMap = new HashMap<>();
    }

    // Adds a node: nothing happens if node is null or already there
    public void addNode(N node) {
        if (node == null) return;
        graphMap.putIfAbsent(node, new HashSet<>()); // Evita null nel set di adiacenza
    }

    // Adds an edge: nothing happens if source or target are null
    public void addEdge(N source, N target) {
        if (source == null || target == null) return;

        graphMap.putIfAbsent(source, new HashSet<>());
        graphMap.putIfAbsent(target, new HashSet<>());

        graphMap.get(source).add(target);
        graphMap.get(target).add(source);
    }

    // Returns all the nodes
    public Set<N> nodeSet() {
        return new HashSet<>(graphMap.keySet());
    }

    // Returns all the nodes directly targeted from node
    public Set<N> linkedNodes(N node) {
        return graphMap.getOrDefault(node, Collections.emptySet());
    }

    // Gets one sequence of nodes connecting source to target
    public List<N> getPath(N source, N target) {
        if (!graphMap.containsKey(source) || !graphMap.containsKey(target)) {
            return Collections.emptyList(); // Se uno dei nodi non esiste, non c'è percorso
        }

        Set<N> visited = new HashSet<>();
        List<N> path = new ArrayList<>();

        if (PathSearch(source, target, graphMap, visited, path)) {
            return path;
        }

        return Collections.emptyList();
    }

    private boolean PathSearch(N current, N target, Map<N, Set<N>> graph, Set<N> visited, List<N> path) {
        visited.add(current);
        path.add(current);

        // Debugging
       // System.out.println("Visiting: " + current + ", Path so far: " + path);

        if (current.equals(target)) {
            return true;
        }

        for (N neighbor : graph.getOrDefault(current, Collections.emptySet())) {
            if (!visited.contains(neighbor)) {
                if (PathSearch(neighbor, target, graph, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1); // Backtracking
        return false;
    }
}
