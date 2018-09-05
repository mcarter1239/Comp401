package lecture;

public class Example2 {
    /*
    So in the last example we saw that we made a runnable, then we made a thread that took the runnable.

    This is OOP so we can do the same thing in a lot of different ways. Its like simplifying an equation in math.
     */

    public static void main(String[] args) throws InterruptedException {
        //Make a runnable inside the thread argument
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello thread 1");
            }
        });
        thread1.start();


        //Now if we want to make the thread, but run it on creation and not make any variables.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2!");
            }
        }).start();


        //Java supports lambdas so you might see this notation as well.
        new Thread(() -> {
            System.out.println("Inside thread 3. Theres no run() here but its the same thing");
        }).start();
        //or
        new Thread(() -> System.out.println("hello4")).start();


        //Now with classes!

        //This is the class as a runnable. Implement the interface!
        ThisRunnable runnable = new ThisRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(runnable.getX());
        thread.join();
        System.out.println(runnable.getX());


        //and you can also directly make your own threads. Make sure to extend thread.
        ThisThread completeThread = new ThisThread();
        completeThread.start();

    }
}

class ThisRunnable implements Runnable {
    int x = 0;

    @Override
    public void run() {
        System.out.println("This is from a class");
        for (int i = 0; i < 10; i++) {
            x++;
        }
    }

    public int getX() {
        return x;
    }
}

class ThisThread extends Thread {
    //must override the run() method!
    @Override
    public void run() {
        System.out.println("In a thread class!");
    }
}
