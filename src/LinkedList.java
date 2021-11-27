import java.util.ArrayList;

public class LinkedList {
    public static ArrayList<Integer> savedChunks = new ArrayList<>();
    public static ArrayList<BinNode> binNodes  = new ArrayList<>();

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
        head.data=size;
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
            head.data-=data;
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
                currentAddress = q;
                lastAddress = q.next ;
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
            head.data+=data;
            for (int i = 0; i < savedChunks.size(); i++) {
                if (savedChunks.get(i)==data){
                    count++;
                }
            }
            if (count==0){
                savedChunks.add(data);
                Node binHead = new Node(data);
                BinNode binNode = new BinNode();
                binNode.head.data=data;
                binNode.push(data); // اینجا باید اون ادرسا(مقادیر اینفو)ی قبل و بعد پوش بشن داخل ی نود جدید ک ب head وصل میشه(تو بین ها) اول بعدش همینجوری اضافه میشه، بعدا هر جا خواستیم malloc کنیم، میایم تو بین مربوط ب خودش میگردیم هر نود رو بررسی میکنیم ،هر جا قبل و بعدش، معادلی تو لینکد لیست اصلی داشت،(یعنی تو لینکلیست اصلی نود قبلی اینفو اون نود قبلیو رو داشته باشه و نود بعد اینفو اون نود بعدیه)اون جا malloc میکنیم
            }
//            else {
//
//            }
        }else {
            System.out.println("Not such a Node found!");
        }


    }

//    public void test(){
//        int j = 0 ;
//        for (int i = 0; i < 32; i++) {
//            j += 8 ;
//            BinNode binNode = new BinNode();
//            binNode.head.setData(j); ;
//            binNodes.add(binNode);
//        }
//    }

    public void print(){
        for (int i = 0; i < binNodes.size(); i++) {
            System.out.println(binNodes.get(i).head.data);
        }

    }



}
