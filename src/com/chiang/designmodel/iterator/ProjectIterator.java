package com.chiang.designmodel.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ProjectIterator implements IProjectIterator {
    private List<IProject> projectList = new ArrayList<IProject>();
    private int currentItem = 0;

    public ProjectIterator(List<IProject> projectList) {
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = true;
        if (currentItem >= projectList.size() || projectList.get(currentItem) == null) {
            hasNext = false;
        }
        return hasNext;
    }

    @Override
    public Object next() {
        IProject project = projectList.get(currentItem++);
        return project;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
