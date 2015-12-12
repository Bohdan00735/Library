package NewVrsionQueue;


public class IComparable implements  Comparable{
    @Override
    public int compareTo(Object o) {
        Node add =  (Node) o;
        if (add.getElement() > add.getParent().getElement()) {
            return 1;
        } else if (add.getElement() < add.getParent().getElement()) {
            return -1;
        }
        return 0;
    }

}
