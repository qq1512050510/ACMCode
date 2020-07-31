package com.chiang.collection;

import java.util.LinkedList;
import java.util.Queue;

interface Request{
	void execute();
}
public class RequestQueue {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Queue requests = new LinkedList();
		offerRequestTo(requests);
		process(requests);
	}
	static void offerRequestTo(@SuppressWarnings("rawtypes") Queue requests){
		for(int i=0;i<6;i++){
			Request request = new Request(){
				public void execute(){
					System.out.printf("处理数据%s%n",Math.random());
				}
			};
			requests.offer(request);
		}
	}
	static void process(Queue requests){
		while(requests.peek()!=null){
			Request request = (Request)requests.poll();
			request.execute();
		}
	}

}
