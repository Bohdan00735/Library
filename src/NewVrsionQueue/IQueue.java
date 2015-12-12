package NewVrsionQueue;

public   class IQueue<E>  implements DataProcessing, ControllerQueue {
    private int size;

    @Override
    public String takeFromTail(Node tail) {
        String value = tail.getValue();

        if (tail == null) {
            value = null;
        } else if (tail.getParent() != null) {
            value = tail.getValue();
            tail = null;
        } else {
            value = tail.getValue();
            tail = tail.getParent();
        }
        size--;
        return value;
    }

    @Override
    public String take(Node head) {
        String value = null;
        if (head == null) {
            value = null;
        } else {
            value = head.getValue();
            head = head.takeFirstChild();
        }
        size--;
        return  value;
    }

    @Override
    public void addToHead(Object o, Node head , Node tail) {
        Node node = new Node(0, head , null );
        head = node;
        if (tail == null){
            tail = node;
            size++;
        }
    }

    @Override
    public void add(Object o , Node tail , Node head) {
        Node node = new Node(o , null ,tail );
        tail = node;

        if (head == null){
            head = node;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public void replaceValueOfNodes(Node firstN , Node secondN){
        String first = firstN.getValue();
        String add = first;
        String second = secondN.getValue();
        first = second;
        second = add;
    }
}
