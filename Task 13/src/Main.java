


import java.net.*;
        import java.io.*;
        import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
    public static int col=0;
    public static int neededX,neededY;
    public static String all="";
    public static ArrayList<String> ways = new ArrayList<>();
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("A",0);
        hash.put("B",1);
        hash.put("C",2);
        hash.put("D",3);
        hash.put("E",4);
        hash.put("F",5);
        hash.put("G",6);
        hash.put("H",7);
        HashMap<Integer, String> hashUp = new HashMap<>();
        hashUp.put(0,"A");
        hashUp.put(1,"B");
        hashUp.put(2,"C");
        hashUp.put(3,"D");
        hashUp.put(4,"E");
        hashUp.put(5,"F");
        hashUp.put(6,"G");
        hashUp.put(7,"H");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координаты точки, в которую необходимо попасть(буква и цифра(0-7) через пробел):");
        neededX  = hash.get(sc.next());
        neededY = sc.nextInt();
        System.out.println("Введите координаты точки, в которой находиться конь(буква и цифра(0-7) через пробел):");
        int a = hash.get(sc.next());
        int b =sc.nextInt();
        System.out.println("Минимальное количество ходов:");
        System.out.println(distance(a,b,""));
        ways.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }
                if(o1.length()<o2.length()){
                    return -1;
                }
                else return 0;
            }
        });
        String temp = ways.get(0);
        String tempUp ="";
        Pattern pattern = Pattern.compile("(?<=<)\\d");
        Matcher m = pattern.matcher(temp);
        while(m.find()){
            tempUp=m.group();
            temp =temp.replace("<"+tempUp,"<"+hashUp.get(Integer.parseInt(tempUp)));

        }
        System.out.println("Минимальный путь");
        System.out.println(temp);

    }
    public static int distance(int i, int j, String way){
        int a=0, b=0, c=0, d=0 ,e=0 ,f=0 ,g=0,h=0;
        if(i==neededX&&j==neededY){
            ways.add(way+"<"+i+" "+j+">");
            return 0;
        }
        if(way.toCharArray().length>25){
            return 0;
        }
        if(j-2>=0&&i-1>=0 && !way.contains("<"+(i-1)+" "+(j-2)+">")){
            a = distance(i-1,j-2,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i-1)+" "+(j-2)+">";
        }
        else a = 25000;
        if(j-1>=0&&i-2>=0 && !way.contains("<"+(i-2)+" "+(j-1)+">")){
            b = distance(i-2,j-1,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i-2)+" "+(j-1)+">";
        }
        else b = 25000;
        if(j-1>=0&&i+2<8 && !way.contains("<"+(i+2)+" "+(j-1)+">")){
            c = distance(i+2,j-1,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i+2)+" "+(j-1)+">";
        }
        else c = 25000;
        if(j-2>=0&&i+1<8 && !way.contains("<"+(i+1)+" "+(j-2)+">")){
            d = distance(i+1,j-2,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i+1)+" "+(j-2)+">";
        }
        else d = 25000;
        if(j+2<8&&i-1>=0 && !way.contains("<"+(i-1)+" "+(j+2)+">")){
            e = distance(i-1,j+2,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i-1)+" "+(j+2)+">";
        }
        else e = 25000;
        if(j+1<8&&i-2>=0 && !way.contains("<"+(i-2)+" "+(j+1)+">")){
            f = distance(i-2,j+1,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i-2)+" "+(j+1)+">";
        }
        else f = 25000;
        if (j+1<8&&i+2<8 && !way.contains("<"+(i+2)+" "+(j+1)+">")){
            g = distance(i+2,j+1,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i+2)+" "+(j+1)+">";
        }
        else g = 25000;
        if(j+2<8 && i+1<8 && !way.contains("<"+(i+1)+" "+(j+2)+">")){
            h = distance(i+1,j+2,(way+"<"+i+" "+j+">"))+1;
            all+="<"+(i+1)+" "+(j+2)+">";
        }
        else h = 25000;
        return Math.min(Math.min(Math.min(a,b),Math.min(c,d)),Math.min(Math.min(e,f),Math.min(g,h)));
    }

}