import java.util.ArrayList;

public class LinkedList implements Traversable {
    private final ArrayList<Integer> savedChunks = new ArrayList<>();
    private final ArrayList<BinList> binLists = new ArrayList<>();
    private final Node head = new Node();
    private int sizeOfMainLinkedList = 0;
    private Node currentAddress;
    private Node lastAddress;
    private Node nextAddress;

    public int getSizeOfMainLinkedList() {
        return sizeOfMainLinkedList;
    }

    public void setSizeOfMainLinkedList(int sizeOfMainLinkedList) {
        this.sizeOfMainLinkedList = sizeOfMainLinkedList;
    }

    LinkedList(int size) {
        head.data = size;
        head.next = null;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public void malloc(int data) {
        if (data<0){
            System.out.println("It is not possible to malloc a negative value!");
            return;
        }
        Node newNode = new Node(data);
        Node test=new Node(data);
        Node q = new Node();
        boolean flag=true;
        int count=0;
        if(head.data-data<0){
            System.out.println("Not enough memory!");
        }
        else{
            if (head.next == null) {
                head.next = newNode;
                head.data = head.data - data;
                setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
            } else {

                if (binLists.size() == 0) {
                    q = head;
                    newNode.next = q.next;
                    q.next = newNode;
                    head.data = head.data - data;
                    setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
                    count++;
                } else {
                    for (int i = 0; i < binLists.size(); i++) {
                        if (binLists.get(i).head.data == data) {
                            flag = false;
                            if (binLists.get(i).head.next == null) {
                                q = head;
                                newNode.next = q.next;
                                q.next = newNode;
                                head.data = head.data - data;
                                setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
                            } else {
                                BinNode saved ;
                                saved = binLists.get(i).removeLastNode();
                                q = head;

                                while (q.next != null && q != saved.lastAddress) {
                                    q = q.next;
                                }
                                if (q.next == saved.nextAddress) {
                                    saved.currentAddress.next = q.next;
                                    q.next = saved.currentAddress;
                                    head.data = head.data - data;
                                    setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
                                }
                                else {
                                    q=q.next;
                                    saved.currentAddress.next = q.next;
                                    q.next = saved.currentAddress;
                                    head.data = head.data - data;
                                    setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
                                }

                            }
                            break;
                        }
                    }

                }
                if (flag && count == 0) {
                    q = head;
                    test.next = q.next;
                    q.next = test;
                    head.data = head.data - data;
                    setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
                }
            }
        }
    }



    public void traverse(){
        Node p;
        int count=1;
        if (head == null)
            System.out.println("list is empty!!");
        else {
            p = head;
            int num = getSizeOfMainLinkedList()+1;
            System.out.println("The number of nodes in the main LinkedList: "+ num);
            System.out.println("Head size (Available memory) : "+p.data);
            p=p.next;
            while (p != null) {
                System.out.println("Size of Node"+count+" : "+p.data);
                count++;
                p = p.next;

            }
        }
    }

    public boolean search(Node head, int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x)
                return true;
            current = current.next;
        }
        return false;
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
            if (head.next.data == data) {
                deleteNode(data);
                head.data = head.data + data;
                return;
            }
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
                binLists.add(binList);
                for (int i = 0; i < binLists.size(); i++) {
                    if (binLists.get(i).head.data==data){
                        binLists.get(i).push(nextAddress,lastAddress,currentAddress);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < binLists.size(); i++) {
                    if (binLists.get(i).head.data == data){
                        binLists.get(i).push(nextAddress,lastAddress,currentAddress);
                        break;
                    }
                }
            }
        } else {
            System.out.println("Not such a Node found!");
        }
    }

    public void print(){
        BinNode q=new BinNode();
        int count=0;
        for (int i = 0; i < binLists.size(); i++) {
            System.out.println("Bin list head : " + binLists.get(i).head.data);
            q =binLists.get(i).head;
            while (q.next!=null) {
                q=q.next;
                count++;
            }
            System.out.println("The number of chunks in bin node "+binLists.get(i).head.data+" : "+count );
            count=0;
        }

    }
}