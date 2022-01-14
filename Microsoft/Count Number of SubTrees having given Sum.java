/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/


class Tree
{
    //Function to count number of subtrees having sum equal to given sum.
    int count(Node root, ArrayList<Integer> k){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            k.add(root.data);
            return root.data;
        }
        
        int l=count(root.left, k);
        int r=count(root.right, k);
        
        k.add(root.data+l+r);
        
        return root.data+l+r;
    }
    int countSubtreesWithSumX(Node root, int X)
    {
	    //Add your code here.
	    ArrayList<Integer> l=new ArrayList<>();
	    
	    int y=count(root, l);
	    
	    int cnt=0;
	    for(int i=0; i<l.size(); i++){
	        if(l.get(i) == X){
	            cnt++;
	        }
	    }
	    
	    return cnt;
    }
}

