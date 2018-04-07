import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int size;
    private final double mean, std, cl, ch;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        size = n;
        int numTrials = trials;
        double[] results = new double[trials];

        for (int i = 0; i < numTrials; i++)
        {
            Percolation p = new Percolation(size);
            while (!p.percolates() && p.numberOfOpenSites() < size * size)
            {
                p.open(getRandomPos(), getRandomPos());
            }
            double result = p.numberOfOpenSites()/((double) (size * size));
            results[i] = result;
        }

        mean = StdStats.mean(results);
        std = StdStats.stddev(results);
        double c = 1.96;
        cl = mean - c*std / Math.sqrt(numTrials);
        ch = mean + c*std / Math.sqrt(numTrials);
    }

    private int getRandomPos() {
        return StdRandom.uniform(1, size +1);
    }

    public double mean()                          // sample mean of percolation threshold
    {
        return mean;
    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return std;
    }
    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return cl;
    }
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return ch;
    }

    public static void main(String[] args)        // test client (described below)
    {
        PercolationStats perc = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.printf("mean                    = %f", perc.mean);
        System.out.println("");
        System.out.printf("stddev                  = %f", perc.std);
        System.out.println("");
        System.out.printf("95%% confidence interval = [%f, %f]", perc.cl, perc.ch);
    }
}