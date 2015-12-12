package NewVersionQueue;

import java.util.NoSuchElementException;

public interface ControllerForNod {
    public Node takeLastChild(int queueSize) throws NoSuchElementException;

    public Node takeFirstChild() throws NoSuchElementException;

    public void changeChild(Node child);

    public void changeParent(Node parent);
}
