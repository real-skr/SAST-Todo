package fun.sast.sasttodo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.sast.sasttodo.entity.PageBean;
import fun.sast.sasttodo.entity.Task;
import fun.sast.sasttodo.mapper.TaskMapper;
import fun.sast.sasttodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    //selectListById
    @Override
    public Task selectListById(Integer id) {
        return taskMapper.selectById(id);
    }

    // selectByUserId
    @Override
    public PageBean selectByUserId(String userId, Integer page, Integer pageSize){
        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //查询
        List<Task> taskList = taskMapper.selectByUserId(userId);
        PageInfo<Task> pageInfo = new PageInfo<>(taskList);

        //封装pagebean
        return new PageBean(pageInfo.getTotal(), pageInfo.getList());
    }

    // addTask
    @Override
    public void insert(Task task){
        task.setCreateTime(LocalDateTime.now());
        task.setLastUpdateTime(LocalDateTime.now());
        taskMapper.insertTask(task);
    }

    // updateTask
    @Override
    public void update(Task task) {
        task.setLastUpdateTime(LocalDateTime.now());
        taskMapper.updateTask(task);
    }

    // deleteTask
    @Override
    public void delete(List<Integer> ids) {
        taskMapper.deleteTask(ids);
    }

}
