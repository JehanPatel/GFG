//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            int edges[][] = new int[n-1][3];
            for(int i = 0; i < (n-1); i++){
                String input_line[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < 3; j++){
                    edges[i][j] = Integer.parseInt(input_line[j]);
                }
            } 
            
            int q = Integer.parseInt(read.readLine());

            String input_line[] = read.readLine().trim().split("\\s+");
            int queries[]= new int[q];
            for(int i = 0; i < q; i++)
                queries[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumWeight(n, edges, q, queries); 
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
// } Driver Code Ends
class Solution {
    int ans;

    private int root(int i, int[] parent) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    private int Union(int a, int b, int[] parent, int[] sz) {
        int ra = root(a, parent);
        int rb = root(b, parent);

        if (ra == rb)
            return sz[ra] * sz[ra];

        if (sz[ra] < sz[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;

            temp = a;
            a = b;
            b = temp;
        }
        ans += sz[ra] * sz[rb];
        parent[rb] = ra;
        sz[ra] += sz[rb];

        return ans;
    }

    ArrayList<Integer> maximumWeight(int n, int[][] edges, int q, int[] queries) {
        ans = 0;

        int[] parent = new int[n + 1];
        int[] sz = new int[n + 1];
        Arrays.fill(sz, 1);

        // Initializing each element as its own parent.
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // Creating a map to store the maximum weight of the connected component with weights less than or equal to each query.
        NavigableMap<Integer, Integer> mp = new TreeMap<>();

        // Sorting the edges based on their weights in ascending order.
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // Iterating through the sorted edges and performing union operation.
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];

            // Updating the map with the maximum weight of the connected component after each union operation.
            mp.put(c, Union(a, b, parent, sz));
        }

        // Creating a list to store the results for each query.
        ArrayList<Integer> res = new ArrayList<>();

        // Iterating through each query and finding the maximum weight with weights less than or equal to the query.
        for (int query : queries) {
            // Finding the element in the map which is just less than or equal to the query.
            Map.Entry<Integer, Integer> entry = mp.floorEntry(query);
            if (entry == null)
                res.add(0); // If there is no such element, then the maximum weight is 0.
            else
                res.add(entry.getValue()); // Storing the maximum weight for the query.
        }
        return res;
    }
}
