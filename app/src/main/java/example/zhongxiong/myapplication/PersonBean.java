package example.zhongxiong.myapplication;

import java.io.Serializable;

/**
 * Created by : xiaoyehai
 * Create date : 2019/9/11 20:40
 * description :实体类
 */
public class PersonBean implements Serializable {

    private int id; //主键，自增长，不需要设置

    private String name;

    private int age;
    private String content;

    public PersonBean( String content,String name) {
        this.name = name;
        this.content = content;
    }

    public PersonBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonBean(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

