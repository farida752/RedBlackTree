package eg.edu.alexu.csd.filestructure.redblacktree;

public class Node implements INode{
	private INode parent, left,right;
	private Comparable key;
	private Object value;
	private boolean color;
	Node(){
		parent=null;
		left=null;
		right=null;
		color=RED;
		key=null;
		value=null;
	}
	@Override
	public void setParent(INode parent) {
		this.parent=parent;
		
	}

	@Override
	public INode getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	@Override
	public void setLeftChild(INode leftChild) {
		this.left=leftChild;
		
	}

	@Override
	public INode getLeftChild() {
		return this.left;
	}

	@Override
	public void setRightChild(INode rightChild) {
		this.right=rightChild;
		
	}

	@Override
	public INode getRightChild() {

		return this.right;
	}

	@Override
	public Comparable getKey() {

		return this.key;
	}

	@Override
	public void setKey(Comparable key) {
		this.key=key;
		
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public void setValue(Object value) {
		this.value=value;
		
	}

	@Override
	public boolean getColor() {
		return this.color;
	}

	@Override
	public void setColor(boolean color) {
		this.color=color;
		
	}

	@Override
	public boolean isNull() {
		
		return key==null;
	}

}
