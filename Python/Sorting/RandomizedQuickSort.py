# Randomized QuickSort

'''
RANDOMIZED-PARTITION(A, p, r)
1   i = RANDOM(p, r)
2   exchange A[r] with A[i]
3   return PARTITION(A, p, r)

RANDOMIZED-QUICKSORT(A, p, r)
1   if p < r
2       q = RANDOMIZED-PARTITION(A, p, r)
3       RANDOMIZED-QUICKSORT(A, p, q - 1)
4       RANDOMIZED-QUICKSORT(A, q + 1, r)
'''
from random import randint
import QuickSort

def randomizedPartition(array, p, r):
    i = randint(p, r)
    array[r], array[i] = array[i], array[r]
    return QuickSort.partition(array, p, r)

def randomizedQuickSort(array, p, r):
    if p < r:
        q = randomizedPartition(array, p, r)
        randomizedQuickSort(array, p, q - 1)
        randomizedQuickSort(array, q + 1, r)

# Driver code to test above 
# First element is not used in any form. Just there to circumvent zero indexing
arr = [0, 12, 11, 13, 5, 6, 7] 
randomizedQuickSort(arr, 1, 6) 
n = len(arr) 
print ("Sorted array is") 
for i in range(n): 
    print ("%d" %arr[i])