public class Main {
    public static void main(String[] args) {
        int[] toSort = {1,2,10,-2,-3,5,6,14,99,-12,7,-8};
        MyArrays.printArray(toSort);
        int[] sorted = bubblesSort(toSort);
        MyArrays.printArray(sorted);
    }
    public static int[] bubblesSort(int [] m) {
        int i = m.length-1;
        int j;
        int buffer;
        while (i>0) {
            j = 0;
            while (j < i) {
                if (m[j] > m[j + 1]) {
                    buffer = m[j];
                    m[j] = m[j + 1];
                    m[j + 1] = buffer;
                }
                j++;
            }
            i--;
        }
        return m;
    }
}