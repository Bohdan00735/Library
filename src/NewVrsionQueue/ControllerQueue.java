package NewVrsionQueue;

public interface ControllerQueue <T> {
    public String takeFromTail(Node taile);
    public void addToHead(T t, Node head, Node tail);




}
