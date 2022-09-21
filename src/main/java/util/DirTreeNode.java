package main.java.util;

public class DirTreeNode {

    private final String data;
    private DirTreeNode next;

    public DirTreeNode(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public DirTreeNode getNext() {
        return next;
    }

    public void setNext(DirTreeNode next) {
        this.next = next;
    }
}