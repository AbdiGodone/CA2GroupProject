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


        /**
         *retrieves the first element in the boundedQueue, does not remove it
         * @return the first element in the boundedPriorityQueue
         */
        public Appointment peek(){
            if (queue.isEmpty()){
                return null;
            }
            return queue.get(0);
        }

    /**
     * retrieves the appointment at the front of the queue
     * @return appointment at the front of the queue
     * @throws NoElementFound if the queue is empty
     */
    public Appointment element(){
            if (queue.isEmpty()){
               throw new  NoElementFound("the element found in the queue");
            }
            return queue.get(0);
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
            if (queue.isEmpty()){
                queue.AddToStart(appointment);
            }
            if (!queue.get(0).getDoctorFullName().toLowerCase().equals(appointment.getDoctorFullName())){
                queue.AddToStart(appointment);
            }

        }


    /**
     * removes and returns the first element in the queue
     * @return the appointment removed from the front of the queue
     * @throws NoElementFound if the que is empty
     */
    public Appointment remove(){
            if (queue.isEmpty()){
                throw  new NoElementFound("no element found to delete");
            }
            Appointment deletedValue = peek();
            queue.Remove(0);
            return deletedValue;
        }


    /**
     * retrieves and removes the appointment at the front of the queue
     * @return the appointment removed from the front of the queue, or null if the queue is empty
     */
    public Appointment poll(){
        if (queue.isEmpty()){
            return null;
        }
        return queue.Remove(0);
        }








    }

