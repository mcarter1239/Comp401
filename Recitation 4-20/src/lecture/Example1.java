package lecture;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread count before starting: " + Thread.activeCount());

        /*
        This is a runnable. This has the run() method that is executed when we call .start on the thread.
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread count once we are created: " + Thread.activeCount());
                for (int i = 0; i < 4; i++) {
                    System.out.println("This is inside the thread! execution number: " + i);
                    //this pauses our thread for 1 second
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //Make a new thread, it takes the runnable object we just made.
        Thread thread = new Thread(runnable);
        //calling start spawns a new thread, and calls run().
        thread.start();


        //so we just started the code, but remember this is like asking someone to go get coffee, the following line will still execute immediatly.
        System.out.println("Thread count once it has started running: " + Thread.activeCount());

        //if we want to wait for the thread to finish. We use .join!
        thread.join();
        System.out.println("Done, thread count at end: " + Thread.activeCount());

    }
}
