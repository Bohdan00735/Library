package NewVersionQueue;

import java.util.NoSuchElementException;

public class Node<T> implements ControllerForNod , MyAction {
    private T value;
    private Node child;
    private Node parent;
    private int element;

    public Node(T value, Node child, Node parent) {
        this.value = value;
        this.child = child;
        this.parent = parent;
        this.element = (int) (Math.random() * 100);
    }

    public void changeChild(Node child) {
        this.child = child;
    }

    @Override
    public void changeParent(Node parent) {
        this.parent = parent;
    }

    public Boolean auditNodeChild() {
        if (child == null) {
            return false;
        }
        return true;
    }

    public Boolean auditNodeParent() {
        if (parent == null) {
            return false;
        }
        return true;
    }

    public Node takeFirstChild() throws NoSuchElementException {
        if (auditNodeChild().equals(true)) {
            return child;
        }
        throw new NoSuchElementException();
    }

    public Node takeLastChild(int queueSize) throws NoSuchElementException {
        Node add = null;
        if (auditNodeChild().equals(true)) {
            for (int i = 0; i < queueSize; i++) {
                add = child;
                return add;
            }
        }
        throw new NoSuchElementException();
    }

    public T getValue() {
        return value;
    }

    public int getElement() {
        return element;
    }

    public Node getParent() throws NoSuchElementException {
        if (auditNodeParent().equals(false)) {
            throw new NoSuchElementException();
        }
        return parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (value.equals(obj)) {
            return true;
        }
        return false;
    }

    public void determineTheT(MyAction action){

}
}
