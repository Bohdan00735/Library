package NewVrsionQueue;


public interface DataProcessing <T>  {

    public void add(T t, Node tail, Node head);
    public String take(Node head);
}
