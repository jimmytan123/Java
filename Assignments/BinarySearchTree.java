               //Zhixi Tan
//V00821283



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree extends AbstractBinaryTree {

	private TreeNode root;

	/**
	 * Creates an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	protected TreeNode getRoot() {
		return root;
	}

	protected void setRoot(TreeNode root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void makeEmpty() {
		root = null;
	}

	public void insert(PatientMedRecord pm) {
		// CALL THE RECURSIVE METHOD STARTING AT THE ROOT
		root = insertItem(root, pm);
	}

	/*
	 * Private recursive method that inserts an item into a subtree rooted at r.
	 * Returns the root of the subtree that has the new element.
	 */
	private TreeNode insertItem(TreeNode r, PatientMedRecord pm) {
		// NEEDS TO BE COMPLETED.
		TreeNode newSubtree;
		if (r == null) {
			r = new TreeNode(pm, null, null);
			return r;
		}
		PatientMedRecord nodeItem = r.item;
		if (pm.getId().compareTo(nodeItem.getId()) < 0) {
			newSubtree = insertItem(r.left, pm);
			r.left = newSubtree;
			return r;
		} else {
			newSubtree = insertItem(r.right, pm);
			r.right = newSubtree;
			return r;
		}
	}

	public PatientMedRecord retrieve(String id) {
		// CALL THE RECURSIVE METHOD STARTING AT THE ROOT
		// RETURN THE ITEM IN THE TREENODE THAT IS RETURNED
		TreeNode treeNode = retrieveItem(root, id);
		if (treeNode != null)
			return treeNode.item;
		else
			return null;
	}

	/*
	 * Private recursive method that looks for item from a subtree rooted at r.
	 * The key is the Patient id number Returns the node containing the
	 * PatientMedRecord we are looking for, without removing it from the tree.
	 */
	private TreeNode retrieveItem(TreeNode r, String id) {
		// NEEDS TO BE COMPLETED.
		TreeNode treeNode;
		if (r == null) {
			treeNode = null;
		} else {
			PatientMedRecord nodeItem = r.item;
			if (id.compareTo(nodeItem.getId()) == 0) {
				treeNode = r;
			} else if (id.compareTo(nodeItem.getId()) < 0) {
				treeNode = retrieveItem(r.left, id);
			} else {
				treeNode = retrieveItem(r.right, id);
			}
		}
		return treeNode;
	}

	public void delete(String id) {
		// CALL THE RECURSIVE METHOD FROM THE ROOT
		root = this.deleteItem(root, id);
	}

	/*
	 * Private recursive method that looks for the item and then deletes that
	 * item from within the subtree rooted at r. Uses the deleteNode method and
	 * findLeftMost and deleteLeftMost method. Returns the node that is the root
	 * of the subtree that has changed.
	 */
	private TreeNode deleteItem(TreeNode r, String id) {
		TreeNode newSubtree;
		if (r == null) {
			throw new NoSuchElementException();
		} else {
			PatientMedRecord nodeItem = r.item;
			if (id.compareTo(nodeItem.getId()) == 0) {
				r = deleteNode(r);
			} else if (id.compareTo(nodeItem.getId()) < 0) {
				newSubtree = deleteItem(r.left, id);
				r.left = newSubtree;
			} else {
				newSubtree = deleteItem(r.right, id);
				r.right = newSubtree;
			}
		}
		return r;
	}

	/*
	 * Private recursive method that either deletes the current node or
	 * overwrites the item in that node with one that is easier to delete. If r
	 * is the node to delete, then one of three cases applies: 1. If r has no
	 * children, return null. 2. If r has one child, then return that child. 3.
	 * If r has two children, then it cannot be detached. In this case, look for
	 * the left-most child of its right subtree and substitute that particular
	 * item into this node, overwriting the previous item. Then delete the
	 * left-most child of r, which will either have one or two children If r is
	 * not the node to delete, recursively look for it in the appropriate
	 * subtree of r. Return the subtree either rooted at r or some other new
	 * root of this subtree.
	 */
	private TreeNode deleteNode(TreeNode r) {
		// NEEDS TO BE COMPLETED.
		if ((r.left == null) && (r.right == null)) {
			return null;
		} else if (r.left == null) {
			return r.right;
		} else if (r.right == null) {
			return r.left;
		} else {
			TreeNode replacementNode = findLeftMost(r.right);
			r.item = replacementNode.item;
			r.right = deleteLeftMost(r.right);
			return r;
		}
	}

	/*
	 * Helper method to recursively find and return the leftmost node of the
	 * subtree rooted at r.
	 */
	private TreeNode findLeftMost(TreeNode r) {
		// NEEDS TO BE COMPLETED.
		if (r.left == null) {
			return r;
		} else {
			return findLeftMost(r.left);
		}
	}

	/*
	 * Helper method that recursively looks for, then deletes the left most node
	 * from the root of the subtree at r. Returns the subtree rooted at r or the
	 * new subtree if r is the one to remove.
	 */
	private TreeNode deleteLeftMost(TreeNode r) {
		// NEEDS TO BE COMPLETED
		if (r.left == null) {
			return r.right;
		} else {
			r.left = deleteLeftMost(r.left);
			return r;
		}
	}

	public Iterator<PatientMedRecord> preorderIterator() {
		return new BinaryTreeIterator(root, -1);
	}

	public Iterator<PatientMedRecord> inorderIterator() {
		return new BinaryTreeIterator(root, 0);
	}

	public Iterator<PatientMedRecord> postorderIterator() {
		return new BinaryTreeIterator(root, 1);
	}

	/**
	 * Unit tester.
	 * 
	 * @param args
	 *            Not used.
	 */
	public static void main(String[] args) {
		// NEEDS TO BE COMPLETED.
		AbstractBinaryTree tree = new BinarySearchTree();
		
		//I want to create a tree that have 8 nodes
		List<PatientMedRecord> list = new ArrayList<PatientMedRecord>();
		for (int i = 0; i < 8; i++) {
			PatientMedRecord p1 = new PatientMedRecord();
			list.add(p1);
			tree.insert(p1);
		}

		DrawableBTree dbt = new DrawableBTree(tree);
		dbt.showFrame();
		
		
		//print out the number inorder 
		System.out.println("Inorder:");
		Iterator<PatientMedRecord> iter = tree.inorderIterator();
		while (iter.hasNext()) {
			PatientMedRecord p = iter.next();
			System.out.println(p);
		}
		
        //print out the number preorder
		System.out.println("Preorder:");
		iter = tree.preorderIterator();
		while (iter.hasNext()) {
			PatientMedRecord p = iter.next();
			System.out.println(p);
		}
		
        //print out the number postorder
		System.out.println("Postorder:");
		iter = tree.postorderIterator();
		while (iter.hasNext()) {
			PatientMedRecord p = iter.next();
			System.out.println(p);
		}
		
       
	}
	
}
