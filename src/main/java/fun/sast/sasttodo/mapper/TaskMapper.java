package fun.sast.sasttodo.mapper;

import fun.sast.sasttodo.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    // selectListById
    @Select("select * from Task where id=#{id}")
    Task selectById(Integer id);

    // selectByUser_id
    @Select("select * from Task where user_id=#{userId}")
    List<Task> selectByUserId(String userId);

    // insert
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into Task(user_id, title, description, status, due_date, create_time, last_update_time)"+
            " values (#{userId},#{title},#{description},#{status},#{dueDate},#{createTime},#{lastUpdateTime})")
    void insertTask(Task task);

    // update
    void updateTask(Task task);

    // deleteById
    void deleteTask(List<Integer> ids);
}
