package treeeeeee;

//import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Current;

public class BST {

	TreeNode root;

	public void addNode(int key, String name) {
		TreeNode newnode = new TreeNode(key,name);
		if (root == null) {
			root = newnode;
		} else {
			TreeNode focus = root;
//			TreeNode parent;
			while (focus != null) {
				if (newnode.key < focus.key) {
					if (focus.left == null) {
						focus.left = newnode;
						return;
					} else {
						focus = focus.left;
					}
				}else if(newnode.key>focus.key){
					if(focus.right==null){
						focus.right = newnode;
						return;
					}else{
						focus = focus.right;
					}
				}
			}

		}
	}
	
	public TreeNode findNode(int key){
		TreeNode curr=root;
		while(curr!=null){
			if(key<curr.key){
				curr=curr.left;
			}else if(key>curr.key){
				curr=curr.right;
			}else{
				return curr;
			}
		}
	
		return null;
	}
	
	public boolean deleteNode(int key){
		
		TreeNode parent=root;
		TreeNode curr=root;
		boolean isLeftChild=true;
//		System.out.println("curr.key ="+curr.key);
		
		while(curr.key!=key){
			parent=curr;
//			System.out.println("curr.key ="+curr.key);
			if(curr.key>key){
				isLeftChild=true;
				curr=curr.left;
			}else if(curr.key<key){
				isLeftChild=false;
				curr=curr.right;
			}if(curr==null){
				return false;
			}
		}
		
		if(curr.left==null&&curr.right==null){
			if(curr==root){
				root=null;
			}else{
				if(isLeftChild){
					parent.left=null;
				}else{
					parent.right=null;
				}
			}
//		Current.left!=null
		}else if(curr.right==null){
			parent.left=curr.left;
		}else if(curr.left==null){
			parent.right=curr.right;
		}
		
		System.out.println("parent.key= "+parent.key);
		System.out.println("curr.key= "+curr.key);
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bt=new BST();
		TreeTraverse tt=new TreeTraverse();
		
		TreeNode node1=new TreeNode(3,"yangyang");
		TreeNode node2=new TreeNode(10,"xiaohua");
		TreeNode node3=new TreeNode(1,"gou");
		TreeNode node4=new TreeNode(5,"aixia");
		TreeNode node5=new TreeNode(11,"sile");
		TreeNode node6=new TreeNode(0,"huole");
		TreeNode node7=new TreeNode(2,"nvtewu");
		
		bt.addNode(node1.key,node1.name);
		bt.addNode(node2.key,node2.name);
		bt.addNode(node3.key,node3.name);
		bt.addNode(node4.key,node4.name);
		bt.addNode(node5.key,node5.name);
		bt.addNode(node6.key,node6.name);
		bt.addNode(node7.key,node7.name);
		
		System.out.println(tt.hasPathSum(bt.root,6));
 
//		System.out.println("BEFORE---------------");
//		System.out.println(bt.root.key);
//		System.out.println(bt.root.right.key);
//		System.out.println(bt.root.right.right.key);
//		
//		System.out.println(bt.deleteNode(10));
//		System.out.println("AFTER----------------");
//		System.out.println(bt.root.key);
//		System.out.println(bt.root.right.key);
//		System.out.println(bt.root.right.right);
		
//		List<Integer> res=tt.preOrderStack(bt.root);
//		
//		for(int i=0;i<res.size();i++){
//			System.out.print(res.get(i)+" ");
//		}
		
//		List<Integer> res=tt.preOrderT(bt.root);
//		for(int i=0;i<res.size();i++){
//			System.out.print(res.get(i)+" ");
//		}
		
//		System.out.print(bt.deleteNode(11));
		
//		List<Integer> res=tt.inOrderDFS(bt.root);
//		for(int i=0;i<res.size();i++){
//			System.out.print(res.get(i)+" ");
//		}
		
//		tt.StackinOrderT(bt.root);
		
//		List<List<Integer>> res=tt.levelOrderT(bt.root);
//		for(int i=0;i<res.size();i++){
//			System.out.println(res.get(i));
//		}
		
//		tt.inorderT(bt.root);
//		bt.inorderT(bt.root);
		
//		TreeNode res=bt.findNode(11);
//		System.out.println(res.name);
		
//		System.out.println("root.key= "+bt.root.key);
//		System.out.println("root.left.key= "+bt.root.left.key);
//		System.out.println("root.right.key= "+bt.root.right.key);
//		System.out.println("root.right.left.key= "+bt.root.right.left.key);
//		System.out.println("root.left.left.key= "+bt.root.left.left.key);
//		System.out.println("root.left.left.left.key= "+bt.root.left.left.left.key);
	}

}
