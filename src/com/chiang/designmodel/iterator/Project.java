package com.chiang.designmodel.iterator;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.List;

public class Project implements IProject {
    private List<IProject> projectList = new ArrayList<IProject>();

    private String name = "";

    private int num = 0;

    private int cost = 0;

    public Project() {
    }

    public Project(List<IProject> projectList) {
        this.projectList = projectList;
    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void add(String name, int num, int cost) {
        projectList.add(new Project(name, num, cost));
    }

    @Override
    public String getProjectInfo() {
        return String.format("项目%s，编号：%d,花费：%d", name, num, cost);
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
