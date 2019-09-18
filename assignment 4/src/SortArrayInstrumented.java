public class SortArrayInstrumented {

    private long comparisons;
    private long totalComparisons;
    private long minComparisons;
    private long maxComparisons;

    public SortArrayInstrumented()
    {
        comparisons = 0;
        minComparisons= Long.MAX_VALUE;
        totalComparisons = 0;
        maxComparisons = 0;
    }

    public long getComparisons(){return comparisons;}
    public long getTotalComparisons(){return totalComparisons;}
    public long getMinComparisons(){return minComparisons;}
    public long getMaxComparisons(){return maxComparisons;}

    private void startStatistics(){ comparisons = 0;}

    private void endStatistics(){
        totalComparisons = totalComparisons + comparisons;
        minComparisons = Math.min(minComparisons,comparisons);
        maxComparisons = Math.max(maxComparisons,comparisons);
    }

    public  <T extends Comparable<? super T>>
    void selectionSort(T[] a, int n) {
        startStatistics();
        for (int index = 0; index < n - 1; index++)
        {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
            // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[unsorted]
        } // end for
        endStatistics();
    } // end selectionSort

    public <T extends Comparable<? super T>>
    int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            comparisons++;
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            } // end if
            // Assertion: min is the smallest of a[first] through a[index].
        } // end for
        return indexOfMin;
    }

    private <T>
    void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // end swap
}
