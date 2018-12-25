package algorithm_stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 用队列实现栈结构以及用栈结构实现队列结构
public class StackAndQueueConvert {
	public static class TwoStacksQueue{
		// 用栈实现队列
		private Stack<Integer> stackPush;		// 入队栈
		private Stack<Integer> stackPop;		// 出队栈
		
		public TwoStacksQueue(){
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		
		public void push(int pushInt){
			// 入队: 把数据压入入队栈(入队只把数据放进入队栈)
			stackPush.push(pushInt);
		}
		
		public void dao(){
			// 倒数据的方法 -> 入队栈倒到出队栈
			if(!stackPop.isEmpty()){
				// 出队栈不为空时不能倒数据
				return;
			} 
			while(!stackPush.isEmpty()){
				// 只要到数据就要依次倒完
				stackPop.push(stackPush.pop());
			}
		}
		
		public int pop(){
			// 出队: 取出出队栈栈顶元素(如果出队栈为空入队栈有数据就把入队栈数据压入出队栈)
			if(stackPop.empty() && stackPush.empty()){
				throw new RuntimeException("Queue is empty!");
			} 
			dao();
			
			return stackPop.pop();
		}
		
		public int peek(){
			// 获得顶部元素: 原理和上面的pop一样 只不过最后用的是栈的peek
			if(stackPop.empty() && stackPush.empty()){
				throw new RuntimeException("Queue is empty!");
			} 
			dao();
			
			return stackPop.peek();
		}
		
	}
	
	public static class TwoQueuesStack{
		// 用队列实现栈
		private Queue<Integer> data;
		private Queue<Integer> help;
		
		public TwoQueuesStack(){
			data = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		
		public void push(int pushInt){
			// 入栈: 把数据放入data队列中(数只进data队列)
			data.add(pushInt);
		}
		
		public int pop(){
			// 出栈: 若data队列不为空把data队列中全部-1个数据出队放到help队列中 
			// 然后data队列中剩下的那个元素就是栈的顶部元素  poll弹出即可 然后交换data队列和help队列
			if(data.isEmpty()){
				throw new RuntimeException("Stack is empty!");
			}
			while(data.size() != 1){
				// 把data栈的东西全部拿出依次放入help栈
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			
			return res;
		}
		
		public int peek(){
			// 获得顶部元素: 若data队列不为空把data队列中全部-1个数据出队放到help队列中 
			// 然后data队列中剩下的那个元素就是栈的顶部元素  用peek取出即可 然后交换data队列和help队列
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() != 1) {
				// 把data栈的东西全部拿出依次放入help栈
				help.add(data.poll());
			}
			int res = data.peek();
			swap();			
			
			return res;
		}
		
		private void swap(){
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}
		
	}
}
