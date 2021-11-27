import java.util.ArrayList;

public class LinkedList {
    public static ArrayList<Integer> savedChunks = new ArrayList<>();
    public static ArrayList<BinList> binNodes  = new ArrayList<>();
    public Node head = new Node();
    private static int sizeOfMainLinkedList = 0 ;
    public static Node currentAddress;
    public static Node lastAddress;
    public static Node nextAddress;

    public static int getSizeOfMainLinkedList() {
        return sizeOfMainLinkedList;
    }

    public static void setSizeOfMainLinkedList(int sizeOfMainLinkedList) {
        LinkedList.sizeOfMainLinkedList = sizeOfMainLinkedList;
    }

    LinkedList(int size){
        head.data = size;
        head.next= null;
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    public void malloc(int data){
        Node newNode = new Node(data);
        Node q = new Node();
        if (head.next == null){
            head.next = newNode;
            head.data = head.data - data;
            setSizeOfMainLinkedList(getSizeOfMainLinkedList()+1);
        }
        else{

        }

    }



    public void traverse(){
        Node p;
        if (head == null)
            System.out.println("list is empty!!");
        else {
            p = head;
            while (p != null) {
                System.out.println(p.data);
                p = p.next;
            }
        }
    }

    public boolean search(Node head, int x) {
        Node current = head;    //Initialize current
        while (current != null)
        {
            if (current.data == x)
                return true;    //data found
            current = current.next;
        }
        return false;    //data not found
    }

    public void deleteNode(int data){
        Node q = new Node();
        if (head.next == null){
            System.out.println("List is empty!");
        } else {
            q = head;
            while (q.next!=null && q.next.data!=data){
                q = q.next ;
            }
            if (q.next==null) {
                System.out.println("Item not found!");
            }else {
                currentAddress = q.next;
                lastAddress = q ;
                nextAddress = q.next.next ;
                q.next = q.next.next ;
                setSizeOfMainLinkedList(getSizeOfMainLinkedList()-1);            }
        }
    }

    public void free(int data){
        int count=0 ;
        if (search(head , data)){
            System.out.println("Node found!");
            deleteNode(data);
            head.data = head.data + data;
            for (int i = 0; i < savedChunks.size(); i++) {
                if (savedChunks.get(i)==data){
                    count++;
                }
            }
            if (count==0){
                savedChunks.add(data);
                BinNode binHead = new BinNode(data);
                BinList binList = new BinList(binHead);
                binList.push(nextAddress,lastAddress,currentAddress);
                for (int i = 0; i < binNodes.size(); i++) {
                    if (binNodes.get(i).head.data==data){
                        System.out.println(binNodes.get(i));
                    }
                }
            }
            else {
                for (int i = 0; i < binNodes.size(); i++) {
                    if (binNodes.get(i).head.data == data){
                        System.out.println(head.data);
                    }
                }
            }
        }else {
            System.out.println("Not such a Node found!");
        }
    }

//    public void test(){
//        int j = 0 ;
//        for (int i = 0; i < 32; i++) {
//            j += 8 ;
//            BinList binNode = new BinList();
//            binNode.head.data = j; ;
//            binNodes.add(binNode);
//        }
//    }

    public void print(){
        for (int i = 0; i < binNodes.size(); i++) {
            System.out.println(binNodes.get(i).head.data);
        }

    }



}
