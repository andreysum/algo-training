package com.github.andreysum;

import java.util.List;

import static java.lang.Math.abs;

class MaxSubarraySearch {
    static Result findMaxSubarraySearch(int[] t, int f, int l) {
        if (f == l) {
            return new Result(f, l, t[f]);
        } else {
            int mid = (int) Math.floor((f + l) / 2);
            Result resLeft = findMaxSubarraySearch(t, f, mid);
            Result resRight = findMaxSubarraySearch(t, mid + 1, l);
            Result resCross = findMaxCross(t, f, mid, l);
            if (resLeft.sum >= resRight.sum && resLeft.sum >= resCross.sum) {
                return resLeft;
            } else if (resRight.sum >= resCross.sum) {
                return resRight;
            } else {
                return resCross;
            }
        }
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum = 0;
        for (int i = 0, ri = arr.size() - 1; i < arr.size(); i++, ri--) {
            sum += arr.get(i).get(i) - arr.get(i).get(ri);
        }
        return abs(sum);
    }

    static Result findMaxCross(int[] t, int f, int mid, int l) {
        int leftMaxSum = Integer.MIN_VALUE;
        int leftMaxIdx = mid;
        int leftSum = 0;
        int left = mid;
        while (left >= f) {
            leftSum = leftSum + t[left];
            if (leftMaxSum < leftSum) {
                leftMaxSum = leftSum;
                leftMaxIdx = left;
            }
            left--;
        }
        int rightMaxSum = Integer.MIN_VALUE;
        int rightMaxIdx = mid + 1;
        int rightSum = 0;
        int right = mid + 1;
        while (right <= l) {
            rightSum = rightSum + t[right];
            if (rightMaxSum < rightSum) {
                rightMaxSum = rightSum;
                rightMaxIdx = right;
            }
            right++;
        }
        return new Result(leftMaxIdx, rightMaxIdx, leftMaxSum + rightMaxSum);
    }

    static class Result {
        int first;
        int last;
        int sum;
        Result(int f, int l, int sum) {
            first = f;
            last = l;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "first=" + first +
                    ", last=" + last +
                    ", sum=" + sum +
                    '}';
        }
    }
}
