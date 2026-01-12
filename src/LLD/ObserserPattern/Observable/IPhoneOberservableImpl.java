package LLD.ObserserPattern.Observable;

import LLD.ObserserPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneOberservableImpl implements StocksObservable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount=0;
    public void add(NotificationAlertObserver obj){
        observerList.add(obj);
    }
    public void remove(NotificationAlertObserver obj){
        observerList.remove(obj);
    }

    public void notifySubscribers(){
        for(NotificationAlertObserver observer:observerList){
            observer.update();
        }
    }

    public void setStockCount(int newStockCount){
        if(stockCount==0){
            System.out.println("In Stock- counter "+newStockCount);
            notifySubscribers();
        }
        if(newStockCount==0)
            stockCount=0;
        stockCount+=newStockCount;
    }

    public int getStockCount(){
        return stockCount;
    }
}
