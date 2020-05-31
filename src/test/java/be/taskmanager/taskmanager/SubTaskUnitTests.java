package be.taskmanager.taskmanager;

import be.taskmanager.taskmanager.domain.SubTask;
import be.taskmanager.taskmanager.domain.Task;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTaskUnitTests {

    @Test
    public void TestSubTaskSettersGetters(){
        SubTask subtask1 = new SubTask("title1", "desc1" );
        subtask1.setDescription("desc2");
        subtask1.setTitle("title2");

        assertEquals(subtask1.getTitle(), "title2");
        assertEquals(subtask1.getDescription(), "desc2");
    }
}
