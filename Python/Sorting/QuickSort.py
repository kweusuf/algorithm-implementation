# QuickSort.py

'''
QUICKSORT(A, p, r)
1   if p < r
2       q = PARTITION(A, p, r)
3       QUICKSORT(A, p, q - 1)
4       QUICKSORT(A, q + 1, r)

PARTITION(A, p, r)
1   x = A[r]
2   i = p - 1
3   for j = p to r - 1
4       if A[j] <= x
5           i = i + 1
6           exchange A[i] with A[j]
7   exchange A[i + 1] with A[r]
8   return i + 1
'''

def partition(array, p, r):
    x = array[r]
    i = p - 1
    j = p
    while(j <= r - 1):
        if(array[j] <= x):
            i = i + 1
            array[i], array[j] = array[j], array[i]
        j = j + 1
    array[i + 1], array[r] = array[r], array[i + 1]
    return i + 1

def quickSort(array, p, r):
    if(p < r):
        q = partition(array, p, r)
        quickSort(array, p, q - 1)
        quickSort(array, q + 1, r)

# Driver code to test above 
# First element is not used in any form. Just there to circumvent zero indexing
arr = [0, 12, 11, 13, 5, 6, 7] 
quickSort(arr, 1, 6) 
n = len(arr) 
print ("Sorted array is") 
for i in range(n): 
    print ("%d" %arr[i])