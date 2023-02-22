package org.example.list;

public interface ListInterface <E> {
    // Create
    public void add(int index, E element);
    public void append(E element);

    // Read
    public E get(int index);
    public int indexOf(E element);

    // Update
    public void set(int index, E element);

    // Delete
    public E remove(int index);
    public boolean removeItem(E element);

    // Extra Functions
    public int len();
    public boolean isEmpty();
    public void clear();
}
