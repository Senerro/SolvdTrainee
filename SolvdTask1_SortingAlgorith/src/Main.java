import SortingClass.Sorting;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

System.out.println("Something");
        int[] array = {1,2,3,4,5};


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(array[0]);
        arrayList.add(array[1]);

//        ArrayList<Character> charList = new ArrayList<Character>();
//        charList.add(array2.charAt(0));
//        charList.add(array2.charAt(1));









        Sorting obj = new Sorting(arrayList);

        var a = obj.SomeMethood();

    }
}