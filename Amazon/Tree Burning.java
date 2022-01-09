// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    public static int minTime(Node root, Map<Node, Node> m, Node t){
        Queue<Node> q=new LinkedList<>();
        Map<Node, Integer> vis=new HashMap<>();
        q.add(t);
        vis.put(t,1);
        int time=0;
        while(!q.isEmpty()){
            int sz=q.size();
            int f=0;
            for(int i=0; i<sz; i++){
                Node nd=q.peek();
                q.remove();
                if(nd.left != null && vis.get(nd.left) == null){
                   f=1;
                   vis.put(nd.left, 1);
                   q.add(nd.left);
                }
                if(nd.right != null && vis.get(nd.right) == null){
                   f=1;
                   vis.put(nd.right, 1);
                   q.add(nd.right);
                }
                if(m.get(nd) != null && vis.get(m.get(nd)) == null){
                   f=1;
                   vis.put(m.get(nd), 1);
                   q.add(m.get(nd));
                }
            }
            if(f == 1){
                time++;
            }
            
        }
        return time;
    }
    public static Node getParent(Node root, Map<Node, Node> m, int target){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node res=null;
        while(!q.isEmpty()){
            Node nd=q.peek();
            q.remove();
            if(nd.data == target){
                res=nd;
            }
            if(nd.left != null){
                m.put(nd.left, nd);
                q.add(nd.left);
            }
            if(nd.right != null){
                m.put(nd.right, nd);
                q.add(nd.right);
            }
        }
        return res;
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Map<Node, Node> m=new HashMap<>();
        Node t=getParent(root, m, target);
        int ans=minTime(root, m, t);
        return ans;
    }
}
