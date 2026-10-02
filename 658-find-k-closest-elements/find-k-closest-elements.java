class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> l = new ArrayList<>();

        if(x<arr[0])
        {
            for(int i=0;i<k;i++)
            {
                l.add(arr[i]);
            }
            return l;
        }
        if(x>arr[arr.length-1])
        {
            for(int i=arr.length-k;i<arr.length;i++)
            {
                l.add(arr[i]);
            }
            return l;
        }
        
        int i;

        for(i=0;i<arr.length;i++)
        {
            if(arr[i]>x)
            {
                break;
            }
        }
        int prev = i-1;
        int nxt = i;

        while(prev>=0 && nxt<arr.length && l.size()<k)
        {
            if((x - arr[prev])<=(arr[nxt] - x))
            {
                l.add(arr[prev]);
                prev--;
            }
            else
            {
                l.add(arr[nxt]);
                nxt++;
            }
        }

        while(l.size()<k && prev<0 && nxt<arr.length)
        {
            l.add(arr[nxt]);
            nxt++;
        }
        while(l.size()<k && nxt>=arr.length && prev>=0)
        {
            l.add(arr[prev]);
            prev--;
        }

        Collections.sort(l);
        return l;
    }
}