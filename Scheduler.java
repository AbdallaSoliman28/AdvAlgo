package task2;
//task4
import java.util.*;
// This code defines two classes: Scheduler and Job.

// The Scheduler class has a constructor that initializes a new LinkedList object to store the jobs. 
// It also has methods to add jobs to the queue and run the jobs.
public class Scheduler {
    private Queue<Job> queue;

    public Scheduler() {
        queue = new LinkedList<>();
    }

    public void addJob(Job job) {
        queue.add(job);
    }
// This run method runs each job in the queue by calling the poll method on the queue 
// to remove the first job and then sleeping for the duration of the job.
    public void run() {
    	// The while loop continues to run as long as the queue is not empty. 
    	// The first line inside the loop removes the first job from the queue and assigns it to a new Job object called job.
        while (!queue.isEmpty()) {
            Job job = queue.poll();
         // This line prints a message to the console indicating that the job is running and displaying its ID.
            System.out.println("Running job " + job.getId());
         // This block uses a try-catch block to sleep for the duration of the job.
            try {
         // The duration is obtained by calling the getDuration method on the job object 
         // and multiplying it by 1000 to convert it from seconds to milliseconds
                Thread.sleep(job.getDuration() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } 
// The main method creates a new instance of the Scheduler class and adds three jobs to the queue with different durations. 
// It then calls the run method on the scheduler to run all of the jobs in the queue.
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.addJob(new Job(1, 5));
        scheduler.addJob(new Job(2, 3));
        scheduler.addJob(new Job(3, 2));
        scheduler.run();
    }
}
// The Job class has a constructor that takes an ID and a duration as arguments. It also generates a random priority between 1 and 10. 
// The class has methods to get the ID, priority, and duration of a job.
class Job {
    private int id;
    private int priority;
    private int duration;

    public Job(int id, int duration) {
        this.id = id;
        this.priority = (int) (Math.random() * 10) + 1;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getDuration() {
        return duration;
    }
}
