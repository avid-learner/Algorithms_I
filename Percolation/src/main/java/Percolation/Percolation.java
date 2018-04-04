package Percolation;

public class Percolation {

   private int[][] matrix;
   private int N;
   private int nOpen = 0;
   private UnionFind uf;
   private int startCell, finishCell;

   public Percolation(int n)            // create n-by-n grid, with all sites blocked
   {
       if (n<=0) throw new java.lang.IllegalArgumentException();
       matrix = new int[n][n];
       N = n;
       for(int i = 0; i < n; i++)
           for(int j = 0; j < n; j++)  {
               matrix[i][j] = 1;
           }
       uf = new UnionFind(n*n+2);
       startCell = n*n;
       finishCell = n*n+1;
       for(int i = 0; i < n; i++) 
       {
            uf.union(indexOf(0,i), startCell);
            uf.union(indexOf(n-1,i), finishCell);
       }
       
   }
   
   private int indexOf(int row, int col) 
   {
       return (row)*N+ (col);
   }
   
   private boolean isInRange(int row, int col)
   {
       return (row > 0)&&(row <= N)&&(col > 0)&&(col <=N);
   }
   
   private void tryUnion(int row, int col, int row1, int col1) {
        if (isInRange(row, col) && isOpen(row, col)) {
            uf.union(indexOf(row-1, col-1), indexOf(row1-1, col1-1));
        }
   }
   
   public void open(int row, int col)    // open site (row, col) if it is not open already
   {
       if (!isInRange(row, col)) throw new java.lang.IllegalArgumentException();
       if (isFull(row, col)) {
           matrix[row-1][col-1] = 0;
           tryUnion(row-1,  col, row, col);
           tryUnion(row+1,  col, row, col);
           tryUnion(row,  col-1, row, col);
           tryUnion(row,  col+1, row, col);
           nOpen++;
       }
   }
   
   public boolean isOpen(int row, int col)   // is site (row, col) open?
   {
       if (!isInRange(row, col)) throw new java.lang.IllegalArgumentException();
       return matrix[row-1][col-1] == 0;
   }
   
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
       if (!isInRange(row, col)) throw new java.lang.IllegalArgumentException();
       return matrix[row-1][col-1] == 1;
   }
   
   public     int numberOfOpenSites()       // number of open sites
   {
       return nOpen;
   }
   
   public boolean percolates()              // does the system percolate?
   {
       return uf.find(startCell, finishCell);
   }

}
