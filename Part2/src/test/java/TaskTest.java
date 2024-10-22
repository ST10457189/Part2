import com.mycompany.part2.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task task1;
    private Task task2;

    public TaskTest() {
        task1 = new Task("Login Feature", "Create Login to authenticate users", "Kabelo", 8, "To Do", 0);
        task2 = new Task("Add Feature", "Create Add Task feature to add tasks", "Kabelo", 10, "Doing", 1);
    }

    @Test
    public void testTask1DetailsValidation() {
        assertTrue(task1.isTaskDescriptionValid(), "Task 1 details should be valid (<= 50 characters).");
    }

    @Test
    public void testTask2DetailsValidation() {
        assertTrue(task2.isTaskDescriptionValid(), "Task 2 details should be valid (<= 50 characters).");
    }

    @Test
    public void testTask1IDGeneration() {
        assertEquals("LO:0:ELO", task1.getUniqueTaskID(), "Task 1 ID should be 'LO:0:ELO' (Login Feature, Kabelo).");
    }

    @Test
    public void testTask2IDGeneration() {
        assertEquals("AD:1:ELO", task2.getUniqueTaskID(), "Task 2 ID should be 'AD:1:ELO' (Add Feature, Kabelo).");
    }

    @Test
    public void testTask1FullDetails() {
        String expectedDetails = "Task Progress: To Do" +
                "\nDeveloper Assigned: Kabelo" +
                "\nTask Number: 0" +
                "\nTask Title: Login Feature" +
                "\nTask Description: Create Login to authenticate users" +
                "\nTask ID: LO:0:ELO" +
                "\nTask Duration: 8 hours";

        assertEquals(expectedDetails, task1.displayTaskDetails(), "Task 1 details should match the expected output.");
    }

    @Test
    public void testTask2FullDetails() {
        String expectedDetails = "Task Progress: Doing" +
                "\nDeveloper Assigned: Kabelo" +
                "\nTask Number: 1" +
                "\nTask Title: Add Feature" +
                "\nTask Description: Create Add Task feature to add tasks" +
                "\nTask ID: AD:1:ELO" +
                "\nTask Duration: 10 hours";

        assertEquals(expectedDetails, task2.displayTaskDetails(), "Task 2 details should match the expected output.");
    }

    @Test
    public void testTotalTaskDuration() {
        assertEquals(18, Task.getTotalTaskHours(), "Total task duration should be 18 hours (8 + 10).");
    }
}
