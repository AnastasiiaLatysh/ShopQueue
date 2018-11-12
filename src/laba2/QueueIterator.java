package laba2;

import java.util.Iterator;
import java.util.NoSuchElementException;


class QueueIterator<Shop> implements Iterator<Shop> {

    private Node<Shop> current;

    QueueIterator(Node<Shop> first) {
        current = first;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Shop next() {
        if (!hasNext()) throw new NoSuchElementException();
        Shop shop = current.shop;
        current = current.next;
        return shop;
    }
}
