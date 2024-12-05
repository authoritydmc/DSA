class Solution {
    public boolean canChange(String start, String target) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        Map<Character, Queue<Integer>> smap = new HashMap<>();
        Map<Character, Queue<Integer>> tmap = new HashMap<>();

        smap.put('L', new LinkedList<>());
        smap.put('R', new LinkedList<>());

        tmap.put('L', new LinkedList<>());
        tmap.put('R', new LinkedList<>());
        for (int i = 0; i < start.length(); i++) {
            char c = start.charAt(i);
            if (c == 'L') {
                smap.get(c).add(i);
                s.append(c);
            } else if (c == 'R') {
           
                smap.get(c).add(i);
                s.append(c);
            }
        }

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == 'L') {
                tmap.get(c).add(i);
                t.append(c);
            } else if (c == 'R') {
                tmap.get(c).add(i);
                t.append(c);
            }
        }

        if (s.toString().equals(t.toString())) {
            Queue<Integer> sL = smap.get('L');
            Queue<Integer> tL = tmap.get('L');
            Queue<Integer> sR = smap.get('R');
            Queue<Integer> tR = tmap.get('R');
            // match for all L in s should not be indexed less than L in targets..
            while (true) {
                if (sL.isEmpty() && tL.isEmpty() && sR.isEmpty() && tR.isEmpty())
                    return true;
                if (!sL.isEmpty() && sL.poll() < tL.poll())
                    return false;
                if (!sR.isEmpty() &&  sR.poll() > tR.poll())
                    return false;
                
            }
            
        }
        return false;
    }
}