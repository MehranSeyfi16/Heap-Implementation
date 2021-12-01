import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int numberogcommands= scanner.nextInt();
        LinkedList linkedList=new LinkedList(size);
        String commands=scanner.nextLine();
        for (int i=1;i<=numberogcommands;i++){
            String[]strings;
             commands=scanner.nextLine();
            strings  =commands.trim().split("[ ]+");
            if(strings[0].equals("malloc")){
                linkedList.malloc(Integer.parseInt(strings[1]));
                linkedList.traverse();

            }
            else if(strings[0].equals("free")){
                linkedList.free(Integer.parseInt(strings[1]));
//                linkedList.print();

            }
            else
                System.out.println("invalid input!");

        }
//        linkedList.traverse();
    }
}