package com.example.demo.entities.tache;

import javax.persistence.*;

@Entity
public class TaskType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String className;
    private String description;
    private Boolean active;


    public TaskType() {
    }

    public TaskType(String className,String description, Boolean active) {
        this.className=className;
        this.description = description;
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    @Override
    public String toString() {
        return "TaskType{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
