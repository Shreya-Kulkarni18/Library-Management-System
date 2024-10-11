import java.util.*;

class PathBetweenBranches {
    private final Map<String, Map<String, Integer>> adjList = new HashMap<>();

    public void addBranch(String branch) {
        adjList.putIfAbsent(branch, new HashMap<>());
    }

    public void addEdge(String branch1, String branch2, int distance) {
        adjList.get(branch1).put(branch2, distance);
        adjList.get(branch2).put(branch1, distance); // If undirected
    }

    public Map<String, Integer> dijkstra(String startBranch) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (String branch : adjList.keySet()) {
            distances.put(branch, Integer.MAX_VALUE);
        }
        distances.put(startBranch, 0);
        pq.add(new AbstractMap.SimpleEntry<>(startBranch, 0));

        while (!pq.isEmpty()) {
            String branch = pq.poll().getKey();
            for (Map.Entry<String, Integer> neighbor : adjList.get(branch).entrySet()) {
                int newDist = distances.get(branch) + neighbor.getValue();
                if (newDist < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(neighbor.getKey(), newDist));
                }
            }
        }

        return distances; // Shortest distances from startBranch to all others
    }
}
