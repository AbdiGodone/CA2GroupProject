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


}
