package com.taskmanager;

import com.taskmanager.controller.TaskController;
import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



import java.util.Arrays;

class TaskControllerTest {




        @Mock
        private TaskService taskService;

        @InjectMocks
        private TaskController taskController;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testGetAllTasks() {
            Task task1 = new Task(1L, "Task 1", "Description 1", false);
            Task task2 = new Task(2L, "Task 2", "Description 2", true);
            List<Task> tasks = Arrays.asList(task1, task2);

            when(taskService.getAllTasks()).thenReturn(tasks);

            List<Task> result = taskController.getAllTasks();

            assertEquals(2, result.size());
            verify(taskService, times(1)).getAllTasks();
        }

        @Test
        void testGetTaskById() {
            Task task = new Task(1L, "Task 1", "Description 1", false);
            when(taskService.getTaskById(1L)).thenReturn(Optional.of(task));

            ResponseEntity<Task> response = taskController.getTaskById(1L);

            assertEquals(200, response.getStatusCodeValue());
            assertEquals("Task 1", Objects.requireNonNull(response.getBody()).getTitle());
        }

        @Test
        void testCreateTask() {
            Task task = new Task(1L, "Task 1", "Description 1", false);
            when(taskService.createTask(any(Task.class))).thenReturn(task);

            Task result = taskController.createTask(task);

            assertEquals("Task 1", result.getTitle());
            verify(taskService, times(1)).createTask(task);
        }

        @Test
        void testDeleteTask() {
            doNothing().when(taskService).deleteTask(1L);

            ResponseEntity<Void> response = taskController.deleteTask(1L);

            assertEquals(204, response.getStatusCodeValue());
            verify(taskService, times(1)).deleteTask(1L);
        }

    @Test
    void shouldReturnUpdatedTask_WhenTaskExists() {
        // given
        Long taskId = 1L;
        Task taskDetails = new Task(1L, "Updated title", "Updated description", false);
        Optional<Task> updatedTask = Optional.of(taskDetails);

        when(taskService.updateTask(taskId, taskDetails)).thenReturn(updatedTask);

        // when
        ResponseEntity<Task> response = taskController.updateTask(taskId, taskDetails);

        // then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(taskDetails, response.getBody());
    }

    @Test
    void shouldReturnNotFound_WhenTaskDoesNotExist() {
        // given
        Long taskId = 99L;
        Task taskDetails = new Task(taskId, "Title", "Description", false);

        when(taskService.updateTask(taskId, taskDetails)).thenReturn(Optional.empty());

        // when
        ResponseEntity<Task> response = taskController.updateTask(taskId, taskDetails);

        // then
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }



}
