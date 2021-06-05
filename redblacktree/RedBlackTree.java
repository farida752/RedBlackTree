package eg.edu.alexu.csd.filestructure.redblacktree;

public class RedBlackTree implements IRedBlackTree{
	
	static final boolean RED   = true;
    static final boolean BLACK = false;
	public INode root;
	private int size;
	public INode nill;
	
	public RedBlackTree(){
		this.size=0;
		this .nill = new Node();
		nill.setColor(BLACK);
		this.root=nill;
	}
	public void setRoot(INode r) {
		this.root=r;
	}
	@Override
	public INode getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public void clear() {
		this.root=null;
		
	}

	@Override
	public Object search(Comparable key) {
		INode curr = root;
		while(curr!=nill) {
			int comp=curr.getKey().compareTo(key);			
			if(comp<0) { // key > curr
				curr=curr.getRightChild();
			}
			else if(comp>0) { //key < curr
				curr=curr.getLeftChild();
			}
			else { // key is found
				return curr.getValue();
			}
		}
		return nill; //key not found
	}

	@Override
	public boolean contains(Comparable key) {
		return search(key)!= nill;
	}
	
	private void LeftRotate(INode node) {
		INode y = (INode) node.getRightChild();
		node.setRightChild(y.getLeftChild());
		if (y.getLeftChild() != nill) {
			y.getLeftChild().setParent(node);
		}
		y.setParent(node.getParent());
		if (node.getParent() == nill) {
			root = y;
		} else if (node == node.getParent().getLeftChild()) {
			node.getParent().setLeftChild(y);
		} else {
			node.getParent().setRightChild(y);
		}
		y.setLeftChild(node);
		node.setParent(y);

	}

	private void RightRotate(INode node) {
		INode x = (INode) node.getLeftChild();
		node.setLeftChild(x.getRightChild());
		if (x.getRightChild() != nill) {
			x.getRightChild().setParent(node);
		}
		x.setParent(node.getParent());
		if (node.getParent() == nill) {
			root = x;
		} else if (node == node.getParent().getRightChild()) {
			node.getParent().setRightChild(x);
		} else {
			node.getParent().setLeftChild(x);
		}
		x.setRightChild(node);
		node.setParent(x);

	}

	@Override
	public void insert(Comparable key, Object value) {
		//if the key doesn't exists in the tree insert
		if(!contains(key)) {
			size++;
		//create a node with the given key and value
		INode node = new Node();
		node.setKey(key);
		node.setValue(value);
		node.setLeftChild(nill);
		node.setRightChild(nill);
		node.setParent(nill);
	
		//if it is the first node to be inserted
		if(root == nill) {
			root = node;
			root.setColor(BLACK);
		}else {  	//insert the node in the correct place in the tree
		insertRecursive(root,node);
		//if the parent of the current node is red then fix the balance of the RB tree
		 while (node.getParent().getColor() == RED ) { 
			 INode z=insertFix(node);
			 node=z;
		}
		}}
		
	}
	public INode insertRecursive(INode currentRoot,INode node) {
		 if (currentRoot == nill) { 
			 currentRoot = node; 
	            return currentRoot; 
	        } 
	        //traverse the tree
	        if ((int)node.getKey() < (int)currentRoot.getKey())  {   //insert in the left subtree
	        	
	        			INode temp=insertRecursive(currentRoot.getLeftChild(), node);
	        			currentRoot.setLeftChild(temp);
	        			temp.setParent(currentRoot);
	        }
	        
	        else if ((int)node.getKey() > (int)currentRoot.getKey()) {    //insert in the right subtree
	       
	        		INode temp = insertRecursive(currentRoot.getRightChild(), node);
	        		 currentRoot.setRightChild(temp);
	        		 temp.setParent(currentRoot);
	        
	           
	        }
	          // return pointer
	        return currentRoot; 	
	}
	
	public INode insertFix(INode z) { // z is the new inserted node 
		INode pOfz= z.getParent(); // pOfz parent of z =p[z]
		INode ppOfz= pOfz.getParent(); //ppOfz is pp[z]
		
		INode y ; //uncle of z
		if (ppOfz.getLeftChild()==pOfz) {
			y=ppOfz.getRightChild();
		}else {
			y=ppOfz.getLeftChild();
		}
	
		
		if (y.getColor() == RED) { //case 1 recursive recolor
			pOfz.setColor(BLACK); //recolor the parent and the uncle
			y.setColor(BLACK);
			if (ppOfz.getColor() == BLACK ) { 
				//recolor the grand parent to red 
				ppOfz.setColor(RED);}
			
			z=ppOfz;
		}
		// uncle y is black so case 2 or case 3
		else {
			
			if (pOfz.getRightChild()==z && ppOfz.getLeftChild()== pOfz)  { //transfer case 2 to case 3 z(right) p[z](left)
				LeftRotate(pOfz);
				z=z.getLeftChild();
				pOfz= z.getParent(); // pOfz parent of z =p[z]
			    ppOfz= pOfz.getParent();
			}
			else if (pOfz.getLeftChild()==z && ppOfz.getRightChild()== pOfz) { //transfer case 2 to case 3 z(left) p[z](right)
				RightRotate(pOfz);
				z=z.getRightChild();
				pOfz= z.getParent(); // pOfz parent of z =p[z]
			    ppOfz= pOfz.getParent();
			}
			
			pOfz.setColor(BLACK); // fix case 3
			if(ppOfz.getColor()==BLACK) {
				ppOfz.setColor(RED);
			}else {ppOfz.setColor(BLACK);}
			
			if (pOfz.getLeftChild()==z && ppOfz.getLeftChild()== pOfz)  { //case 3 left left 
			RightRotate(ppOfz); }
			else if  (pOfz.getRightChild()==z && ppOfz.getRightChild()== pOfz) { // case 3 right right
				LeftRotate(ppOfz);
			}
			

			
		}
		if (root.getColor()==RED) {
			root.setColor(BLACK);
		}
		return z;
	}

	@Override
	public boolean delete(Comparable key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	void printInorder(INode root)
    {
        if (root == nill)
            return;
 
        /* first recur on left child */
        printInorder(root.getLeftChild());
 
        /* then print the data of node */
        System.out.print(root.getKey() + "," + root.getColor() + "  " );
 
        /* now recur on right child */
        printInorder(root.getRightChild());
    }
}
