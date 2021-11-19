import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class fib {
    public static void main(String[] args){
        double[] looptime = new double[51];
        long startTime = System.nanoTime();
        System.out.println("working! Going up to 50! Start time: " + startTime);
        //System.out.println("fibo(51): " + fibo(51));
        for(int i = 0; i < 51; i++){
            long startTimeloop = System.nanoTime();
            System.out.println("fibo(" + i + "): " + fibo(i));
            long endTimeloop = System.nanoTime();
            double durationloop = ((endTimeloop - startTimeloop) / 1000000);
            looptime[i] = durationloop;
            System.out.println("it took "+ durationloop + " milliseconds!");
        }
        long endTime = System.nanoTime();
        double duration = ((endTime - startTime) / 1000000000);
        System.out.println("it took "+ duration+ " seconds!");
        try{
            PrintWriter pr = new PrintWriter(new File("blah.txt"));
            for(int i = 0; i < looptime.length; i++){
                pr.println(looptime[i]);
            }
            pr.close();
            
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static long fibo(int n){
        if (n <= 1)
            return 1;
        return fibo(n-1) + fibo(n-2);
    }

}

