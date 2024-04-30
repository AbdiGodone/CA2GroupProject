package Ca2GroupProject;

public class BoundedPriorityQueue extends LinkedList{
    private LinkedList queue;
    private int maxSize;



    public BoundedPriorityQueue(int maxSize){
        if (maxSize <= 0){
            throw new IllegalArgumentException("the maxsize cannot be less 0 or equal to 0");
        }
        this.maxSize = maxSize;
    }

    /**
     * checks if the queue is full
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull(){
        return super.size() == maxSize;
    }

    /**
     * checks if the queue is empty
     * @return true id the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return super.isEmpty();
    }




}
