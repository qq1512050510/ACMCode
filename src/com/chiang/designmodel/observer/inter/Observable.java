package com.chiang.designmodel.observer.inter;


public interface Observable {
    public void addObserver(IObserverUpdate observer);
    public void deleteObserver(IObserverUpdate observer);
    public void notifyObservers(String context);
}
