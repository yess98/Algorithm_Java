import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
        public static int count  = 0 ; 
    public static Set < Integer>hs = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int arr[] = new int[numbers.length()];
       int  arr_length = arr.length;
        for(int i = 0 ; i < numbers.length(); i ++){
            arr[i] =Integer.parseInt(numbers.substring(i,i+1));
        }
        for(int i = 1; i <= arr_length ; i ++) {
        perm(arr,0,arr_length,i);
        }
        answer = hs.size();
        return answer;
    }

    public static void perm (int[] arr, int depth, int n, int k ) {
        if(depth == k) {
            print(arr,k);
            return;
        }
        for(int i = depth ; i < n; i ++) {
            swap(arr, i,depth);
            perm(arr, depth + 1, n , k);
            swap(arr,i,depth);
        }
    }

    public static void print(int[]arr, int k ) {
        String answer = "";
        for(int i = 0 ; i < k ; i ++) {
            answer += String.valueOf(arr[i]);
        }

        isprimeNUM(answer);




    }

    public static void isprimeNUM(String s ) {
        int number = Integer.parseInt(s);
            if(number == 0  || number == 1) {
                return ;
            }

            for(int i = 2; i <=  number/2 ; i ++) {
                if(number % i == 0) {

                    return;
                }
            }

            hs.add(number);


    }
    public static void swap(int[]arr , int i , int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
