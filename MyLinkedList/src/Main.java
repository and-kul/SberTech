import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(Arrays.toString(list.toArray()));


    }
}
