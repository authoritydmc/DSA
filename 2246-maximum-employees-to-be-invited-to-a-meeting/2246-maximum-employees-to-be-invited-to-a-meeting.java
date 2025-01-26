class Solution {

    private int BFS(int startNode, List<List<Integer>> reversedGraph, boolean[] visitedNodes) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startNode, 0});
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            for (int neighbor : reversedGraph.get(currentNode)) {
                if (!visitedNodes[neighbor]) {
                    visitedNodes[neighbor] = true;
                    queue.offer(new int[]{neighbor, currentDistance + 1});
                    maxDistance = Math.max(maxDistance, currentDistance + 1);
                }
            }
        }
        return maxDistance;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            reversedGraph.get(favorite[i]).add(i);
        }

        int longestCycle = 0;
        int happyCoupleCount = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int curNode = i;
                int curLength = 0;
                Map<Integer, Integer> nodeMap = new HashMap<>();

                while (true) {
                    if (visited[curNode]) break;
                    visited[curNode] = true;
                    nodeMap.put(curNode, curLength++);
                    int nextNode = favorite[curNode];

                    if (nodeMap.containsKey(nextNode)) {
                        int cycleLength = curLength - nodeMap.get(nextNode);
                        longestCycle = Math.max(longestCycle, cycleLength);

                        if (cycleLength == 2) {
                            boolean[] bfsVisited = new boolean[n];
                            bfsVisited[curNode] = bfsVisited[nextNode] = true;
                            happyCoupleCount += 2 +
                                    BFS(nextNode, reversedGraph, bfsVisited) +
                                    BFS(curNode, reversedGraph, bfsVisited);
                        }
                        break;
                    }
                    curNode = nextNode;
                }
            }
        }
        return Math.max(longestCycle, happyCoupleCount);
    }
}
