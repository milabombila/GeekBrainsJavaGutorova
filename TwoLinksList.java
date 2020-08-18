public class TwoLinksList {
    private TwoLinksList.Node head;
    private TwoLinksList.Node tail;
    private int size;

    public void add(String val) {
        if (head == null) {
            head = new TwoLinksList.Node(val);
            tail = head;
            size++;
            return;
        }

        TwoLinksList.Node newNode = new TwoLinksList.Node(val);
        tail.setNext(newNode);
        TwoLinksList.Node current = new TwoLinksList.Node(tail.getValue(), tail.getPrevious());
        tail = newNode;
        tail.setPrevious(current);
        size++;
    }
//    public void delete(int index){
//        if (index > size) {
//            throw new IndexExceedsSizeLengthException(
//                    String.format(
//                            "Index %s cannot be removed. It's bigger than list size %s",
//                            index, size));
//        }
//        if (index == 0) {
//            throw new IndexExceedsSizeLengthException(
//                    String.format(
//                            "Index %s cannot be removed. It's bigger than list size %s",
//                            index, size));
//        }
//        int currentIndex = 1;
//        TwoLinksList.Node current = head.getNext();
//
//        while (currentIndex != index) {
//            current = current.getNext();
//            currentIndex++;
//        }
//        current.getNext().setPrevious(current.getPrevious());
//        current.getPrevious().setNext(current.getNext());
//        current.delete();
//        size--;
//    }

    public void add(int index, String val) {
        if (index > size) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index == 0) {
            if (head == null) {
                head = new TwoLinksList.Node(val);
                tail = head;
            } else {
                head.setValue(val);
            }
            return;
        }

        int currentIndex = 1;
        TwoLinksList.Node current = head.getNext();

        while (currentIndex != index) {
            current = current.getNext();
            currentIndex++;
        }

        if (current == null) {
            add(val);
        } else {
            current.setValue(val);
        }
    }

    public int size() {
        return size;
    }

    public TwoLinksList.Iterator iterator() {
        return new TwoLinksList.Iterator(head);
    }

    /**
     * @deprecated breaks performance because has linier complexity
     * Will go thru all elements before find last one
     */
    private void add(String val, TwoLinksList.Node prev, TwoLinksList.Node current) {
        if (current == null) {
            prev.setNext(new TwoLinksList.Node(val));
            return;
        }
        add(val, current, current.getNext());
    }

    private static class Node {
        private String value;
        private TwoLinksList.Node next;
        private TwoLinksList.Node previous;

        public Node(String value) {
            this(value, null, null);
        }
        public Node(String value, TwoLinksList.Node previous) {
            this(value, null, previous);
        }

        public Node(String value, TwoLinksList.Node next, TwoLinksList.Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public TwoLinksList.Node getNext() {
            return next;
        }
        public void delete(){
           this.value = null;
        }

        public void setNext(TwoLinksList.Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public boolean hasPrevious(){
            return previous != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "previous= " + previous +
                    ", value= " + value +
                    '}';
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "previous=" + hasPrevious() +
//                    ", value='" + value + '\'' +
//                    "next="  + next +
//                    '}';
//        }
    }

    @Override
    public String toString() {
        return "TwoLinksList{" +
                "tail=" + tail +
                ", size=" + size +
                '}';
    }


    public static class Iterator {
        private TwoLinksList.Node head;
        private TwoLinksList.Node current;

        private Iterator() {
        }

        private Iterator(TwoLinksList.Node current) {
            this.head = current;
        }

        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.getNext() != null;
        }

        public String next() {
            if (current == null) {
                current = head;
            } else {
                current = current.getNext();
            }
            return current.getValue();
        }

    }
}
