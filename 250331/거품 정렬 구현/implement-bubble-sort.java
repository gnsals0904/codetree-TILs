import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < n; i++){
                if(i+1 >= n) break;
                if(arr[i] > arr[i+1]){
                    flag = true;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(a).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}