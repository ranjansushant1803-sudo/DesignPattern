package LLD.ObserserPattern.Observable;

import LLD.ObserserPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver obj);
    public void remove(NotificationAlertObserver obj);
    public void notifySubscribers();
    public void setStockCount(int stockCount);
    public int getStockCount();
}
