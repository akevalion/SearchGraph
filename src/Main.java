import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(input());
        //Scanner scan = new Scanner(System.in);
        while (true){
            int n = scan.nextInt();
            if(n == 0) return;
            String origin = scan.next();
            String dest = scan.next();
            Graph g = new Graph();
            while (n--> 0){
                String i1 = scan.next();
                String i2 = scan.next();
                String word = scan.next();
                g.addLink(i1, i2, word);
            }
            System.out.println(g.shortestPath(origin, dest));
        }
    }


    public static String input(){
        return 
            "4\n"+
            "portugues frances\n"+
            "ingles espanhol red\n"+
            "espanhol portugues amigo\n"+
            "frances ingles date\n"+
            "espanhol ingles actual\n"+
            "4\n"+
            "portugues alemao\n"+
            "ingles espanhol red\n"+
            "espanhol portugues amigo\n"+
            "frances ingles date\n"+
            "espanhol ingles actual\n"+
            "6\n"+
            "portugues frances\n"+
            "ingles espanhol red\n"+
            "espanhol portugues amigo\n"+
            "frances ingles date\n"+
            "frances espanhol la\n"+
            "portugues ingles a\n"+
            "espanhol ingles actual\n"+
            "0\n";
    }
}