package src.Graph;

public class MinHeap {
    int[] arr;
    int size;
    int maxsize;

    int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        arr = new int[this.maxsize + 1];
        arr[0] = Integer.MIN_VALUE;
    }


    int parent(int n) {
        return n / 2;
    }

    int leftChild(int n) {
        return (2 * n);
    }

    int rightChild(int n) {
        return (2 * n) + 1;
    }

    boolean isLeaf(int n) {
        if (n >= (size / 2) && n <= size) {
            return true;
        }
        return false;
    }

    void swap(int i, int parent) {
        int temp;
        temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;
    }

    void convertToMinHeap(int n) {
        if (!isLeaf(n)) {
            if (arr[n] > arr[leftChild(n)]
                    || arr[n] > arr[rightChild(n)]) {

                if (arr[leftChild(n)] < arr[rightChild(n)]) {
                    swap(n, leftChild(n));
                    convertToMinHeap(leftChild(n));
                } else {
                    swap(n, rightChild(n));
                    convertToMinHeap(rightChild(n));
                }
            }
        }
    }

    public void insert(int data) {
        if (size >= maxsize) {
            return;
        }
        arr[++size] = data;
        int current = size;

        while (arr[current] < arr[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    // heapsort algorithm
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            swap(i, largest);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

  // Function to delete the root from Heap
    int deleteRoot(int arr[], int n)
    {
      // Get the last element
      int lastElement = arr[n - 1];

      // Replace root with first element
      arr[0] = lastElement;

      // Decrease size of heap by 1
      n = n - 1;

      // heapify the root node
      heapify(arr, n, 0);

      // return new size of Heap
      return n;
  }

    public void printHeap() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("PARENT : " + arr[i]);

            System.out.println("LEFT CHILD : " + arr[2 * i]);

            System.out.println("RIGHT CHILD : " + arr[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(15);
        minHeap.insert(90);
        minHeap.printHeap();
    }  
}
