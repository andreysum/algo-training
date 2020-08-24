package com.github.andreysum;
import java.util.*;

class PriorityQueue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opCount = s.nextInt();
        List<Integer> queue = new ArrayList<>();
        List<Integer> extracted = new ArrayList<>();
        for (int i = 0; i < opCount; i++) {
            String op = s.next();
            if (op.equals("Insert")) {
                int arg = s.nextInt();
                insert(queue, arg);
            } else {
                int max = extractMax(queue);
                if (max >= 0) {
                    extracted.add(max);
                }
            }
        }
        if (!extracted.isEmpty()) {
            extracted.forEach(System.out::println);
        }
    }

    private static void insert(List<Integer> queue, int arg) {
        queue.add(arg);
        siftUp(queue, queue.size() - 1);
    }
    private static int extractMax(List<Integer> queue) {
        if (queue.isEmpty()) {
            return -1;
        }
        int max = queue.get(0);
        int lastIndex = queue.size() - 1;
        swap(queue, 0, lastIndex);
        queue.remove(lastIndex);
        siftDown(queue, 0);
        return max;
    }

    private static void siftDown(List<Integer> queue, int index) {
        int lIndex = 2*index + 1;
        int rIndex = 2*index + 2;
        int maxIndex = index;
        if (rIndex < queue.size()) {
            int l = queue.get(lIndex);
            int r = queue.get(rIndex);
            maxIndex = l >= r ? lIndex : rIndex;
        } else if (lIndex < queue.size()) {
            maxIndex = lIndex;
        }
        if (index != maxIndex) {
            int cur = queue.get(index);
            if (cur < queue.get(maxIndex)) {
                swap(queue, index, maxIndex);
                siftDown(queue, maxIndex);
            }
        }
    }

    private static void swap(List<Integer> queue, int sIndex, int tIndex) {
        int t = queue.get(tIndex);
        queue.set(tIndex, queue.get(sIndex));
        queue.set(sIndex, t);
    }

    private static void siftUp(List<Integer> queue, int index) {
        int pIndex = (index - 1) / 2;
        int val = queue.get(index);
        int pVal = queue.get(pIndex);
        if (pVal < val) {
            swap(queue, pIndex, index);
            siftUp(queue, pIndex);
        }
    }
}
