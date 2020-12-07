package com.chiang.designmodel.iterator;

public class Client {
    public static void main(String[] args) {
        IProject project = new Project();
        project.add("项目a",10,1000000);
        project.add("项目b",20,10000000);
        project.add("项目c",60,20000000);
        IProjectIterator projectIterator = project.iterator();
        while(projectIterator.hasNext()){
            IProject project1 = (IProject) projectIterator.next();
            System.out.println(project1.getProjectInfo());
        }
    }
}
