package Ca2GroupProject;


public class LinkedList {
        private Node head;
        private int numOfElements;

        public LinkedList(){
            head = null;
            numOfElements = 0;
        }


        protected static class Node {
            private int data;
            private Node next;

            public Node(int data) {
                this.data = data;
                next = null;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }

            public void setData(int data) {
                this.data = data;
            }

            public int getData() {
                return this.data;
            }
        }
    }

}
