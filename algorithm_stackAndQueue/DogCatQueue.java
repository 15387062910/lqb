package algorithm_stackAndQueue;

// 猫狗队列问题
/*
 实现一种猫狗队列的结构，要求如下： 			
 用户可以调用add方法将cat类或者dog类的实例放入队列中；
 用户可以调用pollAll方法，将队列中所有的实例按照队列的先后顺序依次弹出；
 用户可以调用pollDog方法，将队列中dog类的实例按照队列的先后顺序依次弹出；
 用户可以调用pollCat方法，将队列中cat类的实例按照队列的先后顺序依次弹出；
 用户可以调用isEmpty方法，检查队列中是否还有dog和cat的实例；
 用户可以调用isDogEmpty方法，检查队列中是否还有dog的实例；
 用户可以调用isCatEmpty方法，检查队列中是否还有cat的实例。
 */

import java.util.*;

public class DogCatQueue {
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	public static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	public static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}

	public static class PetEnterQueue {
		// 队列中的猫或狗
		private Pet pet;
		private long count;

		public PetEnterQueue(Pet pet, long count) {
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return this.pet;
		}

		public long getCount() {
			return this.count;
		}

	}

	public static class dogCatQueue {
		private Queue<PetEnterQueue> dogQ;
		private Queue<PetEnterQueue> catQ;
		private long count;

		public dogCatQueue() {
			this.dogQ = new LinkedList<DogCatQueue.PetEnterQueue>();
			this.catQ = new LinkedList<DogCatQueue.PetEnterQueue>();
			this.count = 0;
		}

		public void add(Pet pet) {
			// 向队列中添加Cat和Dog的实例
			if (pet.getPetType().equals("dog")) {
				this.dogQ.add(new PetEnterQueue(pet, this.count++));
			} else if (pet.getPetType().equals("cat")) {
				this.catQ.add(new PetEnterQueue(pet, this.count++));
			} else {
				throw new RuntimeException("err, not dog or cat");
			}
		}

		public Pet pollAll() {
			// 猫狗队列中所有的实例按照队列的先后顺序依次弹出
			if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
				// count小的是先添加进队列的
				if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
					return this.dogQ.poll().getPet();
				} else {
					return this.catQ.poll().getPet();
				}
			} else if (!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			} else if (!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			} else {
				// 猫狗队列都为空
				throw new RuntimeException("err, queue is empty!");
			}
		}

		public Pet pollDog() {
			// 将队列中dog类的实例按照队列的先后顺序依次弹出
			if(this.isDogEmpty()){
				throw new RuntimeException("err, dog queue is empty");
			} else{
				return this.dogQ.poll().getPet();
			}
		}

		public Pet pollCat() {
			// 将队列中cat类的实例按照队列的先后顺序依次弹出
			if(this.isCatEmpty()){
				throw new RuntimeException("err, cat queue is empty");
			} else{
				return this.catQ.poll().getPet();
			}	
		}

		public boolean isEmpty() {
			// 检查队列中是否还有dog和cat的实例
			return this.dogQ.isEmpty() && this.catQ.isEmpty();
		}

		public boolean isDogEmpty() {
			// 检查队列中是否还有dog的实例
			return this.dogQ.isEmpty();
		}

		public boolean isCatEmpty() {
			// 检查队列中是否还有cat的实例
			return this.catQ.isEmpty();
		}

	}

	public static void main(String[] args) {
		dogCatQueue test = new dogCatQueue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		
		while (!test.isDogEmpty()) {
			// 弹出所有dog实例  并输出
			System.out.println(test.pollDog().getPetType());
		}
		
		while (!test.isEmpty()) {
			// 弹出所有cat实例  并输出
			System.out.println(test.pollAll().getPetType());
		}
		
		System.out.println(test.isEmpty());
	}

}
