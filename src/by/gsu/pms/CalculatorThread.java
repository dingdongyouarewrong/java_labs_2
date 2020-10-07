package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculatorThread {


    public List<Integer> startInRange(int threadsCount, int upperBorder) {

        List<Integer> result = new ArrayList<>();
        if (upperBorder % threadsCount == 0 && upperBorder > threadsCount) {
            int threadCapacity = upperBorder / threadsCount;
            for (int i = 0; i < threadsCount; i++) {

                int minValue = i * threadCapacity + 1;
                int maxValue = i * threadCapacity + threadCapacity;

                ExecutorService threadPool = Executors.newFixedThreadPool(threadsCount);


                threadPool.submit(() -> result.add(getPrimeNumbers(minValue, maxValue)));

            }
            while (result.size()<threadsCount) {}
        } else {
            System.out.println("Error maxValue must be greater than countOfThreads!");
        }
        return result;
    }


    public int getPrimeNumbers(int minValue, int maxValue) {
        int num = 0;
        int primeNumbersSum = 0;
        for (int i = minValue; i <= maxValue; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbersSum+=i;
            }
        }
        return primeNumbersSum;
    }
}
