package paterson.visitor;

import java.util.*;

public class BinarySearchTree extends BinaryTree {
	
	public BinarySearchTree(BinaryTreeNode root) {
		super(root);
	}
	
	public List<BinaryTreeNode> collectIncreasing() {
		CollectVisitor visitor = new CollectVisitor();
		this.preorderWalk(visitor, this.getRoot());
		return visitor.getCollectedNodes();
	}
	
	public List<BinaryTreeNode> collectDecreasing() {
		CollectVisitor visitor = new CollectVisitor();
		this.postorderWalk(visitor, this.getRoot());
		return visitor.getCollectedNodes();
	}
	
	public void printTree() {
		BinaryTreeVisitor visitor = new BinaryTreeVisitor() {
			private int indentLevel = 0;  // FIXME
			
			@Override
			public void goingUp() {
				indentLevel--;
			}
			
			@Override
			public void goingLeft() {
				indentLevel++;
			}
			
			@Override
			public void goingRight() {
				indentLevel++;
			}
			
			@Override 
			public void visit(BinaryTreeNode node) {
				System.out.println(node);
			}
		};
		this.inorderWalk(visitor, this.getRoot());
	}
	
}
