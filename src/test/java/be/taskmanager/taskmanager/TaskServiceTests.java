package be.taskmanager.taskmanager;
import be.taskmanager.taskmanager.domain.SubTask;
import be.taskmanager.taskmanager.domain.Task;
import be.taskmanager.taskmanager.dto.SubTaskDTO;
import be.taskmanager.taskmanager.dto.TaskDTO;
import be.taskmanager.taskmanager.repository.TaskRepository;
import be.taskmanager.taskmanager.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTests {

    @TestConfiguration
    static class TaskServiceTestContextConfiguration {

        @Bean
        public TaskService taskService() {
            return new TaskService();
        }
    }

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    Task task1 = new Task("title1", "desc1" , "11-11-11 12:12");
    Task task2 = new Task("title2", "desc2" , "11-11-11 12:12");

    @Before
    public void setUp() {

        List<Task> tasks = new ArrayList<Task>();
        tasks.add(task1);
        tasks.add(task2);

        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setId(1);
        taskDTO1.setTitle("title1");
        taskDTO1.setDescription("desc1");
        taskDTO1.setDate("11-11-11 12:12");
        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setId(2);
        taskDTO2.setTitle("title2");
        taskDTO2.setDescription("desc2");
        taskDTO2.setDate("11-11-11 12:12");

        Mockito.when(taskRepository.findTaskById(task1.getId()))
                .thenReturn(task1);
        Mockito.when(taskRepository.findAll())
                .thenReturn(tasks);
        Mockito.when(taskRepository.save(task1))
                .thenReturn(task1);
    }

    @Test
    public void testGetTasks() {

        // method to be tested
        List<Task> tasks = taskService.getTasks();

        // checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(2, tasks.size());
        Task task = tasks.get(0);
        assertNotNull(task);
    }

    @Test
    public void testGetTask() {

        // method to be tested
        Task task = taskService.getTask(0);

        // checks
        assertNotNull(task);
        assertEquals(task.getId(), task1.getId());
        assertEquals(task.getTitle(), task1.getTitle());
    }

    @Test
    public void testAddTask() {

        // method to be tested
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setId(1);
        taskDTO1.setTitle("title1");
        taskDTO1.setDescription("desc1");
        taskDTO1.setDate("11-11-11 12:12");
        taskService.addTask(taskDTO1);

        // no error
        // checks
        assertTrue(true);
    }

    @Test
    public void testAddSubTask() {

        // method to be tested
        SubTaskDTO subTaskDTO  = new SubTaskDTO();
        subTaskDTO.setDescription("desc");
        subTaskDTO.setTitle("title");

        taskService.addSubTask(0, subTaskDTO );

        // no error
        // checks
        assertTrue(true);
    }
}
