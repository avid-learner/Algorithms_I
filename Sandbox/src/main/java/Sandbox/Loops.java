package Sandbox;

public class Loops {
    public int foreach()
    {
        int[] numbers = {10,20,30,40,50};
        int sum = 0;
        for(int x: numbers) {
            sum += x;
        }
        return sum;
    }
}
