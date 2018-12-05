package algorithm_stackAndQueue;

// 用数组实现基本的栈和队列 并在异常时抛出提示信息
public class Array_To_Stack_Queue {
	public static class ArrayStack {
		private Integer[] arr;
		private Integer index;
		
		public ArrayStack(int initSize){
			// 栈的构造    initSize指定栈大小
			if(initSize<0){
				throw new IllegalArgumentException("The init index is less than 0");
			}
			arr = new Integer[initSize];
			index = 0;
		}
		
		public Integer peek(){
			// 返回栈顶
			if(index==0){
				return null;
			}
			return arr[index-1];
		}
		
		public void push(int obj){
			// 压数入栈
			if(index==arr.length){
				throw new ArrayIndexOutOfBoundsException("The stack is full!");
			}
			arr[index++] = obj;
		}
		
		public Integer pop(){
			// 弹出栈顶
			if(index==0){
				throw new ArrayIndexOutOfBoundsException("The stack is empty!");
			}
			return arr[--index];
		}
		
	}
	
	public static class ArrayQueue{
		private Integer[] arr;
		private Integer size;
		private Integer start;
		private Integer end;
		
		public ArrayQueue(int initSize){
			if(initSize<0){
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			start = 0;
			end = 0;
		}
		
		public Integer peek() {
			// 返回顶部元素
			if (size == 0) {
				return null;
			}
			return arr[start];
		}
		
		public void push(int obj) {
			// 向队列中加入元素
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[end] = obj;
			// end如果到最后一个位置就跳回到0 否则+1
			end = end == arr.length - 1 ? 0 : end + 1;
		}

		public Integer poll() {
			// 从队列出取出元素
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = start;
			// start如果到最后一个位置就跳回到0 否则+1
			start = start == arr.length - 1 ? 0 : start + 1;
			return arr[tmp];
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
