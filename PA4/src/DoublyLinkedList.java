/*
 * NAME: Josef Ongchangco
 * PID: A17751436
 */

import java.util.AbstractList;

/**
 * PA4 Doubly Linked List
 * @author Josef Ongchangco
 * @since 04/29/2024
 */
public class DoublyLinkedList<E> extends AbstractList<E> {
    private int size;
    private Node head;
    private Node tail;

    /**
     * Node to create a linked list via chaining.
     */
    protected class Node {
        E item;
        Node next;
        Node prev;

        /**
         * Constructor to create a singleton Node.
         * @param element the item to be added
         */
        private Node(E element) {
            this.item = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create a singleton link between the previous and next nodes.
         * @param element the item to be added
         * @param nextNode the successor Node
         * @param prevNode the predecessor Node
         */
        private Node(E element, Node nextNode, Node prevNode) {
            this.item = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the item of this node.
         * @param element new item
         */
        public void setItem(E element) {
            this.item = element;
        }

        /**
         * Get the item of this node.
         * @return the item
         */
        public E getItem() {
            return this.item;
        }

        /**
         * Set the next node.
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node.
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node.
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }

        /**
         * Get the previous node.
         * @return the predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         */
        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        this.size = 0;
    }

    @Override
    public boolean add(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }

        Node newNode = new Node(element);
        newNode.setPrev(tail.prev);
        tail.prev.setNext(newNode);
        newNode.setNext(tail);
        tail.setPrev(newNode);
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(element);
        Node currentNode = getNodeAt(index);
        newNode.next = currentNode;
        newNode.prev = currentNode.prev;
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;
        size++;
    }

    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        size = 0;
    }

    @Override
    public boolean contains(Object element) {
        E data = (E) element;
        Node curNode = head.next;
        while (curNode != null) {
            if (curNode.item.equals(data)) {
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node nodeToGet = getNodeAt(index);
        return nodeToGet.getItem();
    }

    private Node getNodeAt(int index) {
        Node curNode = head.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = getNodeAt(index);
        Node previousNode = currentNode.getPrev();
        Node nextNode = currentNode.getNext();
        nextNode.prev = currentNode.prev;
        currentNode.prev.next = nextNode;
        size--;
        return currentNode.getItem();
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node updateElement = getNodeAt(index);
        E previousData = updateElement.item;
        updateElement.item = element;
        return previousData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringOutput = new StringBuilder();
        if (size == 0) {
            stringOutput.append("[(head) -> (tail)]");
        } else {
            stringOutput.append("[(head) ");
            Node curNode = head.next;
            stringOutput.append("-> ");
            for (int i = 0; i < this.size; i++) {
                stringOutput.append(curNode.item);
                if (curNode.getNext() != null) {
                    stringOutput.append(" -> ");
                }
                curNode = curNode.getNext();
            }
            stringOutput.append("(tail)]");
        }
        return stringOutput.toString();
    }
}
