import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[][] matrix;
    private final int size;
    private int nOpen = 0;
    private final WeightedQuickUnionUF uf;
    private final int startCell, finishCell;

    public Percolation(int n)            // create n-by-n grid, with all sites blocked
    {
        if (n <= 0) throw new java.lang.IllegalArgumentException();
        matrix = new int[n][n];
        size = n;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1;
            }
        uf = new WeightedQuickUnionUF(n * n + 2);
        startCell = n * n;
        finishCell = n * n + 1;
        for (int i = 0; i < n; i++) {
            uf.union(indexOf(0, i), startCell);
            uf.union(indexOf(n - 1, i), finishCell);
        }

    }

    private int indexOf(int row, int col) {
        return (row) * size + (col);
    }

    private boolean isInRange(int row, int col) {
        return (row > 0) && (row <= size) && (col > 0) && (col <= size);
    }

    private void tryUnion(int row, int col, int row1, int col1) {
        if (isInRange(row, col) && isOpen(row, col)) {
            uf.union(indexOf(row - 1, col - 1), indexOf(row1 - 1, col1 - 1));
        }
    }

    public void open(int row, int col)    // open site (row, col) if it is not open already
    {
        if (!isInRange(row, col)) throw new java.lang.IllegalArgumentException();
        if (!isOpen(row, col)) {
            matrix[row - 1][col - 1] = 0;
            tryUnion(row - 1, col, row, col);
            tryUnion(row + 1, col, row, col);
            tryUnion(row, col - 1, row, col);
            tryUnion(row, col + 1, row, col);
            nOpen++;
        }
    }

    public boolean isOpen(int row, int col)   // is site (row, col) open?
    {
        if (!isInRange(row, col)) throw new java.lang.IllegalArgumentException();
        return matrix[row - 1][col - 1] == 0;
    }

    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        if (!isInRange(row, col)) throw new java.lang.IllegalArgumentException();
        return isOpen(row, col) && uf.connected(startCell, indexOf(row-1, col-1));
    }

    public int numberOfOpenSites()       // number of open sites
    {
        return nOpen;
    }

    public boolean percolates()              // does the system percolate?
    {
        return uf.connected(startCell, finishCell);
    }
}