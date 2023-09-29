package com.company;

public class Queue {
    private  int[] array;
    private int size;
    private int beginning;
    private int end;

    public Queue(int size) {
        this.array = new int[size];
        this.beginning = -1;
        this.end = -1;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (this.size == array.length) {
            return true;
        }

        return false;
    }

    public void enqueue(int value) {
        if (this.isFull()) {
            throw new IndexOutOfBoundsException("The queue is full!");
        }

        if (this.isEmpty()) {
            this.beginning = 0;
            this.end = 0;
        } else {
            if (this.end + 1 == this.array.length) {
                this.end = 0;
            } else {
                this.end++;
            }
        }

        this.array[this.end] = value;
        this.size++;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty!");
        }

        int value = this.array[this.beginning];
        this.array[this.beginning] = Integer.MIN_VALUE;
        this.beginning++;

        if (this.beginning > this.end) {
            this.beginning = -1;
            this.end = -1;
        } else if (this.beginning == this.array.length) {
            this.beginning = 0;
        }

        this.size--;
        return value;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty!");
        }

        return this.array[this.beginning];
    }

    public void delete() {
        this.array = null;
        this.size = 0;
        this.beginning = -1;
        this.end = -1;
    }
}
