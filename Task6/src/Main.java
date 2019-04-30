import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество камней:");
        Scanner sc = new Scanner(System.in);
        int [] mas = new int [sc.nextInt()];
        int sum2 = 0;
        int sum1 = 0;
        for(int i = 0;i<mas.length;i++){
            mas[i] = ((int)(Math.random()*50)+1);
            sum2+=mas[i];
        }
        System.out.println("Суммарная масса всех камней: "+sum2);
        System.out.println("Камни имеют такую массу:");

        show(mas);
        for(int i = 0; i <mas.length;i++){
            sum2-=mas[i];
            sum1+=mas[i];
            if(sum2==0){
                System.out.println("Нельзя разграничить :(");
                return;
            }
            if(((int)(Math.max(sum1,sum2)/Math.min(sum1,sum2)))<2){
                System.out.println("Индекс \"Граничного\" камня(начиная с единицы):");
                System.out.println(i+1);
                break;
            }
        }
        System.out.println("Масса слева:");
        System.out.println(sum1);
        System.out.println("Масса справа:");
        System.out.println(sum2);


    }
    public static void show(int [] mas){
        for(int i = 0; i<mas.length;i++){
            System.out.print(mas[i]+" ");
        }
        System.out.println();
    }
}
