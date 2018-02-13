class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        update(ret, n , new ArrayList<>());
        return ret;
    }
    
    private void update(List<List<Integer>> ret, int n, List<Integer> list) {   
        int small = (list.size () == 0 ? 2 : list.get(list.size() - 1));
        for (int i = small; i*i <= n; i++) {
            if (n%i == 0 && i <= n/i) {
                list.add(i);
                list.add(n/i);
                ret.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                update(ret, n/i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
