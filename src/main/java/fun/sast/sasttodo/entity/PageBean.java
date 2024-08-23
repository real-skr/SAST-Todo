package fun.sast.sasttodo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List<Task> taskList;
}
