package Ca2GroupProject;

public class BoundedPriorityQueue extends LinkedList{
        private int maxSize;


    /**
     * constructs a boundedPriorityQueue with the specified maximum size
     * @param maxSize the maximum number of elements the queue can hold
     * @throws IllegalArgumentException if the specified maxsize is less than or equal to 0
     */
    public BoundedPriorityQueue(int maxSize){
            if (maxSize <= 0){
                throw new IllegalArgumentException("the maxsize cannot be less 0 or equal to 0");
            }
            this.maxSize = maxSize;
        }

    /**
     *returns the number of elements in the queue
     * @return the number of elements in the queue
     */
    public int size(){
            return super.size();
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


        /**
         *retrieves the first element in the boundedQueue, does not remove it
         * @return the first element in the boundedPriorityQueue
         */
        public Appointment peek(){
            if (super.isEmpty()){
                return null;
            }
            return super.get(0);
        }

    /**
     * retrieves the appointment at the front of the queue
     * @return appointment at the front of the queue
     * @throws NoElementFound if the queue is empty
     */
    public Appointment element(){
            if (super.isEmpty()){
               throw new  NoElementFound("the element found in the queue");
            }
            return super.get(0);
        }


        /**
         * adds an appointment to the queue if the queue is not full, not empty, or the first appointment in the queue is not the same doctor
         * @param appointment the appointment to be added to the queue
         * @throws IllegalArgumentException if the queue is full
         */
        public void add(Appointment appointment){
            if (isFull()){
                throw new IllegalArgumentException("the que is full cant be added");
            }
            if (super.isEmpty()){
                super.AddToStart(appointment);
            }
            if (!peek().getDoctorFullName().toLowerCase().equals(appointment.getDoctorFullName())){
                super.AddToStart(appointment);
            }

        }

    /**
     * adds the specified appointment to te queue if its possible
     * @param appointment the appointment to be added t the queue
     * @return true if appointment is added successfully, false if the queue is full, the appointment cannot be added
     *
     */
    public boolean offer(Appointment appointment){
    if (isFull()) {
        return false;
    }
    if (super.isEmpty()) {
        super.AddToStart(appointment);
    }
    if (!peek().getDoctorFullName().toLowerCase().equals(appointment.getDoctorFullName())) {
        super.AddToStart(appointment);
    }
    return true;
}

    /**
     * removes and returns the first element in the queue
     * @return the appointment removed from the front of the queue
     * @throws NoElementFound if the que is empty
     */
    public Appointment remove(){
            if (super.isEmpty()){
                throw  new NoElementFound("no element found to delete");
            }
            Appointment deletedValue = peek();
            super.Remove(0);
            return deletedValue;
        }


    /**
     * retrieves and removes the appointment at the front of the queue
     * @return the appointment removed from the front of the queue, or null if the queue is empty
     */
    public Appointment poll(){
        if (super.isEmpty()){
            return null;
        }
        return super.Remove(0);
        }

    /**
     * overrides the get method from the LinkedList as you cant get specific position in a queue
     * @param pos the position of the appointment to retrieved
     * @return does not return value, throws UnsupportedOperationException
     */
    @Override
    public Appointment get(int pos){
        throw new UnsupportedOperationException("getting specific position is not allowed ");
        }
}

