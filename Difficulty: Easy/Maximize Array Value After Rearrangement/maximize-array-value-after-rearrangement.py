class Solution:
    def Maximize(self, arr): 
        # Complete the function
        arr.sort()
        sum=0
        for i in range(1,len(arr)):
            sum+=arr[i]*i
        if (sum>10**9+7): return sum %(10**9+7)    
        return sum   

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())

    for _ in range(t):
        A = list(map(int, input().strip().split()))
        # k = int(input())
        ob = Solution()
        print(ob.Maximize(A))

# } Driver Code Ends