import java.util.*;

public class LeaseCommonAncestor {
	Node root;
	List<Integer> path1=new ArrayList<Integer>();
	List<Integer> path2=new ArrayList<Integer>();
	
	int findLCA(int node1,int node2){
		path1.clear();
		path2.clear();
		return findLCAInternal(root, node1, node2);
		
		}
	
	int findLCAInternal(Node root,int node1,int node2) {
		
		if(!findPath(root, node1, path1)||!findPath(root, node2, path2)) {
					
			System.out.println(path1.size()>0?"node1 is present":"node1 is missing");
			System.out.println(path2.size()>0?"node2 is present":"node2 is missing");
			return -1;
		}
		
		System.out.println("Path1:"+path1);
		System.out.println("Path2:"+path2);
		int i;
		for(i=0;i<path1.size()&&i<path2.size();i++ ) {
			
			if(!path1.get(i).equals(path2.get(i)))
					break;
		}
		return path1.get(i-1);
		
		
	}
	
	
	//[10,20]
	boolean findPath(Node root,int n,List<Integer> path){
	  //base case
		if(root==null)
			return false;
		
		path.add(root.data);
		
		if(root.data==n)
		return true;
		
		if(root.left!=null&& findPath(root.left, n, path))
				return true;
		if(root.right!=null && findPath(root.right, n, path))
			return true;
		
		// When no node path available
		path.remove(path.size()-1);
		
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		LeaseCommonAncestor tree=new LeaseCommonAncestor();
		
		tree.root=new Node(10);
		
		tree.root.left=new Node(20);
		tree.root.right=new Node(30);
		tree.root.left.left=new Node(40);
		tree.root.left.right=new Node(50);
		
		tree.root.right.left=new Node(60);
		tree.root.right.right=new Node(70);
		
		int node1,node2;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please enter node1");
		node1=scanner.nextInt();
		System.out.println("Please enter node2");
		node2=scanner.nextInt();
				int lca=tree.findLCA(node1,node2);
				System.out.println("Lease Common Ancestor:"+lca);
				
				scanner.close();
		
		
	}

}
