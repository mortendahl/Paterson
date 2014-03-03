package paterson.visitor;

public abstract class BinaryTree {
	
	BinaryTreeNode root;
	
	public BinaryTree() {}
	
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public BinaryTreeNode getRoot() {
		return root;
	}
	
	public void preorderWalk(BinaryTreeVisitor visitor, BinaryTreeNode node) {
		
		// visit left child
		if (node.left != null) {
			visitor.goingLeft();
			preorderWalk(visitor, node.left);
			visitor.goingUp();
		}
		
		// visit node
		visitor.visit(node);
		
		// visit right node
		if (node.right != null) {
			visitor.goingRight();
			preorderWalk(visitor, node.right);
			visitor.goingUp();
		}
	}
	
	public void inorderWalk(BinaryTreeVisitor visitor, BinaryTreeNode node) {
		
		// visit node
		visitor.visit(node);
		
		// visit left child
		if (node.left != null) {
			visitor.goingLeft();
			inorderWalk(visitor, node.left);
			visitor.goingUp();
		}
		
		// visit right node
		if (node.right != null) {
			visitor.goingRight();
			inorderWalk(visitor, node.right);
			visitor.goingUp();
		}
	}
	
	public void postorderWalk(BinaryTreeVisitor visitor, BinaryTreeNode node) {
		
		// visit left child
		if (node.left != null) {
			visitor.goingLeft();
			postorderWalk(visitor, node.left);
			visitor.goingUp();
		}
		
		// visit right node
		if (node.right != null) {
			visitor.goingRight();
			postorderWalk(visitor, node.right);
			visitor.goingUp();
		}
		
		// visit node
		visitor.visit(node);
	}
	
}
