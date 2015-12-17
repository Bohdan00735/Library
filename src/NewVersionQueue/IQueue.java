package NewVersionQueue;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class IQueue<E> implements DataProcessing, ControllerQueue  {
    private int size;

    @Override
    public E takeFromTail(Node tail) throws FileNotFoundException {
        E value = (E) tail.getValue();
        try {
            if (tail == null) {
                throw new FileNotFoundException();
            }
            value = (E) tail.getValue();
            tail = tail.getParent();
        } catch (NoSuchElementException no) {
            tail = null;
        }
        size--;
        return value;
    }

    @Override
    public E take(Node head) throws FileNotFoundException {
        E value = null;
        if (head == null) {
            throw new FileNotFoundException();
        } else {
            value = (E) head.getValue();

            try {
                head = head.takeFirstChild();
            } catch (NoSuchElementException no) {
                head = null;
            }

        }
        size--;
        return (E) value;
    }

   public void enlargeSize(){
       size++;
   }

    public int getSize() throws FileNotFoundException {
        if (size == 0) {
            throw new FileNotFoundException();
        }
        return size;
    }



}
