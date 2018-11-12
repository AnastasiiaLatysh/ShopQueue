package laba2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShopsQueue implements Iterable {

    private Node<Shop> first;
    private Node<Shop> last;
    private int n;

    ShopsQueue() {
        first = null;
        last  = null;
        n = 0;
    }

    boolean isEmpty() {
        return first == null;
    }

    void insert(Shop shop) {
        Node<Shop> oldLast = last;
        last = new Node<>();
        last.shop = shop;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        n++;
    }

    Shop remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Shop shop = first.shop;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
        return shop;
    }

    public Iterator<Shop> iterator()  {
        return new QueueIterator<>(first);
    }

    void browseCurrentQueue(){
        for (Iterator<Shop> it = this.iterator(); it.hasNext(); ) {
            Shop shop = it.next();
            shop.printShopInfo();
            for (int i = 0; i < shop.nomenclature; i++)
                shop.products[i].printProductInfo();
            System.out.println("\n");
        }
    }
}
