import java.util.ArrayList;

public class LinkedList {
    public static ArrayList<Integer> savedChunks = new ArrayList<>();
    public HeadNode head = new HeadNode();
    public static Node currentAddress;
    public static Node lastAddress;
    public static Node nextAddress;

    LinkedList(int size){
        head.setSize(size);
        head.next= null;
    }

    public void malloc(int data){
        Node newNode = new Node(data);
        Node q = new Node();
        if (head.next == null){
            head.next = newNode;
            head.setSize(head.getSize()-data);
            head.setNumberOfNodes(head.getNumberOfNodes()+1);
        }
        else{

        }

    }

    public void deleteNode(int data){
        Node q = new Node();
        if (head.next == null){
            System.out.println("List is emoty!");
        }else {
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
                head.setNumberOfNodes(head.getNumberOfNodes()-1);
            }
        }
    }

    public void free(int data){
        int count=0 ;
        deleteNode(data);
        head.setSize(head.getSize()+data);
        savedChunks.add(data);
        for (int i = 0; i < savedChunks.size(); i++) {
            if (savedChunks.get(i)==data){
                count++;
            }
        }
        if (count==0){
            HeadNode headNode = new HeadNode(data);
            String str = "binNode" + headNode.data ;
            BinNode binNode = new BinNode();

        }


    }



}
