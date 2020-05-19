package org.learn.preparation.datastructures;

import org.learn.preparation.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node head;

    private void removeNode(int value) {
        inOrderTraversal();
        Node parent = findParent(value);
        if (parent != null) {
            Node current;
            boolean isLeftNode = true;
            if (value < parent.value) {
                current = parent.left;
            } else {
                isLeftNode = false;
                current = parent.right;
            }
            //case 1: leaf node
            if (current.left == null && current.right == null) {
                if (isLeftNode)
                    parent.left = null;
                else
                    parent.right = null;
                System.out.println("deleting leaf node");
            } else {
                //case 2: no right node
                if (current.right == null) {
                    System.out.println("case 2:");
                    if (isLeftNode)
                        parent.left = current.left;
                    else
                        parent.right = current.left;
                } else {
                    //case 3: right node has no left node
                    if (current.right.left == null) {
                        System.out.println("case 3:");
                        if (isLeftNode) {
                            parent.left = current.right;
                            parent.left.left = current.left;
                        } else {
                            parent.right = current.right;
                            parent.right.left = current.left;
                        }
                    } else {
                        System.out.println("case 4: ");
                        // case 4: right node has left node
                        // finding left mode node
                        Node leftMostNode = current.right.left;
                        Node preLeft = leftMostNode;
                        while (leftMostNode.left != null) {
                            preLeft = leftMostNode;
                            leftMostNode = leftMostNode.left;
                        }
                        preLeft.left = null;
                        leftMostNode.left = current.left;
                        leftMostNode.right = current.right;
                        if (isLeftNode) {
                            parent.left = leftMostNode;
                        } else {
                            parent.right = leftMostNode;
                        }
                    }
                }


            }
        }
        inOrderTraversal();
    }

    public Node findParent(int value) {
        Node current = head;
        Node parent = current;
        while (current != null) {
            if (value < current.value) {
                parent = current;
                current = current.left;
            } else {
                if (value > current.value) {
                    parent = current;
                    current = current.right;
                } else {
                    //System.out.println("value found " + current.value + " and parent is " + parent.value);
                    return parent;
                }
            }

        }
        return null;
    }

    public void add(int newValue) {
        Node current = head;
        if (current == null) {
            System.out.println("Added root");
            head = new Node(newValue);
        } else {
            do {
                if (current.value > newValue) {
                    if (current.left == null) {
                        Node leftNode = new Node(newValue);
                        current.left = leftNode;
                        System.out.println("added " + newValue + " on left side of " + current.value);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        Node rightNode = new Node(newValue);
                        current.right = rightNode;
                        System.out.println("added " + newValue + " on right side of " + current.value);
                        break;
                    } else {
                        current = current.right;
                    }
                }

            } while (true);
        }
    }

    public void addRecursively(int newValue) {
        addRecursively(newValue, head, null);
    }

    private void addRecursively(int newValue, Node current, Node parent) {
        if (current == null) {
            if (parent != null) {
                current = new Node(newValue);
                if (current.value < parent.value) {
                    parent.left = current;
                    System.out.println("added " + newValue + " on left side of " + parent.value);
                } else {
                    System.out.println("added " + newValue + " on right side of " + parent.value);
                    parent.right = current;
                }
            } else {
                head = new Node(newValue);
                System.out.println("head added");
            }
        } else {
            if (newValue < current.value) {
                addRecursively(newValue, current.left, current);
            } else {
                addRecursively(newValue, current.right, current);
            }
        }

    }

    public void bfs() {
        List<Node> queue = new ArrayList<>();
        queue.add(head);

        while (queue.size() > 0) {
            //pop first element
            Node node = queue.remove(0);

            //adding children in queue
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            System.out.print(node.value+" ");
        }

    }

    public void preOrderTraversal() {
        System.out.println("preOrder:");
        preOrderTraversal(head);
        System.out.println();
    }

    public void postOrderTraversal() {
        System.out.println("postOrder:");
        postOrderTraversal(head);
        System.out.println();
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            action(node);
        }
    }

    public void inOrderTraversal() {
        //System.out.println("inOrder:");
        inOrderTraversal(head);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            action(node);
            inOrderTraversal(node.right);
        }
    }

    private void action(Node node) {
        System.out.print(node.value + " ");
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            action(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addRecursively(40);
        binaryTree.addRecursively(35);
        binaryTree.addRecursively(45);
        binaryTree.addRecursively(30);
        binaryTree.addRecursively(38);
        binaryTree.addRecursively(43);
        binaryTree.addRecursively(48);

//        binaryTree.preOrderTraversal();
//        binaryTree.postOrderTraversal();
//        binaryTree.inOrderTraversal();

        binaryTree.bfs();

    }

}
