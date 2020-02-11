package com.tylersimmonsdev.dbutil;

public class QueryPair<T, E> {
    private T key;
    private E value;

    public QueryPair(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
