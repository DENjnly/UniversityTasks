//done
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private HashMap <String, String> hash = new HashMap<>();
    Main(){
        hash.put("1", "a");
        hash.put("2", "б");
        hash.put("11", "й");
        hash.put("12", "к");
        hash.put("21", "у");
        hash.put("22", "ф");
    }
    public void recursion(String decoded, String encoded){
        if(encoded.length() == 0){
            System.out.println(decoded);
            return;
        }
        if(hash.containsKey(encoded.substring(0, 1))){
            recursion(decoded+hash.get(encoded.substring(0, 1)), encoded.substring(1));
            if(encoded.length() >= 2 && hash.containsKey(encoded.substring(0, 2))) {
                recursion(decoded+hash.get(encoded.substring(0, 2)), encoded.substring(2));
            }
        } else {
            recursion(decoded+encoded.substring(0, 1), encoded.substring(1));

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String encoded = "211221-21221";
        new Main().recursion("", encoded);
    }
    //Очевидно, ответ "баку-уфа"
}
