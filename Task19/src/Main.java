//done
public class Main {
    private static String k;
    public static void main(String[] args) {
        long col = 0;
        for(long i = 100;i<1000000;i++){
            if(isSum(i)){
                col++;
            }
        }
        System.out.println(++col);


    }
    public static boolean isSum(long num){
        k=num+"";
        char [] mas = k.toCharArray();
        int [] masUp = new int [mas.length];
        for(int i = 0;i<mas.length;i++){
            masUp[i] = Integer.parseInt(mas[i]+"");
        }

        if(mas.length==4){
            if((masUp[0])==(masUp[1]+masUp[2]+masUp[3])) return true;

        }
        if(mas.length==5){
            if((masUp[0]+masUp[1])==(masUp[2]+masUp[3]+masUp[4])) return true;
        }
        if(mas.length==6) {
            if ((masUp[0] + masUp[1] + masUp[2]) == (masUp[3] + masUp[4] + masUp[5])) return true;
        }
        return false;
    }
}
