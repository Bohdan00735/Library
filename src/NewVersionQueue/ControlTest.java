package NewVersionQueue;


import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ControlTest<E> extends LinkedQueue {
    public void startAllTests(E first, E second, E third, E fourth) {
        LinkedQueue(first, second, third, fourth);
    }

    private static void LinkedQueue(Object first, Object second, Object third, Object fourth) {
        LinkedQueue linkedQueue = new LinkedQueue();
        Controler controler = new Controler();
        linkedQueue.addToHead(first);
        linkedQueue.addToHead(second);
        linkedQueue.addToTail(third);
        linkedQueue.addToTail(fourth);
        linkedQueue.replaseFirstAndLast();

        testQueue(linkedQueue);
        try {

            testNode(linkedQueue.tail.getParent(), linkedQueue.getSize());
            linkedQueue.replaseBigOnSmall();
            linkedQueue.replaseFirstAndLast();
            linkedQueue.findValue(second);
            linkedQueue.replaseBigOnSmall();
        } catch (FileNotFoundException fileNot) {
            System.out.println(" FileNotFoundException : Linked Queue");
        }
        try {
            try{linkedQueue.deleteRecurringNode();
            }catch (FileNotFoundException f){
                System.out.println("Delete Recurring Node : FileNotFoundException");
            }
        }catch (NoSuchElementException f){
            System.out.println("Delete Recurring Node : NoSuchElementException");
        }

    }

    private static void testNode(Node node, int size) {
        node.getValue();

        try {
            node.getParent();
            node.getElement();
            node.takeFirstChild();
            node.takeLastChild(size);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Node : NoSuchElementException");
        }
    }

    private static void testQueue(LinkedQueue linkedQueue) {
        try {
            linkedQueue.takeFromHad();
            linkedQueue.takeFromTail();
            linkedQueue.getSize();
        } catch (FileNotFoundException f) {
            System.out.println("Queue : FileNotFoundException ");
        }
    }

}