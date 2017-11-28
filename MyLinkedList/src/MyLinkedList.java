import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Node<E> {
    Node<E> prev;
    E elem;
    Node<E> next;

    public Node(Node<E> prev, E elem, Node<E> next) {
        this.prev = prev;
        this.elem = elem;
        this.next = next;
    }

    public Node insertBeforeCurrent(E newElem) {
        Node<E> newNode = new Node<>(this.prev, newElem, this);
        if (this.prev != null)
            this.prev.next = newNode;
        this.prev = newNode;

        return newNode;
    }

    public Node insertAfterCurrent(E newElem) {
        Node<E> newNode = new Node<>(this, newElem, this.next);
        if (this.next != null)
            this.next.prev = newNode;
        this.next = newNode;

        return newNode;
    }

    public void remove() {
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }
}



public class MyLinkedList<E> implements List<E> {
    // before first node
    private Node<E> head;

    // after last node
    private Node<E> tail;

    private int size;

    public MyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, null, null);

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    private Node<E> getNodeWithIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head.next;
        for (int i = 0; i < index; ++i) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        Object[] ar = new Object[size];

        Node<E> currentNode = head.next;
        for (int i = 0; i < size; ++i) {
            ar[i] = currentNode.elem;
            currentNode = currentNode.next;
        }

        return ar;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        tail.insertBeforeCurrent(e);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    @Override
    public E get(int index) {
        return getNodeWithIndex(index).elem;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeWithIndex(index);
        E previousValue = node.elem;
        node.elem = element;

        return previousValue;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = getNodeWithIndex(index);
        node.insertBeforeCurrent(element);
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNodeWithIndex(index);
        E value = node.elem;
        node.remove();
        size--;

        return value;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> currentNode = head.next;
        for (int i = 0; i < size; ++i) {
            if (currentNode.elem.equals(o))
                return i;

            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> currentNode = tail.prev;
        for (int i = size-1; i >= 0; --i) {
            if (currentNode.elem.equals(o))
                return i;

            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
