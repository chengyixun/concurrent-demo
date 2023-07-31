package com.example.concurrentlearn.wangzheng;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] a = new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        int value = 11;
        int index = bsearch(a, a.length, value);
        log.info("v1 - {}, index1 - {}", value, index);

        int[] b = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int v2 = 8;
        int index2 = b2(b, b.length, v2);
        log.info("v2 - {}, index2 - {}", v2, index2);

    }

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    //  查找第一个值等于给定值的元素
    public static int b2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == 0) || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


    // 查找最后一个值等于给定值的元素
    public static int b3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n-1) || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // TODO: 2023/7/13  查找第一个大于等于给定值的元素

    // TODO: 2023/7/13 查找最后一个小于等于给定值的元素

}
/**
 * 二分查找，它的时间复杂度是 O(logn)
 * 底层依赖的是数组随机访问的特性
 * <p>
 * 二分法的局限性：
 * 1.二分法依赖的是顺序表结构，简单说就是数组
 * 2.二分法针对的是 有序数据
 * 3.数据量太小不适合二分查找。
 * 4.数据量太大也不适合二分查找。
 * <p>
 * 二分查找的核心思想理解起来非常简单，有点类似分治思想。
 * 即每次都通过跟区间中的中间元素对比，将待查找的区间缩小为一半，直到找到要查找的元素，或者区间被缩小为 0。
 * 但是二分查找的代码实现比较容易写错。你需要着重掌握它的三个容易出错的地方：循环退出条件、mid 的取值，low 和 high 的更新。
 * 二分查找虽然性能比较优秀，但应用场景也比较有限。底层必须依赖数组，并且还要求数据是有序的。
 * <p>
 * 对于较小规模的数据查找，我们直接使用顺序遍历就可以了，二分查找的优势并不明显。
 * 二分查找更适合处理静态数据，也就是没有频繁的数据插入、删除操作
 */
