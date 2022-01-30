/*Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class Solution{
    public int sumTree(Node root){
        if(root == null){
            return 0;
        }
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        
        int val = root.data;
        root.data = left+right;
        
        return root.data+val;
    }
    public void toSumTree(Node root){
         //add code here.
         int x=sumTree(root);
    }
}
