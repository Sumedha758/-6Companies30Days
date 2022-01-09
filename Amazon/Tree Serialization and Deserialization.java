/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/

class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    Queue<Node> q=new LinkedList<>();
	    q.add(root);
	    while(!q.isEmpty()){
	        Node nd=q.peek();
	        q.remove();
	        if(nd == null){
	            A.add(-1);
	            continue;
	        }
	        A.add(nd.data);
	        q.add(nd.left);
	        q.add(nd.right);
	    }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        // System.out.println(A);
        Queue<Node> q=new LinkedList<>();
        Node t=new Node(A.get(0));
        q.add(t);
        for(int i=1; i<A.size(); i++){
            Node nd=q.peek();
            q.remove();
            if(A.get(i) != -1){
                Node lft=new Node(A.get(i));
                nd.left=lft;
                q.add(lft);
            }
            i++;
            if(A.get(i) != -1){
                Node rt=new Node(A.get(i));
                nd.right=rt;
                q.add(rt);
            }
        }
        return t;
    }
};
