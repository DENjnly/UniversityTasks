//done
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i = 0; i<a;i++){
            ar.add((int)(Math.random()*50)+1);
        }
        System.out.println(ar.toString());
        ar.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int max= ar.get(0);

        for(int i = 1; i<= max;i++){
            if(!ar.contains(i)){
                System.out.print(i);
                return;
            }
        }
        System.out.println(max+1);
    }
}
