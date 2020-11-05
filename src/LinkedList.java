public class LinkedList<E> implements List {
    Node<E> head;
    Node<E> tail;
    int size;

    /**
     * constructor sets all our head, tail and size
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * private class to create notes
     *
     * @param <E>
     */
    private class Node<E> {
        E data;
        Node<E> next;

        /**
         * private class constructor to create nodes w data and next attribute accessible throughout class
         *
         * @param value
         */
        public Node(E value) {
            data = value;
            next = null;

        }
    }

    /**
     * adds a node to the end of the list given a value
     *
     * @param value
     * @return
     */
    public boolean add(Object value) {
        Node<E> node = new Node<E>((E) value);
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
        return true;
    }

    /**
     * adds a node to the linked list given a specified index and value
     *
     * @param index
     * @param value
     */
    public void add(int index, Object value) {
        Node<E> node = new Node<E>((E) value);
        int range = 0;
        for (Node<E> cur = this.head; cur != null; cur = cur.next) {
            range += 1;
        }
        if (this.head == null) {
            head = node;
            tail = node;
            size++;
        } else if (index <= range) {
            Node<E> newNode = head;
            while (--index > 0) {
                newNode = newNode.next;
            }
            node.next = newNode.next;
            newNode.next = node;
            size++;

        } else {
            System.out.println("Sorry, index is out of range");
        }
    }

    /**
     * returns the item given a specified index
     *
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * removes an element from a linked list given a specified position
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index == 0) {
            Node<E> node = head;
            head = head.next;
            --size;
            return node.data;
        } else {
            Node<E> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node<E> newNode = prev.next;
            prev.next = newNode.next;
            --size;
            return newNode.data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * to string to properly display linked list
     * @return
     */
    @Override
    public String toString() {
        return toString(head);
    }

    public String toString(Node front){
        if(front.next != null){
            return front.data + "->" + toString(front.next);
        }return String.valueOf(front.data);
    }

}
