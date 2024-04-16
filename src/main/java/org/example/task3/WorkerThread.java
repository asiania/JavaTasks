package org.example.task3;

class WorkerThread extends Thread {
    private Runnable task = null;
    boolean isShutdown = false;

    @Override
    public void run() {
        while(true) {
            task = MyThreadPool.getNextTask();
            if (task != null) {
                System.out.println(this.getName()+" RUN");
                task.run();
            }
            else if(isShutdown) {
                System.out.println("!STOP "+this.getName());
                break;
            }
        }
    }

    public Runnable getTask() {
        return task;
    }
}
