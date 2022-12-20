public class Main {
    public static void main(String[] args) {
        int[] left = {9, -2, 3, 0, 99, 15};
        int[] right = {-12, 11};
        int[] toSort = {9, -2, 3, 0, 99, 15, -12, 11, 7, -2, 8};
        MyArrays.printArray(bubbleSort(toSort));
        MyArrays.printArray(merge(left,right));
        MyArrays.printArray(mergeSort(toSort));
    }

    public static int[] bubbleSort(int[] m) {
        int i = m.length - 1;
        int j;
        int buffer;
        boolean flag = true;
        while (i > 0 && flag) {
            j = 0;
            flag = false;
            while (j < i) {
                if (m[j] > m[j + 1]) {
                    buffer = m[j];
                    m[j] = m[j + 1];
                    m[j + 1] = buffer;
                    flag = true;
                }
                j++;
            }
            i--;
        }
        return m;
    }

    public static int[] mergeSort(int[] m) {
        if (m.length>1) {
            int[] l = new int[m.length / 2];
            int[] r = new int[m.length - m.length / 2];
            for (int i = 0; i < m.length; i++) {
                if (i<m.length/2) {
                    l[i] = m[i];
                } else {
                    r[i-m.length/2] = m[i];
                }
            }
            return merge(mergeSort(l), mergeSort(r));
        } else {
            return m;
        }
    }

    private static int[] merge(int[] mLeft, int[] mRight) {
        int l = 0, r = 0;
        int i = 0;
        int[] merged = new int[mLeft.length + mRight.length];
        while (l < mLeft.length && r < mRight.length) {
            if (mLeft[l]>mRight[r]) {
                merged[i] = mRight[r];
                r++;
            } else {
                merged[i] = mLeft[l];
                l++;
            }
            i++;
        }
        while (l< mLeft.length) {
            merged[i] = mLeft[l];
            l++;
            i++;
        }
        while (r< mRight.length) {
            merged[i] = mRight[r];
            r++;
            i++;
        }
        return merged;
    }
}