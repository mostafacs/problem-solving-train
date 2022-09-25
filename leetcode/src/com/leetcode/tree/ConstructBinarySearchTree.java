package com.leetcode.tree;

/**
 * @author Mostafa
 * LINK https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTree {


    public static void main(String[] args) {
        TreeNode root = new ConstructBinarySearchTree().bstFromPreorder(new int[]{8,5,1,7,10,12});
        System.out.println(root);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode();
        for(int i=0; i < preorder.length; i++) {
            if(i == 0) root = new TreeNode(preorder[i]);
            else {
                putNode(root, preorder[i]);
            }
        }
        return root;
    }

    public void putNode(TreeNode node, int v) {
        if(v <= node.val) {
            if(node.left == null) {
                node.left = new TreeNode(v);
            } else {
                putNode(node.left, v);
            }
        }
        else {
            if(node.right == null) {
                node.right = new TreeNode(v);
            } else {
                putNode(node.right, v);
            }
        }
    }
}