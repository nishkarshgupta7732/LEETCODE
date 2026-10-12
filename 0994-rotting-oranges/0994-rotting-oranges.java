class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i, j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        if(fresh==0)
        {
            return 0;
        }

        int min = 0;
        int[][] dx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty())
        {
            int size = q.size();
            boolean rotten = false;

            for(int i=0;i<size;i++)
            {
                int[] curr = q.remove();

                for(int[] dir : dx)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1)
                    {
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r,c});
                        rotten = true;
                    }
                }
            }
            if(rotten)
            {
                min++;
            }
        }
        if(fresh==0)
        {
            return min;
        }

        return -1;
    }
}