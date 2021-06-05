package eg.edu.alexu.csd.filestructure.redblacktree;



public class main {

	public static void main(String[] args) {
		
		RedBlackTree rbt = new RedBlackTree ();
		
	/*	rbt.insert(8, 100);
		rbt.insert(18, 100);
		rbt.insert(5, 100);
		rbt.insert(15, 100);
		rbt.insert(17, 100);
		rbt.insert(25, 100);
		rbt.insert(40, 100);
		rbt.insert(80, 100);*/
		
		/*rbt.insert(41, 100);
		rbt.insert(38, 100);
		rbt.insert(31, 100);
		rbt.insert(12, 100);
		rbt.insert(19, 100);
		rbt.insert(8, 100);*/
		
		rbt.insert(15, 100);
		rbt.insert(20, 100);
		rbt.insert(5, 100);
		rbt.insert(10, 100);
		rbt.insert(8, 100);
		rbt.insert(14, 100);
		rbt.insert(9, 100);
		rbt.insert(13, 100);
		
		
		
		/*rbt.insert(10, 100);
		rbt.insert(31, 100);
		rbt.insert(12, 100);
		rbt.insert(20, 100);
		rbt.insert(8, 100);
		rbt.insert(21, 100);
		rbt.insert(4, 100);*/
		rbt.printInorder(rbt.getRoot());
		System.out.println("");
		System.out.println(rbt.getRoot().getKey());
		

	}

}
