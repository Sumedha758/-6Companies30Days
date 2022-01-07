/*
delete n nodes after m nodes
The input list will have at least one element  
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        // your code here
        Node m_nodes=head;
        Node n_nodes=head;
        while(n_nodes != null && m_nodes != null){
            int cnt=0;
            int cnt1=0;
          
            while(m_nodes != null && n_nodes != null  && cnt != M-1){
                cnt++;
                m_nodes=m_nodes.next;
                n_nodes=n_nodes.next;
            }
          
            if(m_nodes == null && n_nodes == null){
                 break;
            }
          
            while(n_nodes != null && cnt1 != N+1){
                 cnt1++;
                 n_nodes=n_nodes.next;
            }
          
           if(m_nodes != null){
               m_nodes.next=n_nodes;
           }
           m_nodes=m_nodes.next;
        }
    }
}


