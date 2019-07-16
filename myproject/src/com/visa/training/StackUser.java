package com.visa.training;

import java.util.Random;

public class StackUser{
		public void fill(stack s) {
			Random obj = new Random();
			for(int i=0;i<10;i++) {
				int rand = obj.nextInt(100);
				System.out.println(rand);
				
				s.push(rand);
			}
		}
		public void empty(stack s) {
			for(int i=0;i<10;i++)
			{
				Object temp = s.pop();
				System.out.println(temp);
			}
		}
		
}
