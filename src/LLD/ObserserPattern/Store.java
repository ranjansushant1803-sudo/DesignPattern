package LLD.ObserserPattern;

import LLD.ObserserPattern.Observable.IPhoneOberservableImpl;
import LLD.ObserserPattern.Observable.StocksObservable;
import LLD.ObserserPattern.Observer.EmailAlertObserver;
import LLD.ObserserPattern.Observer.MobileAlertObserver;
import LLD.ObserserPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable stockObj = new IPhoneOberservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserver("Sushant",stockObj);
        NotificationAlertObserver observer2 = new EmailAlertObserver("Arpit",stockObj);
        NotificationAlertObserver observer3 = new MobileAlertObserver("Sanu",stockObj);
        
        stockObj.setStockCount(10);
        stockObj.setStockCount(0);
        stockObj.setStockCount(100);
    }
}
