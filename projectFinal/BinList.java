public class BinList implements Traversable{
    public BinNode head ;

    public BinList(BinNode head) {
        this.head = head;
    }

    public void push(Node nextAddress, Node lastAddress, Node currentAddress) {
        BinNode newNode = new BinNode(nextAddress,lastAddress,currentAddress);
        newNode.next = null;

        if( head  == null ) {
            head = newNode;
        } else {
            BinNode temp = new BinNode();
            temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }
    }

    public BinNode removeLastNode(){
        if (head == null)
            System.out.println("head is null");

        if (head.next == null) {
            System.out.println("next of head is null");
        }

        BinNode second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        BinNode deletedBin = second_last.next;
        second_last.next = null;

        return deletedBin;

    }

    public void traverse(){
        BinNode p;
        if (head == null)
            System.out.println("List is empty!!");
        else {
            p = head;
            while (p != null) {
                System.out.println(p.data);
                System.out.println(p.lastAddress);
                System.out.println(p.currentAddress);
                System.out.println(p.nextAddress);
                p = p.next;
            }
        }
    }

}
