package be.taskmanager.taskmanager;

import be.taskmanager.taskmanager.domain.SubTask;
import be.taskmanager.taskmanager.dto.SubTaskDTO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTaskDTOUnitTests {

    @Test
    public void TestSubTaskSettersGetters(){
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setDescription("desc2");
        subTaskDTO.setTitle("title2");

        assertEquals(subTaskDTO.getTitle(), "title2");
        assertEquals(subTaskDTO.getDescription(), "desc2");
    }

}
