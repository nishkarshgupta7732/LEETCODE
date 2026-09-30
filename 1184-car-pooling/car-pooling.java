class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int curr = 0;

        for(int[] trip : trips)
        {
            while(!pq.isEmpty() && pq.peek()[0]<=trip[1])
            {
                curr -= pq.poll()[1];
            }

            curr += trip[0];

            if(curr>capacity)
            {
                return false;
            }

            pq.add(new int[]{trip[2], trip[0]});
        }
        return true;
    }
}