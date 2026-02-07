import java.util.*;

public class BabyEhab {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum =0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        if (sum %2 ==1){
            System.out.println(0);
            return;
        }

        while(true){
            boolean allEven = true;
            for (int i = 0; i < n; i++) {
                if (arr[i]%2==1){
                    allEven = false;
                    break;
                }
            }
            if (!allEven){
                break;
            }

            for (int i = 0; i < n; i++) {
                arr[i]/=2;
            }
            sum /= 2;
        }

        if (sum % 2 == 1){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i]%2==1){
                System.out.println(1);
                System.out.println(i+1);
                return;
            }
        }

    }
}
