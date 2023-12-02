
public class AVLTree<T extends Comparable<T>> implements Tree<T> {
	
	private Node<T> root;
	
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private T getMin(Node<T> node) {
		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}
	
	private T getMax(Node<T> node) {
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
	}
	
	private void traverseInOrder(Node<T> node) {
		if (node != null) {
			System.out.println(node.getLeftChild());
			System.out.println(node);
			System.out.println(node.getRightChild());
		}
	}
	
	@SuppressWarnings("unused")
	private Node<T> insert(T data, Node<T> node) {
		if (node == null) {
			return new Node<>(data);
		}
		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(insert(data, node.getLeftChild()));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(insert(data, node.getRightChild()));
		} else {
			return node;
		}
		updateHeight(node);
		return applyRotation(node);
	}
	
	@SuppressWarnings("unused")
	private Node<T> delete(T data, Node<T> node) {
		if (node == null) {
			return null;
		}
		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(delete(data, node.getLeftChild()));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(delete(data, node.getRightChild()));
		} else {
			// One child of Leaf Node (no children)
			if (node.getLeftChild() == null) {
				return node.getRightChild();
			} else if (node.getRightChild() == null) {
				return node.getLeftChild();
			}
			// Two Children
			node.setData(getMax(node.getLeftChild()));
			
		}
		updateHeight(node);
		return applyRotation(node);
	}
	
	private void updateHeight(Node<T> node) {
		int maxHeight = Math.max(
				height(node.getLeftChild()),
				height(node.getRightChild())
		);
		node.setHeight(maxHeight + 1);
	}
	
	private int height(Node<T> node) {
		return node != null ? node.getHeight() : 0;
	}
	
	private Node<T> applyRotation(Node<T> node) {
		int balance = balance(node);
		if (balance > 1) {
			if (balance(node.getLeftChild()) < 0) {
				node.setLeftChild(rotateLeft(node.getLeftChild()));
			}
			return rotateRight(node);
		}
		if (balance < -1) {
			if (balance(node.getRightChild()) < 0) {
				node.setRightChild(rotateRight(node.getRightChild()));
			}
			return rotateRight(node);
		}
		return node;
	}
	
	private Node<T> rotateRight(Node<T> node) {
		// Node in this case would be the root node
		Node<T> leftNode = node.getLeftChild();
		Node<T> centerNode = leftNode.getRightChild();
		leftNode.setRightChild(node);
		node.setLeftChild(centerNode);
		updateHeight(node);
		updateHeight(leftNode);
		return leftNode; // Left node is now root node
	}
	
	public Node<T> rotateLeft(Node<T> node) {
		Node<T> rightNode = node.getRightChild();
		Node<T> centerNode = rightNode.getLeftChild();
		rightNode.setLeftChild(node);
		node.setRightChild(centerNode);
		updateHeight(node);
		updateHeight(rightNode);
		return rightNode;
	}
	
	private int balance(Node<T> node) {
		return node != null
				? height(node.getLeftChild()) - height(node.getRightChild())
				: 0;
	}

	@Override
	public Tree<T> insert(T data) {
		if (isEmpty()) {
			root = new Node<>(data);
		} else {
			insert(data, root);
		}
		return this;
	}

	@Override
	public void delete(T data) {
		root = delete(data, root);
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
	public void traverse() {
		traverseInOrder(root);
	}
}
