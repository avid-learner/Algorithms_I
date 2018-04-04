package Percolation;
import java.util.concurrent.ThreadLocalRandom;

public class PercolationStats {
   private int numTrials;
   private int N;
   public double mean, std, cl, ch;
    
   private int getRandomPos() {
       //return (int)(Math.random() * N + 1);
       return ThreadLocalRandom.current().nextInt(1, N+1);
   }
    
   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
       N = n;
       numTrials = trials;
       double[] results = new double[trials];
       
        for(int i = 0; i < numTrials ; i++)
        {
            Percolation p = new Percolation(N);
            while (!p.percolates() && p.numberOfOpenSites() < N*N)
            {
                p.open(getRandomPos(), getRandomPos());
            }
            #System.out.println(p.numberOfOpenSites());
            double result = p.numberOfOpenSites()/((double)(N*N));
            mean += result;
            results[i] = result;
        }
        
      mean = mean / numTrials;  
      for(int i = 0; i < numTrials; i++)
      {
          std += (results[i] - mean)*(results[i] - mean);
      }
      std = std / (numTrials - 1);
      std = Math.sqrt(std);
      cl = mean - 1.96*std / Math.sqrt(numTrials);
      ch = mean + 1.96*std / Math.sqrt(numTrials);
   }
   
   public double mean()                          // sample mean of percolation threshold
   { return mean;}
   
   public double stddev()                        // sample standard deviation of percolation threshold
   {return std;}
   public double confidenceLo()                  // low  endpoint of 95% confidence interval
   {return cl;}
   public double confidenceHi()                  // high endpoint of 95% confidence interval
   {return ch;}

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