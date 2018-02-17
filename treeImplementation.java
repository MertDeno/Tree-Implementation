import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementaionTree {

	public static Tree root;
	
	public ImplementaionTree(){
		root=null;
	}

	public void findTheElement(int value){
		Tree node=root;
		
		while(root!=null){
			if(value<node.value){
				node=node.left;
			}else if(value>node.value)
				node=node.right;
			else{
				System.out.println("Found ");
				return;
			}
		}
	}
	
	public void addElement(int value){
			
		Tree newData=new Tree(value);

		if(root==null){
			root=newData;
			return;
		}
		Tree node=root;
		Tree parent=null;
		
		while(true){
			parent=node;
			if(value==node.value){
				System.out.println("Already Exists");
				return;
			}
			if(value<node.value){
				node=node.left;
				if(node==null){
					parent.left=newData;
					return;
				}
			}
			else{
				node=node.right;
				if(node==null){
					parent.right=newData;
					return;
				}
			}
		}
	}
	
	public void breadthFirst(){
		Queue<Tree> queue=new LinkedList<Tree>();
		Tree node=root;
		
		if(node==null)
			return;
		
		queue.add(node);
		
		while(!queue.isEmpty()){
			Tree node1=(Tree)queue.remove();
			System.out.println(node1.value);
			
			if(node1.left!=null)
				queue.add(node1.left);
			
			if(node1.right!=null)
				queue.add(node1.right);			
		}
	
	}
	
	public void depthFirst() {
		Stack<Tree> stack=new Stack<Tree>();
		Tree node=root;
		stack.push(node);
		node.visited=true;
		
		while(!stack.isEmpty()) {
			Tree node1=(Tree)stack.pop();
			System.out.println(node1.value);
			
			if(node1.right!=null) {
				node1.visited=true;
				stack.push(node1.right);
			}
			
			if(node1.right==null) {
				stack.push(node.left.right);
			}
			
			if(node1.left!=null) {
				node1.visited=true;
				stack.push(node1.left);
			}
			
			else
				stack.pop();
		}
	}
															//			  20
	public void preorderPrint(Tree current){				//		   /     \
		if(current!=null){									//		 16	      27
			System.out.print(current.value+" ");			//	 	/  \	 /	\
			preorderPrint(current.left);					//	   4	18  23	 32
			preorderPrint(current.right);
		}
	}
	
	public void postorderPrint(Tree current){
		if(current!=null){											
			postorderPrint(current.left);					
			postorderPrint(current.right);
			System.out.print(current.value+" ");	
		}
	}
	
	public void inorderPrint(Tree current){
		if(current!=null){											
			inorderPrint(current.left);	
			System.out.print(current.value+" ");	
			inorderPrint(current.right);
		}
	}
	
	public Tree deleteElement(Tree node,int value){
		if(node==null)
			return null;
		
		if(value<node.value) {
			node.left=deleteElement(node.left,value);
		}	
		else if(value>node.value){
			node.right=deleteElement(node.right,value);			
		}
		
		else {
			if(node.left==null && node.right==null)
				node=null;
			else if(node.left==null)
				node=node.right;
			else if(node.right==null)
				node=node.left;
			else {
				Tree tempNode=smallestNode(node.right);
				node.value=tempNode.value;
				node.right=deleteElement(node.left,tempNode.value);
			}
		}
		return node;
	}
	
	public static void main(String[] args) {
		ImplementaionTree xyz=new ImplementaionTree();
		xyz.addElement(20);
		xyz.addElement(16);
		xyz.addElement(4);
		xyz.addElement(18);
		xyz.addElement(27);
		xyz.addElement(32);
		xyz.addElement(23);
		xyz.preorderPrint(root);
		System.out.println();
		xyz.postorderPrint(root);
		System.out.println();
		xyz.inorderPrint(root);
		xyz.findTheElement(16);
		xyz.deleteElement(4);
		System.out.println();
		xyz.inorderPrint(root);
		System.out.println();
		xyz.breadthFirst();
		xyz.depthFirst();
	}
