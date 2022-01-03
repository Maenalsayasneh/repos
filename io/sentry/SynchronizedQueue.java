package io.sentry;

import java.util.Queue;
/* loaded from: classes4.dex */
public final class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 1;

    private SynchronizedQueue(Queue<E> queue) {
        super(queue);
    }

    public static <E> SynchronizedQueue<E> synchronizedQueue(Queue<E> queue) {
        return new SynchronizedQueue<>(queue);
    }

    @Override // java.util.Queue
    public E element() {
        E element;
        synchronized (this.lock) {
            element = decorated().element();
        }
        return element;
    }

    @Override // io.sentry.SynchronizedCollection, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            equals = decorated().equals(obj);
        }
        return equals;
    }

    @Override // io.sentry.SynchronizedCollection, java.util.Collection, java.lang.Object
    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = decorated().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        boolean offer;
        synchronized (this.lock) {
            offer = decorated().offer(e);
        }
        return offer;
    }

    @Override // java.util.Queue
    public E peek() {
        E peek;
        synchronized (this.lock) {
            peek = decorated().peek();
        }
        return peek;
    }

    @Override // java.util.Queue
    public E poll() {
        E poll;
        synchronized (this.lock) {
            poll = decorated().poll();
        }
        return poll;
    }

    @Override // java.util.Queue
    public E remove() {
        E remove;
        synchronized (this.lock) {
            remove = decorated().remove();
        }
        return remove;
    }

    public SynchronizedQueue(Queue<E> queue, Object obj) {
        super(queue, obj);
    }

    @Override // io.sentry.SynchronizedCollection
    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }
}
