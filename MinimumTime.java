import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumTime {
	Scanner scanner=new Scanner(System.in);
	
	PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());

	public static void main(String[] args) {
		
		MinimumTime minimumTime=new MinimumTime();
		minimumTime.getOrder();
		System.out.println("Minimum Seconds:"+minimumTime.findMinimumTime());
		
	}
		
		public void getOrder() {
		System.out.println("Please enter order for Mango Milkshake");
		queue.add(scanner.nextInt());
		
		System.out.println("Please enter order for Orange Milkshake");
		queue.add(scanner.nextInt());
		System.out.println("Please enter order for Pineapple Milkshake");
		queue.add(scanner.nextInt());
		System.out.println("Please enter order for Banana Milkshake");
		queue.add(scanner.nextInt());
		System.out.println("Strating Queue"+queue);
		
		
		
		}
		public int findMinimumTime() {
			
			int seconds=0;

			 Iterator<Integer> itr=queue.iterator();
			 //3,0,0
			 //5,4,4
			 while(!queue.isEmpty()) {
				 
				 int val1=0,val2=0;
				 
				 if(itr.hasNext())
					 val1=queue.remove();
				 
				 if(itr.hasNext())
					 val2=queue.remove();
				// 5,4
				 //val1=4, val2=4
				 if(val1==0&&val2>0)
				 {
					 seconds+=val2;
					 break;
				 }
				 if(val1>0&&val2==0) {
					 seconds+=val1;
					 break;
				 }
				 //if both the variables have value >0 then add a second and decrease both by 1
				 if(val1>0&&val2>0) {
					 val1--;
					 val2--;
					 seconds++;
				 }
				 //4
				 // val1=4,val2=3 | val1=3,val2=3
				 // sec=2
				 // If any of the variable has value >0 then add them back to queue
				 if(val1>0)
					 queue.add(val1);
				 if(val2>0)
					 queue.add(val2);
				 
				 //[4,4,3]
				 //[3,3,3]
				 //[3,2,2]
				 //[2,2,1]
				 //[1,1,1]
				 //[1,0,0]
				//[1]
				 //[0]
				 		 
				 System.out.println(queue);
		 
				 
			 }
			
		
		return seconds;
		
		
	}

}
