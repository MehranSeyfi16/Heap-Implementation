import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.util.ArrayList;

public class LinkedList {
    public static ArrayList<Integer> savedChunks = new ArrayList<>();
    public static ArrayList<BinList> binLists = new ArrayList<>();
    public Node head = new Node();
    private static int sizeOfMainLinkedList = 0;
    public static Node currentAddress;
    public static Node lastAddress;
    public static Node nextAddress;

    public static int getSizeOfMainLinkedList() {
        return sizeOfMainLinkedList;
    }

    public static void setSizeOfMainLinkedList(int sizeOfMainLinkedList) {
        LinkedList.sizeOfMainLinkedList = sizeOfMainLinkedList;
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
        Node newNode = new Node(data);
        Node test=new Node(data);
        Node q = new Node();
        boolean flag=true;
        int count=0;
        if (head.next == null) {
            head.next = newNode;
            head.data = head.data - data;
            setSizeOfMainLinkedList(getSizeOfMainLinkedList() + 1);
        } else {

            if (binLists.size()==0){
                q = head;
                newNode.next = q.next;
                q.next = newNode;
                head.data = head.data - data;
                count++;
            }
//            else{
//                for (int i = 0; i < binLists.size(); i++) {
//                    if (binLists.get(i).head.data == data) {
//
//                    }
//                }
//
//            }
            else {
                for (int i = 0; i < binLists.size(); i++) {
                    if (binLists.get(i).head.data == data) {
                        flag=false;
                        System.out.println(flag);
                        if (binLists.get(i).head.next==null){

                            q = head;
                            newNode.next = q.next;
                            q.next = newNode;
                            head.data = head.data - data;
                        }else {
                            BinNode saved = new BinNode();
                            saved = binLists.get(i).removeLastNode();
//                            System.out.println(saved.nextAddress + "saved");
                            q = head;
                            while (q.next != null && q != saved.lastAddress) {
                                q = q.next;
                            }
                            if (q.next == saved.nextAddress) {
                                saved.currentAddress.next = q.next;
                                q.next = saved.currentAddress;
                                head.data = head.data - data;
                            }
                        }
                        break;
                    }
                }

            }
            if (flag&&count==0){
                q = head;
                test.next = q.next;
                q.next = test;
                head.data = head.data - data;
            }

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
        Node current = head;
        while (current != null)
        {
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
//            System.out.println("Node found!");
            if (head.next.next == null) {
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
//                        System.out.println("binList"+data+":");
//                        binLists.get(i).traverse();
                        break;
                    }
                }
            } else {
                for (int i = 0; i < binLists.size(); i++) {
                    if (binLists.get(i).head.data == data){
                        binLists.get(i).push(nextAddress,lastAddress,currentAddress);
//                        binLists.get(i).traverse();
                        break;
                    }
                }
            }
        } else {
            System.out.println("Not such a Node found!");
        }
    }

//    public void free(int data){
//        int count=0 ;
//        if (search(head , data)){
////            System.out.println("Node found!");
//            if (head.next.next == null) {
//                deleteNode(data);
//                head.data = head.data + data;
//                return;
//            }
//            deleteNode(data);
//            head.data = head.data + data;
//            for (int i = 0; i < savedChunks.size(); i++) {
//                if (savedChunks.get(i)==data){
//                    count++;
//                }
//            }
//            if (count==0){
//                savedChunks.add(data);
//                BinNode binHead = new BinNode(data);
//                BinList binList = new BinList(binHead);
//                binLists.add(binList);
//                for (int i = 0; i < binLists.size(); i++) {
//                    if (binLists.get(i).head.data==data){
//                        binLists.get(i).push(nextAddress,lastAddress,currentAddress);
////                        System.out.println("binList"+data+":");
//                        binLists.get(i).traverse();
//                        break;
//                    }
//                }
//            } else {
//                for (int i = 0; i < binLists.size(); i++) {
//                    if (binLists.get(i).head.data == data){
//                        binLists.get(i).push(nextAddress,lastAddress,currentAddress);
//                        binLists.get(i).traverse();
//                        break;
//                    }
//                }
//            }
//        } else {
//            System.out.println("Not such a Node found!");
//        }
//    }

//    public void test(){
//        int j = 0 ;
//        for (int i = 0; i < 32; i++) {
//            j += 8 ;
//            BinList binNode = new BinList();
//            binNode.head.data = j; ;
//            binLists.add(binNode);
//        }
//    }
    public void print(){
        BinNode q=new BinNode();
        int count=0;
        for (int i = 0; i < binLists.size(); i++) {
            System.out.println("bin list head : " + binLists.get(i).head.data);
             q =binLists.get(i).head;
           while (q.next!=null) {
               q=q.next;
                count++;
            }
            System.out.println("the number of chunks in binnode "+binLists.get(i).head.data+" : "+count);

        }

    }
}
