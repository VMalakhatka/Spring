package org.example.service;

import org.example.dto.CreateResponce;
import org.example.dto.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private Map<Long,Task> tasks;
    private AtomicLong id;

    public TaskService() {
        this.tasks = new HashMap<>();
        id=new AtomicLong(0L);
    }

    public Map<Long,Task> getTasks() {
        return new HashMap<>(tasks);
    }

    public Task getTask(long id){
        return tasks.get(id);
    }

    public CreateResponce creatTask(Task task){
        long id = this.id.getAndIncrement();
        tasks.put(id,task);
        return new CreateResponce(id,task);
    }


}
