package NewVersionQueue;


import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<U> implements Iterable {
    private IQueue<Node> queue = new IQueue<>();
    private Node head;
    protected Node tail;
    private Controler controler = new Controler();
    private TimeController timeController = new TimeController(head , queue);

    public void addToHead(U u) {
        Node node = new Node(u, head, null);
        if (tail == null) {
            tail = node;
        }
        queue.enlargeSize();
    }

    public void addToTail(U u) {
        Node node = new Node(u, null, tail);
        tail = node;

        if (head == null) {
            head = node;
        }
        queue.enlargeSize();
    }

    public U takeFromHad() throws FileNotFoundException {
        return (U) queue.take(head);
    }

    public U takeFromTail() throws FileNotFoundException {
        return (U) queue.takeFromTail(tail);
    }

    public U findValue(U value) throws FileNotFoundException, NoSuchElementException {
        try {
            return (U) controler.findNode(value, head, queue.getSize()).getValue();
        } catch (NullPointerException n) {
            return null;
        }
    }


    public void replaseFirstAndLast() {
        try {
            controler.replaceValueOfNodes(head, tail);
        } catch (NullPointerException nullPointerException) {
            System.out.println("first = last or they = 0");
        }

    }

    public void RearrangeTheElementsInReverseOrder() throws FileNotFoundException {
        IComparable iComparable = new IComparable();
        iComparable.compareInReversOrder(tail, queue);
    }

    public void replaseBigOnSmall() throws FileNotFoundException {
        IComparable iComparable = new IComparable();
        try {
            iComparable.compare(head, queue);
        } catch (NoSuchElementException n) {

        }
        replaseFirstAndLast();
    }


    public void deleteRecurringNode() throws FileNotFoundException, NoSuchElementException {
        try {
            Node fromBack = tail;
            Node parent = null;
            Node child = null;
            for (int i = 0; i < queue.getSize(); i++) {
                try {
                    controler.findNode((U) fromBack.getValue(), tail, queue.getSize());
                } catch (NullPointerException n) {
                }
                try {
                    child = fromBack.takeFirstChild();
                } catch (NullPointerException no) {
                }

                try {
                    parent = fromBack.getParent();
                } catch (NoSuchElementException no) {
                }

                if (child == null) {
                    parent.changeChild(null);

                } else if (parent == null) {
                    child.changeParent(null);

                } else {
                    parent.changeChild(child);
                    child.changeParent(parent);
                }

                fromBack = null;
            }
        } catch (FileNotFoundException ex) {
        }
    }

    public int getSize() throws FileNotFoundException {
        return queue.getSize();
    }

    public long determineTheTimeGetParent() {
        return timeController.determineTheTimeGetParent();
    }

    public long determineTheTimeTakeLastChild() {
        return  timeController.determineTheTimeTakeLastChild();
    }

    public long determineTheTimeTakeNode(){
        return timeController.determineTheTimeTakeNode();
    }

    @Override
    public Iterator iterator() {
        return new LinkedQueuIterator<>( head);
    }

    public class LinkedQueuIterator<E> implements Iterator<U>{
        private Node<E> head;

        public LinkedQueuIterator( Node<E> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head.takeFirstChild().equals(null);
        }

        @Override
        public U next() {
            while (hasNext()){
                head = head.takeFirstChild();
                Node add = head.getParent();
                return (U)add.getValue() ;

            }
            return null;
        }

    }
}
