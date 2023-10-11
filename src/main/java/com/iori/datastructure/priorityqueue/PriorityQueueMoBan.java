package com.iori.datastructure.priorityqueue;

import com.iori.datastructure.queue.Queue;

import java.util.Arrays;

/**
 * 优先级队列 一端进 一端出  按优先级出队
 * 基于大顶堆实现
 *
 * @param <E> 队列中元素类型, 必须实现 Priority 接口
 */
public class PriorityQueueMoBan<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueueMoBan(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /*
    1. 入堆新元素, 加入到数组末尾 (索引位置 child)
    2. 不断比较新加元素与它父节点(parent)优先级 (上浮)
        - 如果父节点优先级低, 则向下移动, 并找到下一个 parent
        - 直至父节点优先级更高或 child==0 为止
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }


        return true;

    }


    /*
    1. 交换堆顶和尾部元素, 让尾部元素出队
    2. (下潜)
        - 从堆顶开始, 将父元素与两个孩子较大者交换
        - 直到父元素大于两个孩子, 或没有孩子为止
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        return null;


    }




    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
