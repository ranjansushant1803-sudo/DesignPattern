package LLD.ObserserPattern.Observer;

import LLD.ObserserPattern.Observable.StocksObservable;

public class MobileAlertObserver implements NotificationAlertObserver{
    String userName;
    StocksObservable obj;
    public MobileAlertObserver(String userName, StocksObservable obj){
        this.userName = userName;
        this.obj=obj;
        this.obj.add(this);
    }
    public void update(){
        sendAlertOnSMS(userName,"Product is in Stock");
    }

    public void sendAlertOnSMS(String userName, String msg){
        System.out.println("SMS - Hey "+userName+" "+msg);
    }
}
