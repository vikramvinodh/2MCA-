public class SimpleThreads {
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s:%s%n", threadName, message);

    }

    private static class MessageLoop implements Runnable {
        public void run() {
            String importantInfo[] = {
                    "Mares Oats",
                    "Dogs",
                    "Cats",

            };
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);

                }
            } catch (InterruptedException e) {
                threadMessage("I am not done");
            }
        }
    }

    public static void main(String args[])
            throws InterruptedException {
        long patience = 1000 * 60 * 60;
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Arg must be int");
                System.exit(1);
            }
        }
        threadMessage("starting messageloop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("waiting for message to finish");
        while (t.isAlive()) {
            threadMessage("Still waiting....");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finally!!!");
    }

}
