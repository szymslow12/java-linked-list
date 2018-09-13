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
            System.out.print(newNode.getValue() + " - " + parent.getValue());
            if (newNode.getValue() <= parent.getValue()) {
                System.out.print(" LEFT ");
                if (parent.leftNode() == null) {
                    System.out.println(true);
                    parent.setLeftNode(newNode);
                    return;
                } else {
                    System.out.println(false);
                    parent = parent.leftNode();
                }
            } else {
                System.out.print(" RIGHT");
                if (parent.rightNode() == null) {
                    System.out.println(true);
                    parent.setRightNode(newNode);
                    return;
                } else {
                    System.out.println(false);
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
        int middleIndex = Math.abs(intArray.length / 2);
        Integer rootValue = intArray[middleIndex];
        bsn.add(rootValue);
        for (Integer number: intArray) {
            bsn.add(number);
        }
        return bsn.minimalHeight();
    }


    public static void main(String[] args) {
        Integer[] intArray = {5, 1, 3, 5, 0, 1, 2, 3,4 ,5 ,6 ,7 ,8};
        System.out.println(minimalHeight(intArray));
    }
}
