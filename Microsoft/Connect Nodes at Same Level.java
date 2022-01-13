//User function Template for Java

 /*
    Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    */
    
class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        // Your code goes here.
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0; i<sz; i++){
                Node nd=q.peek();
                q.remove();
                
                if(i == sz-1){
                    nd.nextRight=null;
                }else if(i < sz-1){
                    nd.nextRight =q.peek();
                }
                
                if(nd.left != null){
                    q.add(nd.left);
                }
                if(nd.right != null){
                    q.add(nd.right);
                }
            }
        }
    }
}
