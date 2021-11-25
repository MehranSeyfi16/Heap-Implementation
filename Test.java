public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1080);
        linkedList.malloc(16);
        System.out.println(linkedList.head.getSize());
        System.out.println(linkedList.head.getNumberOfNodes());

    }
}

