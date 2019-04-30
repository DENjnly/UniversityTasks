import java.util.Scanner;

//done
public class Task20 {
    private static int col=0;
    public static void go(int length, int currentPlace, int step){
        if(length<currentPlace){
            return;
        }
        if(length==currentPlace){
            col++;
            return;
        }
        if(length>currentPlace){
            for(int i = 1; i <= step;i++){
                go(length, currentPlace+i,step);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину");
        int length = sc.nextInt();
        System.out.println("Введите длину, дальше которой фишка ходить не может");
        int step = sc.nextInt();
        go(length,0,step);
        System.out.println("Ответ:\n"+col);
    }
}
