import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static int sum2 =0, sum = 0;
    public static ArrayList<Integer> ar2;
    public static ArrayList<Boolean> mainArray = new ArrayList<>();
    public static int S;

    public static void main(String[] args) {
        //Алгоритм состоит в том, чтоб перебрать все возможные варианты покупателя
        // выдать необходимую суму(или больше необходимой). И проверить можно ли с помощью
        // суммы этих купюр (функция  countSum(ArrayList <Integer> arrayList))
        // дать точную сдачу (функция isRestExact(int sumRest))
        // Перебираем значения рекурсивной функцией(reccursion()) (Каждый раз передаем в эту же функцию
        // последовательность купюр с обрезанным первым символом а потом передаем с необрезанным)
        // Таким образом перебираються все возможные комбинации купюр (отсеиваем те последовательности, сумма
        // купюр которых меньше стоимости товаров)
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ar1 = new ArrayList<>();
        ar2 = new ArrayList<>();
        System.out.print("Введите кол-во купюр покупателя: ");
        int a = sc.nextInt();
        System.out.print("Введите кол-во купюр продавца: ");
        int b = sc.nextInt();
        System.out.print("Введите стоимость товара: ");
        S = sc.nextInt();

        for(int i = 0; i<a;i++){
           ar1.add((int)((Math.random()*50)+1));
        }
        for(int i = 0; i<b;i++){
            ar2.add((int)(Math.random()*50));
            sum2+=ar2.get(i);
        }
        System.out.println("Купюры покупателя\n"+ar1.toString());
        System.out.println("Купюры продавца\n"+ar2.toString());
        ar2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1.compareTo(o2));
            }
        });
        System.out.println("Все возможные варианты покупателя выдать необходимую суму(или больше необходимой)");
        reccursion(ar1,0);
        if(mainArray.contains(true)) System.out.println("\n"+"Точную сдачу получить возможно");
        else System.out.println("\n"+"Точную сдачу получить невозможно");

    }
    public static void reccursion(ArrayList<Integer> arrayList, int currentNum){
        if(currentNum > arrayList.size()-1 && countSum(arrayList)>=S){
            mainArray.add(isRestExact(countSum(arrayList)-S));
            System.out.print(arrayList.toString()+"   ");
            return;
        }
        if(currentNum > arrayList.size()-1){
            return;
        }
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.addAll(arrayList);
        temp1.remove(currentNum);
        reccursion(arrayList,currentNum+1);
        reccursion(temp1,currentNum);
    }
    public static boolean isRestExact(int sumRest){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(ar2);
        int sumTemp = sum2;
        for(int i = 0; i< temp.size();i++){
            if(sumTemp-temp.get(i)>=sumRest){
                sumTemp= sumTemp-temp.get(i);
                temp.remove(i);
                i--;
                continue;
            }
        }
        if(sumTemp!=sumRest){
            return false;
        }
        else {
            System.out.print("Подходящяя последовательность(сумма сдачи "+sumRest+"):");
            return true;
        }
    }
    public static int countSum(ArrayList <Integer> arrayList){
        int tempSum = 0;
        for(int num: arrayList){
            tempSum+=num;
        }
        return tempSum;
    }
}
