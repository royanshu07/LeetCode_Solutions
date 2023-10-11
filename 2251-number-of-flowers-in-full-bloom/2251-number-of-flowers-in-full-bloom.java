class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int[] f : flowers) {
            list.add(new Pair<>(f[0], 1));
            list.add(new Pair<>(f[1] + 1, -1));
        }
        Collections.sort(list, (a, b) -> a.getKey() - b.getKey());
        Map<Integer, Integer> mapBloom = new TreeMap<>();
        for (Pair<Integer, Integer> p : list) {
            mapBloom.put(p.getKey(), mapBloom.getOrDefault(p.getKey(), 0) + p.getValue());
        }
        List<Pair<Integer, Integer>> listFinal = new ArrayList<>();
        int sum = 0;
        for (int key : mapBloom.keySet()) {
            sum += mapBloom.get(key);
            listFinal.add(new Pair<>(key, sum));
        }
        for (int i = 0; i < people.length; i++) {
            int day = people[i];
            int idx = Collections.binarySearch(listFinal, new Pair<>(day, 0), (a,b) -> a.getKey().compareTo(b.getKey()));
            if (idx >= 0) {
                people[i] = listFinal.get(idx).getValue();
            } else if (idx < 0) {
                idx = -idx - 1;
                if (idx == listFinal.size() || idx == 0) {
                    people[i] = 0;
                } else {
                    idx = Math.max(0, idx - 1);
                    people[i] = listFinal.get(idx).getValue();
                }
            }
        }
        return people;
    }
}