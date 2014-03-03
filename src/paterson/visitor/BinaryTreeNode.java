package paterson.visitor;

public class BinaryTreeNode {
	
	public BinaryTreeNode(String key) {
		this.key = key;
	}
	
	public BinaryTreeNode(String key, BinaryTreeNode left, BinaryTreeNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public String key;
	public BinaryTreeNode parent;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	@Override
	public String toString() {
		return key;
	}
	
}
