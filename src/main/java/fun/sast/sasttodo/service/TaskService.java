package fun.sast.sasttodo.service;

import fun.sast.sasttodo.entity.PageBean;
import fun.sast.sasttodo.entity.Task;

import java.util.List;

public interface TaskService {



    // selectByUserId
    PageBean selectByUserId(String userId, Integer page, Integer pageSize);

    Task selectListById(Integer id);
    // addTask

    // updateTask

    // deleteTask
    void delete(List<Integer> ids) ;

    void insert(Task task);

    void update(Task task);
}
