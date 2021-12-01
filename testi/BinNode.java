public class BinNode {
    int data ;
    public BinNode next ;

    public Node nextAddress ; //Holds the address of next of our appropriate node
    public Node lastAddress ; //Holds address of previous of our appropriate node
    public Node currentAddress ; //Holds address of our appropriate node

    BinNode(){

    }

    BinNode(int data){
        this.data = data ;
    }

    public BinNode(Node nextAddress, Node lastAddress, Node currentAddress) {
        this.nextAddress = nextAddress;
        this.lastAddress = lastAddress;
        this.currentAddress = currentAddress;
    }
}
