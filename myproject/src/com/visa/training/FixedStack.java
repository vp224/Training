package com.visa.training;

public class FixedStack implements stack{
	
	
	private Object o[];
	int size;
	int top;
	public FixedStack(int n) {
		o = new Object[n];
		size=n;
		top =-1;
	}
	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		if((element instanceof Integer))
		{
			
			o[size] = element;
			size++;
		//	top = (int) element;
		}
		
	}

	@Override
	public Object pop() {
	
		// TODO Auto-generated method stub
		Object temp = o[top];
		size--;
		top= (int)o[size];
		return temp;	
	}
		
}
