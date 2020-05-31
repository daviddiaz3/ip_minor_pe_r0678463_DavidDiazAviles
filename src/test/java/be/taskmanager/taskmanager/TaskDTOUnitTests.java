package be.taskmanager.taskmanager;

import be.taskmanager.taskmanager.domain.Task;
import be.taskmanager.taskmanager.dto.TaskDTO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskDTOUnitTests {

    @Test
    public void TestTaskDTOSettersGetters(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1);
        taskDTO.setTitle("title2");
        taskDTO.setDate("12-11-11 12:12");
        taskDTO.setDescription("desc2");

        assertEquals(taskDTO.getId(), 1);
        assertEquals(taskDTO.getTitle(), "title2");
        assertEquals(taskDTO.getDescription(), "desc2");
        assertEquals(taskDTO.getDate(), "12-11-11 12:12");
    }
}
