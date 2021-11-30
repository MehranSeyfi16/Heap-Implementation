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
        linkedList.malloc(54);
        linkedList.traverse();
        linkedList.malloc(36);
        linkedList.traverse();
        linkedList.free(36);
        linkedList.traverse();
        linkedList.free(54);
        linkedList.traverse();
        System.out.println(linkedList.head.data);
//        linkedList.traverse();
//        linkedList.malloc(20);
//        linkedList.malloc(25);
//        linkedList.malloc(36);
//        linkedList.malloc(54);
//        linkedList.traverse();
//        linkedList.free(20);
//        linkedList.traverse();
//        linkedList.free(36);
//        linkedList.traverse();
//        linkedList.malloc(20);
//        linkedList.traverse();
//        linkedList.malloc(20);
//        linkedList.traverse();

    }
}

