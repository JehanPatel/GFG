#User function Template for python3

#Function to find a continuous sub-array which adds up to a given number.
def subSum(arr,target):
    summ,d = 0,{}
    for i in range(len(arr)):
        summ += arr[i]
        if summ == target:
            return [1,i+1]
        elif summ - target in d:
            return [d[summ-target]+1,i+1]
        d[summ] = i + 1
    return [-1]
    
for _ in range(int(input())):
    n,target = map(int,input().split())
    arr = list(map(int,input().split()))
    print(*subSum(arr,target))
