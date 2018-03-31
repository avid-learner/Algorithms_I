package Percolation;

public class UnionFind {
    
    private int[] map;
    private int[] size;
    
    public UnionFind(int n)   
    {
        map = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++)
        {
            map[i] = i;
            size[i] = 1;
        }
    }
    
    private int root(int x)
    {
        int i = x;
        while(i != map[i])       
        {
            i = map[i];
            map[i] = map[map[i]];
        }
        return i;
    }
    
    public void union(int x, int y)
    {
        int rootx = root(x);
        int rooty = root(y);
        if(size[rootx] > size[rooty]) {
            map[rooty] = rootx; 
        } else {
            map[rootx] = rooty;
        }
    }
    
    public boolean find(int x, int y)
    {
        int rootx = root(x);
        int rooty = root(y);
        return rootx == rooty;
    }
    
}
