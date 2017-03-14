package treeeeeee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {

	public void inorderT(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderT(root.left);
		System.out.print(root.key + " ");
		inorderT(root.right);
	}

	public List<Integer> inOrderDFS(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode node = root;
		DFS1(res, node);
		return res;
	}

	private void DFS1(List<Integer> res, TreeNode node) {
		if (node == null) {
			return;
		}

		DFS1(res, node.left);
		res.add(node.key);
		DFS1(res, node.right);
	}

	public void getTreeDeepth() {

	}

	public void StackinOrderT(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.key + " ");
			if (node.right != null) {
				node = node.right;
				// System.out.print(node.key+" ");
				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
		// for (TreeNode x : stack) {
		// System.out.println(x.key);
		// }
		// System.out.println("------1-----");
		//
		// while (!stack.empty()) {
		// System.out.println(stack.pop().key);
		// }
		// System.out.println("------2-----");
		//
		// System.out.println(stack.isEmpty());
		// for(int i=0;i<3;i++){
		//
		// }
	}

	public List<List<Integer>> levelOrderT(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				level.add(curr.key);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			res.add(level);
		}
		Collections.reverse(res);
		return res;
	}

	
	public List<Integer> preOrderT(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		TreeNode node=root;
		
		DFS2(node,res);
		return res;
	}

	private void DFS2(TreeNode node, List<Integer> res) {
		if(node==null){
			return;
		}
		res.add(node.key);
		DFS2(node.left,res);
		DFS2(node.right,res);
	}

	public List<Integer> preOrderStack(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return null;
		List<Integer> res=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);
		TreeNode node=root;
		while(!stack.isEmpty()){
			if(node!=null){
				stack.add(node);
				for(int i=0;i<stack.size();i++){
					System.out.print(stack.get(i).key+" ");
				}
				System.out.println();
				res.add(node.key);
				node=node.left;
			}else if(node==null){
				node=stack.pop();
				node=node.right;
			}
		}
		return res;
	}

	public boolean hasPathSum(TreeNode root, int sum) {

		TreeNode node=root;
		System.out.println("sum= "+sum);
		if(node==null){
			return false;
		}
		else if(node.left==null&&node.right==null&&node.key==sum){
			return true;
		}
//		return (hasPathSum(node.left,sum-node.key)||hasPathSum(node.right,sum-node.key));
		boolean res1=hasPathSum(node.left,sum-node.key);
		boolean res2=hasPathSum(node.right,sum-node.key);
		return (res1||res2);
	}

}





