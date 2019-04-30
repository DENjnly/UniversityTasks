//done
public class Main {
    public static int distance(String str, String str2){

        if(str.equals(str2)) return 0;
        if(str.equals("")  && !str2.equals("")){
            return str2.length();
        }
        if(!str.equals("") && str2.equals("")){
            return str.length();
        }
        if (str.substring(str.length()-1).equals(str2.substring(str2.length()-1))){
            return distance(str.substring(0,str.length()-1),str2.substring(0,str2.length()-1));
        }

        int a = distance(str.substring(0, str.length()-1), str2.substring(0,str2.length()-1))+1;
        int b = distance(str, str2.substring(0,str2.length()-1))+1;
        int c = distance(str.substring(0, str.length()-1), str2)+1;
        return Math.min(a,Math.min(b,c));
    }
    public static void main(String[] args) {
        System.out.println(distance("yabxe","aabxe"));
    }
}
