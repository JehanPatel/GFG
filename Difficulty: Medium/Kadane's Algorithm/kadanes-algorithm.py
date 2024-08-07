class Solution:
    
    # Function to find the sum of contiguous subarray with maximum sum.
    def maxSubArraySum(self, arr):
        
        curr = arr[0]
        over = arr[0]
        
        for i in range(1 , len(arr)):
            curr = max(arr[i] , curr+arr[i])
            
            over = max(over , curr)
            
        return over

#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math


def main():
    T = int(input())
    while (T > 0):

        arr = [int(x) for x in input().strip().split()]

        ob = Solution()

        print(ob.maxSubArraySum(arr))

        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends