package NewVersionQueue;


public final class TimeController extends  LinkedQueue {
    TimeChekedQueue timeChekedQueue;
    IQueue queue;
    private  Node head;

    public TimeController(Node head, IQueue iQueue) {
        this.head = head;
        this.queue = queue;
        chekTime();
    }

    public void chekTime(){
        try {
            timeChekedQueue = new TimeChekedQueue(head , queue);
        }catch (NoSuchFieldException f){}
    }

    public long determineTheTimeGetParent() {
        return timeChekedQueue.determineTheTimeGetParent();
    }

    public long determineTheTimeTakeLastChild() {
       return timeChekedQueue.determineTheTimeTakeLastChild();
    }

    public long determineTheTimeTakeNode(){
        return timeChekedQueue.determineTheTimeTakeNode();
    }
}
