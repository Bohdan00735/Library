package NewVersionQueue;


import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Controler<E> {

    public  void replaceValueOfNodes(Node firstN, Node secondN) throws NullPointerException {
        if (firstN == null || secondN == null) {
            throw new NullPointerException();
        }
        E first = (E) firstN.getValue();
        E add = first;
        E second = (E) secondN.getValue();
        first = second;
        second = add;
    }

    protected  Node findNode(E value , Node first , int size) throws FileNotFoundException {
        Node node = first;
        Node res = null;
        if (size == 0) {
            throw new FileNotFoundException();
        }
        for (int i = 0; i < size; i++) {
            if (node.equals(value)) {
                res = node;
                return res;
            }
        }try {
            node = node.takeFirstChild();
        }catch (NoSuchElementException n){

        }
        return res;
    }
}
