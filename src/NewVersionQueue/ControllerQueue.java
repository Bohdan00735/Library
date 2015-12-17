package NewVersionQueue;

import java.io.FileNotFoundException;

public interface ControllerQueue<T> {
    public T takeFromTail(Node taile) throws FileNotFoundException;



}
