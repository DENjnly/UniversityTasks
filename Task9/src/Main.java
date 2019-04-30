import java.util.Scanner;
//done
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] mas = new int [sc.nextInt()];
        int temp = 0;
        for(int i = 0; i< mas.length;i++){
            mas[i]=i+1;
        }
        //Путём подстановок и тестов был выведен алгоритм перестановок
        //Состоит он в том чтобы менять местами елементы по такому принципу
        // На первой итерации меняем местами два соседних елемента, на второй меняем через один(0-ой,например, со вторым)(mas[j] меняем с mas[j+2])
        //На третей итерации меняем местами уже mas[j] и mas[j+4]
        // (т.е. на каждой итерации при инкрементировании i на 1 формула mas[j+(int)(Math.pow(2,i)/2)]
        //Количество итераций находим так(функция getPow()): Длина массива находиться между двумя степенями двойки(например для длины 5, она
        // находиться между 2^2 и 2^3, функция вернет степень двойки сверху(в данном случае 3 ))
        //
//        for(int i =0;i< mas.length;i+=2){
//            if(i==mas.length-1|| i > mas.length-2){
//                break;
//            }
//            temp = mas[i];
//            mas[i] =mas[i+1];
//            mas[i+1] = temp;
//        }
        show(mas);
        int p = getPow(mas.length);
        int col = sc.nextInt();
        for(int k = 0; k<col;k++) {
            for (int i = 0; i <= p; i++) {
                for (int j = 0; j < mas.length; j += (int) Math.pow(2, i)) {
                    if (j == mas.length - 1 || j > mas.length - 1 - ((int) (Math.pow(2, i) / 2))) {
                        break;
                    }
                    temp = mas[j];
                    mas[j] = mas[j + (int) (Math.pow(2, i) / 2)];
                    mas[j + (int) (Math.pow(2, i) / 2)] = temp;
                }
            }
        }
        show(mas);
    }
    public static void show(int []mas){
        for(int i =0; i< mas.length;i++){
            System.out.print(mas[i]+" ");
        }
        System.out.println();
    }
    public static int getPow(int length){
        int i;
        for(i = 0; !((length>=Math.pow(2,i)) && (length<=Math.pow(2,i+1)));i++){ }
        return i+1;
    }
}
