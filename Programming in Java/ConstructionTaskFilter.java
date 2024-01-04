import java.util.ArrayList;
import java.util.List;

class ConstructionTask {
    private String name;
    private String status;

    public ConstructionTask(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}

public class ConstructionTaskFilter {

    public static void main(String[] args) {
        // Sample list of construction tasks
        List<ConstructionTask> tasks = new ArrayList<>();
        tasks.add(new ConstructionTask("Excavation", "In Progress"));
        tasks.add(new ConstructionTask("Foundation", "Completed"));
        tasks.add(new ConstructionTask("Structural Framing", "In Progress"));
        tasks.add(new ConstructionTask("Roofing", "Pending"));

        // Using lambda expression to filter tasks based on status
        List<ConstructionTask> inProgressTasks = filterTasks(tasks, task -> task.getStatus().equals("In Progress"));

        // Displaying the filtered tasks
        System.out.println("Construction tasks in progress:");
        for (ConstructionTask task : inProgressTasks) {
            System.out.println(task.getName());
        }
    }

    // Generic method to filter tasks based on a given condition
    private static List<ConstructionTask> filterTasks(List<ConstructionTask> tasks, TaskFilterCondition condition) {
        List<ConstructionTask> filteredTasks = new ArrayList<>();
        for (ConstructionTask task : tasks) {
            if (condition.test(task)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    // Functional interface for the condition to filter tasks
    interface TaskFilterCondition {
        boolean test(ConstructionTask task);
    }
}
