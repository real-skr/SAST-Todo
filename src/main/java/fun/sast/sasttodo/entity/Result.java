package fun.sast.sasttodo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result  {
    //0失败 1成功
    private Integer code;
    private String msg;
    private Object data;

    //增删改成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }

    //查询
    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    //失败响应
    public static Result error(String msg){return new Result(0,msg,null);}
}
