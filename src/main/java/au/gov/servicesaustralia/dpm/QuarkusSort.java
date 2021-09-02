package au.gov.servicesaustralia.dpm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Path("/test")
public class QuarkusSort {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        ArrayList<Integer> randomArray = new ArrayList<Integer>();
        Random random = new Random();
        for (int i =0; i < 2000; i++){
            randomArray.add(random.nextInt(100000));
        }

        System.out.println("\nInitial array : " + randomArray.toString());
        System.out.println("\nInitial size : "+ randomArray.size());
        int[] sortedArray = this.bubbleSort(randomArray.stream().mapToInt(Integer::intValue).toArray());
        System.out.println("\nFinal array : "
                + Arrays.toString(sortedArray));
        System.out.println("\nFinal array : " + sortedArray.length);
        return "Hello RESTEasy";
    }

    public int[] bubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}