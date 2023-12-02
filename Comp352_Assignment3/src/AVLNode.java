

//@Data
public class AVLNode<T extends Comparable<T>> {
	private T data;
	private int height = 1;
	private AVLNode<T> leftChild;
	private AVLNode<T> rightChild;
	
	public AVLNode(T data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.height = 1;
	}
	
	public AVLNode<T> getRightChild() {
		return rightChild;
	}
	
	public AVLNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setRightChild(AVLNode<T> child) {
		this.rightChild = child;
	}
	
	public void setLeftChild(AVLNode<T> child) {
		this.leftChild = child;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
}
