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
	
	public void deleteElement(int value){
		Tree current=root;
		Tree parent=root;
		
		
		if(current.left!=null && current.right!=null){
			if(current==root)
				current=null;
			else{
				if(current.value<value)
					parent.left=null;
				else
					parent.right=null;
			}
		}
		
		else if(current.left!=null && current.right==null){
			if(current==root)
				current=null;
			else{
				if(current.value<value)
					parent.left=current.right;
				else
					parent.right=current.right;
			}
		}
		
		else if(current.left==null && current.right!=null){
			if(current==root)
				current=null;
			else{
				if(current.value<value)
					parent.left=current.left;
				else
					parent.right=current.left;
			}
		}
		
		else{
			if(current==root)
				current=null;
			else{
				if(current.value<value)
					parent.right=current.left;
				else
					parent.left=current.right;
			}
		}
		
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
	}
