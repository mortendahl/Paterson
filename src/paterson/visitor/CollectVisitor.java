package paterson.visitor;

import java.util.*;

public class CollectVisitor extends BinaryTreeVisitor {
	
	private List<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
	
	public List<BinaryTreeNode> getCollectedNodes() {
		return nodes;
	}
	
	@Override
	public void visit(BinaryTreeNode node) {
		nodes.add(node);
	}

}
