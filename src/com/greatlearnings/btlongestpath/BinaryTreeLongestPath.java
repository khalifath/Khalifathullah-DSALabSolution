package com.greatlearnings.btlongestpath;

import java.util.LinkedList;

class BinaryTreeLongestPath {

	static class Node {
		Node left;
		Node right;
		int data;
	};

	static Node createNode(int data){
		Node node = new Node();

		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}


	public static LinkedList<Integer> longPath(Node root){

		if(root == null) {
			LinkedList<Integer> result = new LinkedList<>();
			return result;
		}

		LinkedList<Integer> rightNode = longPath(root.right);
		LinkedList<Integer> leftNode = longPath(root.left);

		if(rightNode.size() < leftNode.size()){
			leftNode.add(root.data);
		}
		else {
			rightNode.add(root.data);
		}

		if (leftNode.size() > rightNode.size()) return leftNode;
		else return rightNode;
	}  

	public static void main(String[] args) {

		Node root = createNode(100);	
		root.left = createNode(20);
		root.right = createNode(130);
		root.left.left = createNode(10);
		root.left.left.left = createNode(5);
		root.left.right= createNode(50);
		root.right.left=createNode(110);
		root.right.right=createNode(140);
		//root.right.right.right=createNode(240);
		//root.right.right.right.right=createNode(540);

		LinkedList<Integer> ll_longpath = longPath(root);
		int llSize = ll_longpath.size();
		//System.out.println("linkedlist size :" + llSize);
		//System.out.print(ll_longpath.get(llSize - 1));

		for(int i = llSize - 1; i >= 0; i--){
			if(i==llSize-1)
				System.out.print(ll_longpath.get(i));
			else
				System.out.print(" -> " + ll_longpath.get(i));
		}
	}
}
