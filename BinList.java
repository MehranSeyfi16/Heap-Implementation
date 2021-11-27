public class BinList {
//    public HeadNode binHead;

    public BinNode head ;

    public BinList(BinNode head) {
        this.head = head;
    }

    void push(Node nextAddress, Node lastAddress, Node currentAddress) {

        BinNode newNode = new BinNode(nextAddress,lastAddress,currentAddress);
        newNode.next = null;

        if( head  == null ) {
            head = newNode;
        }
        else {

            BinNode temp = new BinNode();
            temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }
    }


}
