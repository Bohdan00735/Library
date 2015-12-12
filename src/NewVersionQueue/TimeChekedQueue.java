package NewVersionQueue;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public final class TimeChekedQueue {
    private IQueue iQueue;
    private Node head;
    private Node tail;

    public TimeChekedQueue(Node head, IQueue iQueue) throws NoSuchFieldException {
        this.head = head;
        this.iQueue = iQueue;
        try {
            tail = head.takeLastChild(iQueue.getSize());
        } catch (FileNotFoundException f) {
            System.out.println("Queue is empty");
            throw new NoSuchFieldException();
        }

    }

    public long determineTheTimeGetParent() {
        Node add = head.takeFirstChild();
        long start = System.currentTimeMillis();
        try {
            add.getParent();
        } catch (NoSuchElementException n) {
        }
        long end = System.currentTimeMillis();

        return end - start;
    }

    public long determineTheTimeTakeLastChild() {
        Node add = head;
        long start = 0;
        long end = 0;
        try {
            start = System.currentTimeMillis();
            try {
                add.takeLastChild(iQueue.getSize());
            } catch (FileNotFoundException n) {
            }
            end = System.currentTimeMillis();
        } catch (NoSuchElementException no) {
        }

        return end - start;
    }

    public long determineTheTimeTakeNode(){
        long start = 0;
        long end = 0;

            start = System.currentTimeMillis();
            try {
               iQueue.take(head);
            } catch (FileNotFoundException n) {
            }
            end = System.currentTimeMillis();

        return end - start;
    }

}
