package Ca2GroupProject;


public class LinkedList {
        private Node head;
        private int numOfElements;

        public LinkedList(){
            head = null;
            numOfElements = 0;
        }

        public int size(){
            return numOfElements;
        }

        public boolean isEmpty(){
            return numOfElements == 0;
        }

        public void AddToStart(Appointment data){
            Node node = new Node(data);

            if (isEmpty()){
              head = node;
            }
            else {
                node.setNext(head);
                head = node;
            }
            numOfElements++;

        }

        public Appointment get(int pos){
            if (pos < 0 || pos >= numOfElements){
                throw new IndexOutOfBoundsException();
            }
            Node current = head;

            for (int i = 0; i < pos; i++) {
                current = current.getNext();

            }
            return current.getData();

        }

        public Appointment Remove(int pos){


            if (pos < 0 || pos>= numOfElements){
                throw new IndexOutOfBoundsException();
            }

            Appointment deletedValue = null;

            if (pos == 0 ){
                Node current = head;
                current = current.getNext();
            } else if (pos > 0) {
                Node current = head;

                for (int i = 0; i < pos -1; i++) {
                    current =  current.getNext();

                }

                deletedValue = current.getNext().getData();

                current.setNext(current.getNext().getNext());
                numOfElements--;



            }
            return deletedValue;

        }


        protected static class Node {
            private Appointment data;
            private Node next;

            public Node(Appointment data) {
                this.data = data;
                next = null;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }

            public void setData(Appointment data) {
                this.data = data;
            }

            public Appointment getData() {
                return this.data;
            }
        }
    }


