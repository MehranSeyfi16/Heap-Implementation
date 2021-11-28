public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1080);
//        linkedList.malloc(15);
//        linkedList.free(15);
//        if (linkedList.isEmpty()){
//            System.out.println("t");
//        }else {
//            System.out.println("f");
//        }
//        System.out.println(linkedList.head);
//        System.out.println(linkedList.head.getData());
        linkedList.malloc(16);
        linkedList.malloc(20);
        linkedList.malloc(25);
        linkedList.free(20);
        linkedList.malloc(20);
        linkedList.traverse();

    }
}

