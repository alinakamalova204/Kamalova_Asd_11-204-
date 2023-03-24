import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // {3,1} {1,2} {2,4} {5,4} {5,6} {6,7} {8,7} {9,8} {0,9} {9,7}
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (arr[p] != arr[q]){
                if (p < q) {
                    arr[q] = arr[p];
                }
                else {
                    arr[p] = arr[q];
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(Arrays.toString(arr));
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[a] == arr[b]){
                flag = true;
            }
            else {
                flag = false;
            }
        }
        if (flag == false){
            System.out.println("Не надо");
        }else {
            System.out.println("Надо");
        }
    }
}