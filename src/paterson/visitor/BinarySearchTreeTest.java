package paterson.visitor;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	BinarySearchTree tree;
	
	@Before
	public void setUp() throws Exception {
		
		BinaryTreeNode left = new BinaryTreeNode("1");
		BinaryTreeNode right = new BinaryTreeNode("3");
		BinaryTreeNode root = new BinaryTreeNode("2", left, right);
		this.tree = new BinarySearchTree(root);
		
	}
	
	@Test
	public void testSort() {
		List<BinaryTreeNode> sortedNodes = tree.collectIncreasing();
		assertEquals(sortedNodes.get(0).key, "1");
		assertEquals(sortedNodes.get(1).key, "2");
		assertEquals(sortedNodes.get(2).key, "3");
	}

}
