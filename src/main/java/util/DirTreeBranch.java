package main.java.util;

public class DirTreeBranch {

    private final DirTreeNode head;

    public DirTreeBranch(String path) {
        this.head = new DirTreeNode(path);
    }

    public void add(int index, String data) {
        DirTreeNode node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        node.setNext(new DirTreeNode(data));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(head.getData());
        DirTreeNode tmp = head;

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            sb.append("/").append(tmp.getData());
        }

        return sb.toString();
    }
}