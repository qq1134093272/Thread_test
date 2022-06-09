import java.util.Arrays;
import java.util.Scanner;

public class Sloution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;

        int n1 = Integer.valueOf(sc.next());//主

        int n2 = Integer.valueOf(sc.next());//谓

        int n3 = Integer.valueOf(sc.next());//宾

        String[] n1s = new String[n1];
        String[] n2s = new String[n2];
        String[] n3s = new String[n3];


        s = sc.nextLine();
        s = sc.nextLine();

        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            n1s[i] = ss[i];
        }


        s = sc.nextLine();
        ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            n2s[i] = ss[i];
        }


        s = sc.nextLine();
        ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            n3s[i] = ss[i];
        }

        int m = 0;

        m = Integer.valueOf(sc.nextLine());//m行


        String[] ms = new String[m];
        for (int i = 0; i < m; i++) {

            ms[i] = sc.nextLine();

        }

        for (int i = 0; i < m; i++) {
            System.out.println(ms[i]);
            solve(ms[i], n1s, n2s, n3s);
        }


    }

    private static void solve(String arr, String[] n1s, String[] n2s, String[] n3s) {

        int[] cs = new int[n3s.length];
        Arrays.fill(cs, 0);
        String[] ss = arr.split(" ");
        if (ss.length < 2) {
            System.out.println("NO");
            return;
        } else if (ss.length == 2) {
            if (Arrays.binarySearch(n1s, ss[0]) >= 0 && Arrays.binarySearch(n1s, ss[0]) < n1s.length) {
                if (Arrays.binarySearch(n2s, ss[1]) >= 0 && Arrays.binarySearch(n2s, ss[1]) < n2s.length) {

                    System.out.println("YES");
                    return;
                } else {
                    System.out.println("NO");
                    return;
                }
            } else {
                System.out.println("NO");
                return;
            }

        }
        else {
            if (Arrays.binarySearch(n1s, ss[0]) >= 0 && Arrays.binarySearch(n1s, ss[0]) < n1s.length) {

                if (Arrays.binarySearch(n2s, ss[1]) >= 0 && Arrays.binarySearch(n2s, ss[1]) < n2s.length) {

                } else {
                    System.out.println("NO");
                    return;
                }
            } else {
                System.out.println("NO");
                return;
            }
            for (int i = 2; i < ss.length; i++) {
                if (Arrays.binarySearch(n1s, ss[i]) >= 0 && Arrays.binarySearch(n1s, ss[i]) < n1s.length) {
                    System.out.println("NO");
                    return;
                } else if (Arrays.binarySearch(n2s, ss[i]) >= 0 && Arrays.binarySearch(n2s, ss[i]) < n2s.length) {
                    System.out.println("NO");
                    return;
                } else if (Arrays.binarySearch(n3s, ss[i]) >= 0 && Arrays.binarySearch(n3s, ss[i]) < n3s.length) {

                    if (cs[Arrays.binarySearch(n3s, ss[i])] != 0) {
                        System.out.println("NO");
                        return;
                    } else {
                        cs[Arrays.binarySearch(n3s, ss[i])] = 1;

                    }

                } else {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");

        }


    }
}
