import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        int size = readInt();
        int numberOfCommands = readInt();

        LinkedList linkedList=new LinkedList(size);

        for (int i=1 ; i <= numberOfCommands ; i++){
            String[]strings;

            String commands=scanner.nextLine();
            strings = commands.trim().split("[ ]+");

            if(strings[0].equals("malloc")){
                linkedList.malloc(Integer.parseInt(strings[1]));
                linkedList.traverse();
            }
            else if(strings[0].equals("free")){
                linkedList.free(Integer.parseInt(strings[1]));
                linkedList.traverse();
                linkedList.print();
            }
            else {
                System.out.println("invalid input!");
                numberOfCommands++;
            }
        }
    }

    public static int readInt(){
        int input;

        while (true){
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextInt();
                if (input<=0){
                    System.out.println("please enter a + number");
                    while (true){
                        input = scanner.nextInt();
                        if (input>0){
                            System.out.println("Well! Finally the correct form!");
                            break;
                        }else {
                            System.out.println("please enter a + number");
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Not an appropriate input");
            }
        }
        return input;
    }
}