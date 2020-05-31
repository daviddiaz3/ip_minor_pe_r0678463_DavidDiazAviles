package be.taskmanager.taskmanager;

import be.taskmanager.taskmanager.domain.Task;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskUnitTests {

    @Test
    public void TestTaskSettersGetters(){
        Task task1 = new Task("title1", "desc1" , "11-11-11 12:12");
        task1.setId(1);
        task1.setTitle("title2");
        task1.setDueDate("12-11-11 12:12");
        task1.setDescription("desc2");

        assertEquals(task1.getId(), 1);
        assertEquals(task1.getTitle(), "title2");
        assertEquals(task1.getDescription(), "desc2");
        assertEquals(task1.getDueDate(), "12-11-11 12:12");
    }

}
