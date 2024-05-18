/*
 * NAME: TODO
 * PID: TODO
 */
/**
 * PA4 Round Robin
 *
 * @author Josef Ongchangco
 * @since 04/29/2024
 */
public class RoundRobin {
    private static final String TASKS_COMPLETED = "All tasks have been completed.";
    private static final int DEFAULT_QUANTUM = 4;
    private MyQueue<Task> taskQueue, completedTasks;
    private int quantum, totalBurstTime, totalWaitTime;

    /**
     * Constructs a RoundRobin object with a default quantum of 4.
     *
     * @param tasks Array of tasks to be scheduled
     * @throws IllegalArgumentException if the task array is null
     */
    public RoundRobin(Task[] tasks) {
        this(DEFAULT_QUANTUM, tasks);
    }

    /**
     * Constructs a RoundRobin object with a specified quantum.
     *
     * @param quantum The time quantum for each task
     * @param tasks   Array of tasks to be scheduled
     * @throws IllegalArgumentException if quantum is less than 1 or if the task array is null
     */
    public RoundRobin(int quantum, Task[] tasks) {
        if (tasks == null || quantum < 1) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        this.taskQueue = new MyQueue<>();
        this.completedTasks = new MyQueue<>();
        this.quantum = quantum;
        this.totalBurstTime = 0;
        this.totalWaitTime = 0;

        for (Task task : tasks) {
            if (task != null) {
                taskQueue.enqueue(task);
            }
        }
    }

    /**
     * Executes all tasks in the round robin scheduler.
     *
     * @return String describing the order of execution/summary of total burst time and wait time.
     */
    public String runAllTasks() {
        if (taskQueue.isEmpty()) {
            return TASKS_COMPLETED;
        }

        StringBuilder output = new StringBuilder();
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.dequeue();
            for (int i = 0; i < quantum; i++) {
                currentTask.runTask();
                totalBurstTime++;
                totalWaitTime += taskQueue.size();
                if (currentTask.isFinished()) {
                    output.append(currentTask).append(" -> ");
                    completedTasks.enqueue(currentTask);
                    break;
                }
            }
            if (!currentTask.isFinished()) {
                taskQueue.enqueue(currentTask);
            }
        }
        return "All tasks completed. Total burst time: " + totalBurstTime +
                " units. Total wait time: " + totalWaitTime + " units. Execution order: " +
                output.toString();
    }

    // Unit tests
    public static void main(String[] args) {
        Task[] tasks1 = {new Task("A", 3), new Task("B", 4),
                new Task("C", 4), new Task("D", 12),
                new Task("E", 6), new Task("F", 3)};
        RoundRobin scheduler1 = new RoundRobin(3, tasks1);
        System.out.println("Test 1:");
        System.out.println(scheduler1.runAllTasks());

        Task[] tasks2 = {new Task("A", 9), new Task("B", 8),
                new Task("C", 6), new Task("D", 4),
                new Task("E", 4), new Task("F", 3)};
        RoundRobin scheduler2 = new RoundRobin(tasks2);
        System.out.println("\nTest 2:");
        System.out.println(scheduler2.runAllTasks());

        Task[] tasks3 = {new Task("A", 7), new Task("B", 5),
                new Task("C", 3), new Task("D", 1),
                new Task("E", 2), new Task("F", 4),
                new Task("G", 6), new Task("H", 8)};
        RoundRobin scheduler3 = new RoundRobin(3, tasks3);
        System.out.println("\nTest 3:");
        System.out.println(scheduler3.runAllTasks());
    }
}