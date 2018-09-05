package Problems;


import java.util.Arrays;

@SuppressWarnings("all")
public class SumArray {
    public static void main(String[] args) {
        int[] integers = new int[100];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
        System.out.println(Arrays.toString(integers));


        int total = sum(integers);
        System.out.println(total);
        //answer should be 4950 ((last * last + 1) / 2)
    }

    private static int sum(int[] array) {
        
    	
    	ThisThread thread1 = new ThisThread(array, 0, 25);
    	ThisThread thread2 = new ThisThread(array, 25, 50);
    	ThisThread thread3 = new ThisThread(array, 50, 75);
    	ThisThread thread4 = new ThisThread(array, 75, 100);
    	
    	thread1.start();
    	thread2.start();
    	thread3.start();
    	thread4.start();
    	
    	try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return thread1.getSum() + thread2.getSum() + thread3.getSum() + thread4.getSum();
    }
}

class ThisThread extends Thread {
    private int sum = 0;
    private int start;
    private int stop;
    private int[] ints;
    
	public ThisThread(int[] ints, int start, int stop) {
    	this.ints = ints;
    	this.start = start;
    	this.stop = stop;
    }
	
    @Override
    public void run() {
        for(int i = start; i < stop; i++) {
        	this.sum += ints[i];
        }
    }
    
    public int getSum() {
    	return this.sum;
    }
}