import java.util.*;

class Solution {

    // Converts 2D board array into a string representation
    private String getStrBoard(int[][] board) {
        StringBuilder str = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                str.append(cell);
            }
        }
        return str.toString();
    }

    // Swaps characters at two indices in the string
    private String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    // Generates neighbors of the current state by swapping '0' with valid indices
    private List<String> getNeighbours(String state) {
        List<String> neighbours = new ArrayList<>();
        int zeroIndex = state.indexOf("0");

        // System.out.println("Current state: " + state);
        // System.out.println("Zero is at index: " + zeroIndex);

        Map<Integer, List<Integer>> swapIndexes = Map.of(
                0, List.of(1, 3),
                1, List.of(0, 2, 4),
                2, List.of(1, 5),
                3, List.of(0, 4),
                4, List.of(1, 3, 5),
                5, List.of(4, 2));

        List<Integer> possibleSwaps = swapIndexes.getOrDefault(zeroIndex, Collections.emptyList());
        // System.out.println("Possible swaps for index " + zeroIndex + ": " + possibleSwaps);

        for (int swapIndex : possibleSwaps) {
            String newState = swap(state, zeroIndex, swapIndex);
            // System.out.println("Swapping zero with index " + swapIndex + " produces: " + newState);
            neighbours.add(newState);
        }

        return neighbours;
    }

    // Solves the sliding puzzle using BFS
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String target = "123450";
        String source = getStrBoard(board);
        q.add("#");
        // System.out.println("Source: " + source);
        q.add(source);

        int lvl = 0;
        while (!q.isEmpty()) {

            String state = q.poll();
            // state alreadty visited hence skip
            if (visited.contains(state)) {
                continue;
            }
            if (state.equals(target)) {
                // System.out.println("Target state matched: " + state);
                return lvl-1;
            }
            if (state.equals("#")) {
                lvl++;
                if (!q.isEmpty()) {
                    q.add("#"); // Add marker for the next level
                }
                continue;
            }
            visited.add(state);
            // System.out.println("Current state being processed: " + state);

            List<String> nbrs = getNeighbours(state);
            for (String nbr : nbrs) {
                if (!visited.contains(nbr)) {
                    // System.out.println("Adding neighbor to queue: " + nbr);
                    q.add(nbr);
                }
            }

        }

        // System.out.println("No solution found.");
        return -1;
    }

}
