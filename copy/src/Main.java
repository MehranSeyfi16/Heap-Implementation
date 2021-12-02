import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=readInt();
        int numberofcommands=readInt();
        String commands;
        LinkedList linkedList=new LinkedList(1000);
            for (int i=1;i<=numberofcommands;i++){
                String[]strings;
                commands=scanner.nextLine();
                strings  =commands.trim().split("[ ]+");
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
                    numberofcommands++;
                }

            }
        }
        public static int readInt(){
        int input=0;

        while (true){
            Scanner scanner=new Scanner(System.in);
            try {
                input= scanner.nextInt();
                if(input<=0){
                    System.out.println("please enter + number ");
                    while (true){
                        input=scanner.nextInt();
                        if (input>0){
                            break;
                        }
                        else
                            System.out.println("please enter + number ");
                    }

                }                break;
            }
            catch (Exception e){
                System.out.println("not an appropriate input");
            }
        }
        return input;
    }

//        linkedList.traverse();
    }


