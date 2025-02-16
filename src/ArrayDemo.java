import javafx.print.Collation;

import java.util.Arrays;
import java.util.Collections;

public class ArrayDemo {

    public static void main(String[] args) {
        /*array - n element 10
        revrse first k lement*/
        //array -54321,
        int array[]={25,62,48,68,12,26,74,96,15};
        int reverseUpto=3;
        for(int i=reverseUpto-1;i>=0;i--)
        {
            System.out.print(array[i]+" ");
        }
        for(int i=reverseUpto;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }

       // Arrays.stream(array).


    }
}
