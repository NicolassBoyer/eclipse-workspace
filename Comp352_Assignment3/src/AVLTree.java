
public class AVLTree<T extends Comparable<T>> implements Tree<T> {
	
	private AVLNode<T> root;
	private Sequence orderedElements;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private T getMin(AVLNode<T> AVLNode) {
		if (AVLNode.getLeftChild() != null) {
			return getMin(AVLNode.getLeftChild());
		}
		return AVLNode.getData();
	}
	
	private T getMax(AVLNode<T> AVLNode) {
		if (AVLNode.getRightChild() != null) {
			return getMax(AVLNode.getRightChild());
		}
		return AVLNode.getData();
	}
	
	private void traverseInOrder(AVLNode<T> AVLNode) {
		if (AVLNode != null) {
	        // Traverse the left subtree
	        traverseInOrder(AVLNode.getLeftChild());

	        // Visit the current node
	        orderedElements.add(AVLNode.getData());
	        System.out.println(AVLNode.getData());

	        // Traverse the right subtree
	        traverseInOrder(AVLNode.getRightChild());
	    }
	}
	
	private AVLNode<T> insert(T data, AVLNode<T> AVLNode) {
		if (AVLNode == null) {
			return new AVLNode<>(data);
		}
		if (data.compareTo(AVLNode.getData()) < 0) {
			AVLNode.setLeftChild(insert(data, AVLNode.getLeftChild()));
		} else if (data.compareTo(AVLNode.getData()) > 0) {
			AVLNode.setRightChild(insert(data, AVLNode.getRightChild()));
		} else {
			return AVLNode;
		}
		updateHeight(AVLNode);
		return applyRotation(AVLNode);
	}
	
	private AVLNode<T> delete(T data, AVLNode<T> AVLNode) {
		if (AVLNode == null) {
			return null;
		}
		if (data.compareTo(AVLNode.getData()) < 0) {
			AVLNode.setLeftChild(delete(data, AVLNode.getLeftChild()));
		} else if (data.compareTo(AVLNode.getData()) > 0) {
			AVLNode.setRightChild(delete(data, AVLNode.getRightChild()));
		} else {
			// One child of Leaf AVLNode (no children)
			if (AVLNode.getLeftChild() == null) {
				return AVLNode.getRightChild();
			} else if (AVLNode.getRightChild() == null) {
				return AVLNode.getLeftChild();
			}
			// Two Children
			AVLNode.setData(getMax(AVLNode.getLeftChild()));
			
		}
		updateHeight(AVLNode);
		return applyRotation(AVLNode);
	}
	
	private void updateHeight(AVLNode<T> AVLNode) {
		int maxHeight = Math.max(
				height(AVLNode.getLeftChild()),
				height(AVLNode.getRightChild())
		);
		AVLNode.setHeight(maxHeight + 1);
	}
	
	private int height(AVLNode<T> AVLNode) {
		return AVLNode != null ? AVLNode.getHeight() : 0;
	}
	
	private AVLNode<T> applyRotation(AVLNode<T> AVLNode) {
		int balance = balance(AVLNode);
		if (balance > 1) {
			if (balance(AVLNode.getLeftChild()) < 0) {
				AVLNode.setLeftChild(rotateLeft(AVLNode.getLeftChild()));
			}
			return rotateRight(AVLNode);
		}
		if (balance < -1) {
			if (balance(AVLNode.getRightChild()) < 0) {
				AVLNode.setRightChild(rotateRight(AVLNode.getRightChild()));
			}
			return rotateRight(AVLNode);
		}
		return AVLNode;
	}
	
	private AVLNode<T> rotateRight(AVLNode<T> AVLNode) {
		// AVLNode in this case would be the root AVLNode
		AVLNode<T> leftNode = AVLNode.getLeftChild();
		AVLNode<T> centerNode = leftNode.getRightChild();
		leftNode.setRightChild(AVLNode);
		AVLNode.setLeftChild(centerNode);
		updateHeight(AVLNode);
		updateHeight(leftNode);
		return leftNode; // Left AVLNode is now root AVLNode
	}
	
	public AVLNode<T> rotateLeft(AVLNode<T> AVLNode) {
		AVLNode<T> rightNode = AVLNode.getRightChild();
		AVLNode<T> centerNode = rightNode.getLeftChild();
		rightNode.setLeftChild(AVLNode);
		AVLNode.setRightChild(centerNode);
		updateHeight(AVLNode);
		updateHeight(rightNode);
		return rightNode;
	}
	// do inorder traversal and then delete 
	private AVLNode<T> findAt(AVLNode<T> AVLNode, int nodeNum, int index) {
		if (AVLNode != null) {
	        // Traverse the left subtree
	        AVLNode<T> leftResult = findAt(AVLNode.getLeftChild(), nodeNum, index);
	        if (leftResult != null) {
	            return leftResult; // Node found in the left subtree
	        }
	        
	        index++;

	        // Visit the current node
	        if (nodeNum == index) {
	            System.out.println(AVLNode.getData());
	            return AVLNode; // Node found at the current position
	        }
	        index++;

	        // Traverse the right subtree
	        AVLNode<T> rightResult = findAt(AVLNode.getRightChild(), nodeNum, index);
	        if (rightResult != null) {
	            return rightResult; // Node found in the right subtree
	        }
	        index++;
	    }
	    
	    return null; // Node not found
	}
	
	private int balance(AVLNode<T> AVLNode) {
		return AVLNode != null
				? height(AVLNode.getLeftChild()) - height(AVLNode.getRightChild())
				: 0;
	}

	@Override
	public Tree<T> insert(T data) {
		if (isEmpty()) {
			root = new AVLNode<>(data);
		} else {
			insert(data, root);
		}
		return this;
	}

	@Override
	public void delete(T data) {
		root = delete(data, root);
	}
	
	public AVLNode<T> findAt(int key) {
		AVLNode<T> foundData = findAt(key);
	}

	@Override
	public T getMax() {
		if (isEmpty() ) {
			return null;
		}
		return getMax(root);
	}

	@Override
	public T getMin() {
		if (isEmpty()) {
			return null;
		}
		return getMin(root);
	}
	
	@Override
	public Sequence traverse() {
		orderedElements = new Sequence();
		traverseInOrder(root);
		return orderedElements;
	}
}
