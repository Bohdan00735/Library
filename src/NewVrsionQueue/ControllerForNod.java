package NewVrsionQueue;

public interface ControllerForNod {
    public Node takeLastChild(int queueSize);
    public Node takeFirstChild();
    public void changeChild(Node child);
    public void changeParent(Node parent);
}
