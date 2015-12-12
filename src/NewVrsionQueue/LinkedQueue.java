package NewVrsionQueue;


public class LinkedQueue<U> {
    private IQueue<Node> queue = new IQueue();
    private Node head;
    private Node tail;

    public void addToHead(U u) {
        queue.addToHead(u, head, tail);
    }

    public void addToTail(U u) {
        queue.add(u, tail, head);
    }

    public String takeFromHad() {
        return queue.take(head);
    }

    public String takeFromTail() {
        return queue.takeFromTail(tail);
    }

    public String findValue(String value) throws Exception {
        return findNode(value).getValue();
    }

    private Node findNode(String value) throws Exception {
        Node node = head;
        Node res = null;
        for (int i = 0; i < queue.getSize(); i++) {
            if (node.equals(value)) {
                res = node;
                return res;
            }
            node = node.takeFirstChild();
        }
        throw new Exception();
    }

    public void replaseFirstAndLast() {
        queue.replaceValueOfNodes(head, tail);
    }

    public void replaseBigOnSmall() {
        compare();
        queue.replaceValueOfNodes(head, tail);
    }

    private void compare() {
        Comparable iCom = new IComparable();
        Node add = head;
        for (int i = 0; i < queue.getSize(); i++) {
            iCom.compareTo(add);
            add = add.takeFirstChild();
        }
    }

    public void deleteRecurringNode() {
        try {
            Node fromBack = tail;
            for (int i = 0; i < queue.getSize(); i++) {
                findNode(fromBack.getValue());
                Node child = fromBack.takeFirstChild();
                Node parent = fromBack.getParent();
                if (child == null){
                    parent.changeChild(null);
                }else if (parent == null){
                    child.changeParent(null);
                }else {
                    parent.changeChild(child);
                    child.changeParent(parent);
                }
                fromBack = null;
            }
        }catch (Exception ex){}

    }
}
