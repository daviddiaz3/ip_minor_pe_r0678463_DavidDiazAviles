package be.taskmanager.taskmanager;

import be.taskmanager.taskmanager.domain.Task;
import be.taskmanager.taskmanager.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void TestFindTaskById() {
        // given
        Task task1 = new Task("title1", "desc1" , "11-11-11 12:12");
        entityManager.persist(task1);
        entityManager.flush();

        // when
        Task found = taskRepository.findTaskById(task1.getId());

        // then
        assertEquals(found, task1);
    }

}
