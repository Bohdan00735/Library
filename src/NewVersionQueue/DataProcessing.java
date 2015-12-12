package NewVersionQueue;


import java.io.FileNotFoundException;

public interface DataProcessing<T> {

    public T take(Node head) throws FileNotFoundException;
}
