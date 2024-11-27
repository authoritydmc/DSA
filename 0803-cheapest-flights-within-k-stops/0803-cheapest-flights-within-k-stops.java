class Solution {

    private void buildGraph(Map<String, Integer> costMap, Map<Integer, List<Integer>> graph, int[][] flights) {
        for (int[] flightData : flights) {
            int src = flightData[0];
            int des = flightData[1];
            int cost = flightData[2];
            String costKey = src + "_" + des;
            costMap.put(costKey, cost);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(des);
        }
    }

    private int getCost(int src, int des, Map<String, Integer> costMap) {
        return costMap.getOrDefault(src + "_" + des, 0);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int minimum_cost = Integer.MAX_VALUE;
        Map<String, Integer> costMap = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> minCostAtLevel = new HashMap<>();

        buildGraph(costMap, graph, flights);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0 }); // {city, cost up to this city}
        q.add(new int[] { -1, 0 });
        int lvl = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int city = current[0];
            int currentCost = current[1];

            if (city == -1) {
                lvl++;
               // System.out.println("Lvl " + lvl + " explored ...");
                if (lvl > k + 1) {
                   // System.out.println("Lvl can not be explored further");
                    break;
                }
                if (!q.isEmpty()) {
                    q.add(new int[] { -1, 0 });
                }
                continue;
            }

            //System.out.println("Exploring city " + city + " with cost " + currentCost);

            if (city == dst) {
                minimum_cost = Math.min(minimum_cost, currentCost);
              //  System.out.println("Destination matched at Level " + lvl + " with cost " + currentCost);
            }

            List<Integer> nbrs = graph.getOrDefault(city, List.of());
            for (int nbr : nbrs) {
                int costToNbr = currentCost + getCost(city, nbr, costMap);

                if (costToNbr >= minimum_cost) continue; // Skip expensive paths

                if (minCostAtLevel.getOrDefault(nbr, Integer.MAX_VALUE) > costToNbr) {
                    minCostAtLevel.put(nbr, costToNbr);
                    q.add(new int[] { nbr, costToNbr });
                 //   System.out.println("Neighbor " + nbr + " added with cost " + costToNbr);
                }
            }

          //  System.out.println("Queue is now " + queueToString(q));
        }

        return minimum_cost == Integer.MAX_VALUE ? -1 : minimum_cost;
    }

    private String queueToString(Queue<int[]> queue) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] pair : queue) {
            if (pair[0] == -1) {
                sb.append("#, ");
                continue;
            }
            sb.append("(").append(pair[0]).append(", ").append(pair[1]).append("), ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
