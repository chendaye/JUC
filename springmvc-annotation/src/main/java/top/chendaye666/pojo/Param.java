package top.chendaye666.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    private int id;
    private String name;

    public Param(int i, String chendaye) {
        this.id = i;
        this.name = chendaye;
    }

    public void setId(String id) {
    }

    public void setName(String name) {
    }
}
