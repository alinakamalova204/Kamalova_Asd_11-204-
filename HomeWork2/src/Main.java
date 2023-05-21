import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //алгоритм быстрого поиска
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) { //массив [0,1,2,3,4,5,6,7,8,9]
            arr[i] = i;
        }
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[p] != arr[q]){
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == arr[p]){
                        arr[j] = arr[q];
                    }
                }
            }
        }
    }
}