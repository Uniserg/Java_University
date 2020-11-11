package com.company.binarytree;

import java.util.Iterator;
import java.util.Stack;

enum Side {
    LEFT,
    RIGHT
}

class Node<T extends Comparable<T>> {
    public T data;
    Node<T> leftChild;
    Node<T> rightChild;
    Node<T> parent;
    Side side;

    public Node(T data) {
        this.data = data;

        if (parent == null)
            side = null;
        else {
            if (parent.leftChild == this)
                side = Side.LEFT;
            else
                side = Side.RIGHT;
        }

    }
}


public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
    public Node<T> root;

    public BinaryTree(T[] array) {
        for (T t : array) {
            add(t);
        }
    }

    public BinaryTree() {

    }

    public T getRoot() {
        return root.data;
    }

    private void add(Node<T> node) {

        if (root == null) {
            root = node;
            return;
        }

        Node<T> curNode = root;

        while (true) {
            node.parent = curNode;
            if (node.data.compareTo(curNode.data) <= 0) {
                if (curNode.leftChild == null) {
                    curNode.leftChild = node;
                    break;
                }
                curNode = curNode.leftChild;
            } else {
                if (curNode.rightChild == null) {
                    curNode.rightChild = node;
                    break;
                }
                curNode = curNode.rightChild;
            }
        }
    }

    public void add(T el) {
        add(new Node<>(el));
    }

    public void add(T[] els) {
        for (T t : els) {
            add(new Node<>(t));
        }
    }

    public boolean contains(T el) {
        Node<T> top = root;

        while (top != null) {
            int comp = el.compareTo(top.data);
            if (comp < 0)
                top = top.leftChild;
            else if (comp > 0)
                top = top.rightChild;
            else
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            final Stack<Node<T>> stack = new Stack<>();
            Node<T> top = root;

            @Override
            public boolean hasNext() {
                if (top != null) {
                    if (top.rightChild != null)
                        stack.push(top.rightChild);
                }
                return !stack.empty() || top != null;
            }

            @Override
            public T next() {
                T send = top.data;
                if (top.leftChild != null) {
                    top = top.leftChild;
                } else if (!stack.empty()) {
                    top = stack.pop();
                } else {
                    top = null;
                }
                return send;
            }
        };
    }
}
