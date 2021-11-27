public class BinNode {
    //    public HeadNode binHead;
    public Node head = new Node();
    private Node next ;
    private Node last ;
    private Node current ;

    public void push(int new_data)
    {
        //Allocate new node and putting data
        Node new_node = new Node(new_data);

        //Make next of new node as head
        new_node.next = head;

        //Move the head to point to new Node
        head = new_node;
    }

    public void insertBinList(BinNode binList){

    }
}
