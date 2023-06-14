package HomeWork.HomeWork1;

import java.util.Random;
import java.util.Arrays;
import java.util.Date;

public class HomeWork1 {
    // Дано целое число N из отрезка [1; 1000]. Также даны N целых чисел Ai из отрезка [1; 1000000]. 
    // Требуется для каждого числа Ai вывести количество различных делителей этого числа. 
    // В этой задаче несколько верных решений, попробуйте найти наиболее оптимальное. Для полученного решения укажите сложность в О-нотации.


    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(1, 5);
        int[] array = new int[n + 1];
        result(array);    
    }

    public static void result(int[] array){
        
        Date start = new Date();

        Random rand = new Random();

        for (int i = 1; i < array.length; i++)
        {
            array[i] = rand.nextInt(1, 1000001);
            for (int j = 1; j <= array[i]; j++){
                if(array[i] % j == 0){
                    System.out.printf("%d%n ", j);
                }
            }
        }

        Date stop = new Date();

        long time = stop.getTime() - start.getTime();
        System.out.println();
        System.out.printf("Time: %d%n", time);
        System.out.print(Arrays.toString(array));
    }
}


