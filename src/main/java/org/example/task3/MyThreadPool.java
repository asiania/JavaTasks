package org.example.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {
    private static final LinkedList<Runnable> taskQueue = new LinkedList<>();
    private final List<WorkerThread> workerThreads = new ArrayList<>();
    private volatile boolean isShutdown = false;

    public MyThreadPool(int countThreads) {
        for (int i=0; i<=countThreads; i++){
            WorkerThread thread = new WorkerThread();
            workerThreads.add(thread);
            thread.start();
        }
    }

    public void execute(Runnable task){
        if(isShutdown) throw new IllegalStateException("Shutdown");
        taskQueue.add(task);
    }

    public void shutdown(){
        this.isShutdown = true;
        for(WorkerThread thread : workerThreads){
            thread.isShutdown = true;
        }
    }

    public static Runnable getNextTask() {
        return taskQueue.poll();
    }

    public void awaitTermination(){
        Thread awaitTermination = new Thread(() ->{
            do {
                for (WorkerThread thread : workerThreads) {
                    System.out.println("awaitTermination "+thread.getName() + " " + thread.getState().name());
                }
            } while (!taskQueue.isEmpty());
        });

        awaitTermination.start();
    }


}
