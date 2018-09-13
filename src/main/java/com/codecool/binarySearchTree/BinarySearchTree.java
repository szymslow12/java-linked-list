package com.codecool.binarySearchTree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }


    public void add(Integer value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        if (value <= root.getValue()) {
            Node leftSiteOfRoot = root.leftNode();
            if (leftSiteOfRoot == null)
                root.setLeftNode(newNode);
            addNodeToProperParent(leftSiteOfRoot, newNode);
        } else {
            Node rightSiteOfRoot = root.rightNode();
            if (rightSiteOfRoot == null)
                root.setRightNode(newNode);
            addNodeToProperParent(rightSiteOfRoot, newNode);
        }
    }

    public void addNodeToProperParent(Node parent, Node newNode) {
        while (parent != null) {
            if (newNode.getValue() <= parent.getValue()) {
                if (parent.leftNode() == null) {
                    parent.setLeftNode(newNode);
                    return;
                } else {
                    parent = parent.leftNode();
                }
            } else {
                if (parent.rightNode() == null) {
                    parent.setRightNode(newNode);
                    return;
                } else {
                    parent = parent.rightNode();
                }
            }
        }
    }

    public int minimalHeight() {
        return minimalHeight(root);
    }


    public int minimalHeight(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.leftNode() == null && root.rightNode() == null) {
            return 1;
        }

        if (root.leftNode() == null) {
            return minimalHeight(root.rightNode()) + 1;
        }

        if (root.rightNode() == null) {
            return minimalHeight(root.leftNode()) + 1;
        }
        return Math.min(minimalHeight(root.leftNode()),
                minimalHeight(root.rightNode())) + 1;
    }


    public static int minimalHeight(Integer[] intArray) {
        BinarySearchTree bsn = new BinarySearchTree();
        for (Integer number: intArray) {
            bsn.add(number);
        }
        return bsn.minimalHeight();
    }


    public static void main(String[] args) {
        Integer[] intArray = {5, 1};
        System.out.println(minimalHeight(intArray));
    }
}
