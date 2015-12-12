package NewVrsionQueue;

public class Node<T> implements ControllerForNod {
    private String value;
    private Node child;
    private Node parent;
    private int element;

    public Node(T value, Node child, Node parent) {
        this.value = value.toString();
        this.child = child;
        this.parent = parent;
        this.element = (int) (Math.random() * 100) ;
    }

    public void changeChild(Node child){
        this.child = child;
    }

    @Override
    public void changeParent(Node parent) {
        this.parent = parent;
    }

    public Boolean auditNodeChild(){
        if (child == null ) {
            return false;
        }return true;
    }

    public Boolean auditNodeParent(){
        if (parent == null ) {
            return false;
        }return true;
    }

    public Node takeFirstChild(){
        if (auditNodeChild().equals(true)) {
            return child;
        }return null;
    }

    public Node takeLastChild(int queueSize){
        Node add = null;
        if (auditNodeChild().equals(true)) {
            for (int i = 0; i < queueSize; i++) {
                add = child;
            }
        }
        return add;
    }

    public String getValue() {
        return value;
    }

    public int getElement(){
        return element;
    }

    public Node getParent() {
        if (auditNodeParent().equals( null)) {
            return null;
        }
        return parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (value.equals(obj)){
            return true;
        }
        return false;
    }


}
