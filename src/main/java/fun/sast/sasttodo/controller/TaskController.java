package fun.sast.sasttodo.controller;

import fun.sast.sasttodo.entity.PageBean;
import fun.sast.sasttodo.entity.Result;
import fun.sast.sasttodo.entity.Task;
import fun.sast.sasttodo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/selectById")
    public Result getTaskListById(@RequestParam Integer id) {
        log.info("根据id查询，id:{}", id);
        Task taskList = taskService.selectListById(id);
        return Result.success(taskList);
    }

    @GetMapping("/selectByUserId")
    public Result getTaskListByUserId(@RequestParam(defaultValue = "1") String userId,
                                      @RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("根据userId进行分页查询，参数：{},{},{}",userId, page, pageSize);
        PageBean pageBean =  taskService.selectByUserId(userId,page,pageSize);
        return Result.success(pageBean);
    }

    @PostMapping("/insert")
    Result addTask(@RequestBody Task task) {
        log.info("新增员工,task:{}", task);
        taskService.insert(task);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateTask(@RequestBody Task task) {
        log.info("更新员工信息:{}",task);
        taskService.update(task);
        return Result.success();
    }

    @DeleteMapping("/delete/{ids}")
    public Result deleteTask(@PathVariable List<Integer> ids) {
        log.info("批量删除操作，ids:{}",ids);
        taskService.delete(ids);
        return Result.success();
    }


}
