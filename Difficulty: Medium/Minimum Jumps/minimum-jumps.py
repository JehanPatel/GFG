class Solution:
	def minJumps(self, arr, n):
	    #code here
	    
	    if n ==1:
	        return 0
	    if arr[0] ==0:
	        return -1
	        
	    after_jump = 0
	    max_jump = 0
	    steps = 0
	    
	    for i, jump in enumerate(arr):
	        if i == n-1:
	            return steps
	        max_jump = max(max_jump, i+jump)
	        if i == after_jump:
	            
	            steps+=1
	            
	            after_jump = max_jump
	            
	        if jump == 0 and i == max_jump:
	             
	             return -1
	             
	             
	    return -1

#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		Arr = [int(x) for x in input().split()]
		ob = Solution()
		ans = ob.minJumps(Arr,n)
		print(ans)
# } Driver Code Ends