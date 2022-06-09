import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        if(s.length()==0){
            System.out.println(0);
        }
        char[] arr=s.toCharArray();

        int max_point=solve(arr);

    }

    private static int solve(char[] arr) {
        int index=0;int maxValue=Integer.MIN_VALUE;
        int p=0;int q=1;

        for(p=0;p<arr.length;p++){
            while(q< arr.length){
                if(Integer.valueOf(arr[p]).intValue()==Integer.valueOf(arr[q]).intValue()||
                        Integer.valueOf(arr[q]).intValue()==Integer.valueOf(arr[p]).intValue()+1){
                    q++;p++;
                    index+=Integer.valueOf(arr[p]).intValue()+Integer.valueOf(arr[q]).intValue()-192;
                    continue;
                }
                else{
                    p=q;q++;
                }
            }
        }
        return index;
    }
}
