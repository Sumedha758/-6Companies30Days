class Solution {
    void swap(char c[], int a, int b){
        char temp=c[a];
        c[a]=c[b];
        c[b]=temp;
    }
    int partition(char nuts[], char bolts[], int l, int r) {
	    int s = l;
	    int idx=l;
	    for(int i = l; i <= r; i++) {
	        if(bolts[i] < nuts[l]) swap(bolts, s++, i);
	        if(bolts[i] == nuts[l]) idx = i;
	    }
	    swap(bolts, s, idx);
    	for(int i = l; i <= r; i++) {
            nuts[i] = bolts[i];
	    }
	    return s;
	}
	void quicksort(char nuts[], char bolts[], int l, int h){
	    if(l >= h){
	        return;
	    }
	    int pivot=partition(nuts, bolts, l, h);
	    quicksort(nuts, bolts, l, pivot-1);
	    quicksort(nuts, bolts, pivot+1, h);
	}
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        quicksort(nuts, bolts, 0, n-1);
        
    }
}
