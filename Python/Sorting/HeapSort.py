# Heapsort.py

'''
HEAPSORT(A)
1   BUILD-MAX-HEAP(A)
2   for i = A.length downto 2
3       exchange A[1] with A[i]
4       A.heap-size = A.heap-size - 1
5       MAX-HEAPIFY(A,1)

BUILD-MAX-HEAP(A)
1   A.heap-size = A.length
2   for i = floor(A.length / 2) downto 1
3   MAX-HEAPIFY(A, i)

MAX-HEAPIFY(A,i)
1   left = LEFT(i)
2   r = RIGHT(i)
3   if left <= A.heap-size and A[left] > A[i]
4       largest = left
5   else largest = i
6   if r <= A.heap-size and A[r] > A[largest]
7       largest = r
8   if largest != i
9       exchange A[i] with A[largest]
10      MAX-HEAPIFY(A, largest)
'''

import math

def left_node(index):
    return 2 * index

def right_node(index):
    return 2 * index + 1

def heapify(array, size, index):
    left = left_node(index)
    right = right_node(index)
    largest = 0
    if ((left <= size) and (array[left] > array[index])):
        largest = left
    else:
        largest = index
    if(right <= size):
        if(array[right] > array[largest]):
            largest = right
    if(largest != index):
        array[index], array[largest] = array[largest], array[index]
        heapify(array, size, largest)

def buildHeap(array, size):
    size = len(array) - 1
    i = math.floor(size / 2)
    while(i >= 1):
        heapify(array, size, i)
        i = i - 1

def heapSort(array, size):
    buildHeap(array, size)
    i = len(array) - 1
    while(i >= 2):
        array[1], array[i] = array[i], array[1]
        size = size - 1
        heapify(array, size, 1)
        i = i - 1

# Driver code to test above 
# First element is not used in any form. Just there to circumvent zero indexing
arr = [0, 12, 11, 13, 5, 6, 7] 
heapSort(arr, 6) 
n = len(arr) 
print ("Sorted array is") 
for i in range(n): 
    print ("%d" %arr[i])