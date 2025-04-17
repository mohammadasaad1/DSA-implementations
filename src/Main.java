import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList x = new LinkedList();
        x.addLast(1);
        x.addLast(2);
        x.addLast(3);
        var arr = x.toArray() ;
        System.out.println(Arrays.toString(arr));
    }
}