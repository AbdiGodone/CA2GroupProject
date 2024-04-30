package Ca2GroupProject;

import java.io.LineNumberReader;
import java.util.NoSuchElementException;

public class BoundedPriorityQueue extends LinkedList{
    private LinkedList Queue;
    private int maxSize;

    public BoundedPriorityQueue(int maxSize){

        if(maxSize <= 0){
            throw new IllegalArgumentException("the size cannot be less or equal to 0");
        }
        this.Queue = new LinkedList();

    }






















}
