package com.jwt.securirty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.task.enums.Priority;
import com.task.enums.Status;
import com.task.exception.DBOperationFailedException;
import com.task.exception.InvalidIdException;
import com.task.model.Task;
import com.task.repo.TaskRepository;
import com.task.service.TaskService;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService; 

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    //Get all the task data
    @Test
    public void getAllTaskTest() {
       
        Task t1 = new Task();
        t1.setTaskId(1);
        t1.setTitle("Review the document");
        t1.setDescription("Each team reviews the document");

        Task t2 = new Task();
        t2.setTaskId(2);
        t2.setTitle("Submit the report");
        t2.setDescription("Submit the weekly report to the manager");

        List<Task> list = Arrays.asList(t1, t2);

       
        when(taskService.getAllTask()).thenReturn(list);

       
        List<Task> tasks = taskService.getAllTask();

       
        int expectedNum = 2;
        int actualNum = tasks.size();
        assertEquals(expectedNum, actualNum);
       
    }
    
    @Test
    public void getByTaskId() throws InvalidIdException {
       
        Task task = new Task();
        task.setTaskId(1);
        task.setTitle("Review the document");
        task.setDescription("Each team reviews the document");

        when(taskService.getByTaskId(1)).thenReturn(task);

        Task foundTask = taskService.getByTaskId(1);

        List<Task> taskList = Arrays.asList(foundTask);

       
        int expectedNum = 1; 
        int actualNum = taskList.size();

        
        assertEquals(expectedNum, actualNum);
       
        
    }
    
 
   


    
  

   

}

	


