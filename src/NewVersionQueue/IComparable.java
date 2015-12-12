package NewVersionQueue;


import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


public class IComparable implements Comparable {
    @Override
    public int compareTo(Object o) {
        Node add = (Node) o;
        Node parent = null;
        try {
            parent = add.getParent();
        }catch(NullPointerException no){
            return -1;
        }
            if (add.getElement() > parent.getElement()) {
                return 1;

        }else if (add.getElement() < parent.getElement()) {
            return -1;
        }


        return 0;
    }

    public static void compareInReversOrder(Node tail, IQueue queue) throws FileNotFoundException {
        Comparable iCom = new IComparable();
        Node add = tail;
        for (int i = 0; i < queue.getSize(); i++) {
            iCom.compareTo(add);
            try {
                add = add.getParent();
            }catch (NullPointerException n){

            }
        }
    }

    public static void compare(Node head, IQueue queue) throws FileNotFoundException , NoSuchElementException {
        Comparable iCom = new IComparable();
        Node add = head;
        for (int i = 0; i < queue.getSize(); i++) {
            iCom.compareTo(add);
            try {
                add = add.takeFirstChild();
            } catch (NullPointerException f) {
                add = null;
            }
        }
    }

}
