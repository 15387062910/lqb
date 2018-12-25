package algorithm_stackAndQueue;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

// 使用Java中的内置栈结构和内置队列结构
public class useStackAndQueue {

	private static void useStack() {
		// 使用栈 -> 内容不可为基本数据类型
		// 内置栈方法如下:
		// push方法: 向栈中压入元素
		// peek方法: 返回栈顶元素
		// pop方法: 从栈顶取出栈顶元素并将其从栈中移除
		// isEmpty方法: 判断栈是否为空
		// search方法: 返回对象在栈中位置(-1表示不存在)
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		System.out.println(stack.isEmpty());
		System.out.println(stack.search(0) + " " + stack.search(1));
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}

	private static void useQueue() {
		// 使用队列 -> 内容不可为基本数据类型
		// 内置队列方法如下:
		// offer方法: 向队列中插入新元素
		// poll方法: 弹出队列头元素
		// peek方法: 返回队列头元素
		// isEmpty方法: 判断队列是否为空
		// size方法: 计算队列大小
		Queue<Integer> queue = new LinkedList<Integer>();
		System.out.println("The first element is: " + queue.peek());
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.poll();
		System.out.println("The first element is: " + queue.peek());
		System.out.println("The size is: " + queue.size());
	}

	public static void main(String[] args) {
		System.out.println("use stack: ");
		useStack();
		System.out.println("use queue: ");
		useQueue();
	}

}
