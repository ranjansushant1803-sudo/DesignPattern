package LLD.ObserserPattern.Observer;

import LLD.ObserserPattern.Observable.StocksObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    String userName;
    StocksObservable obj;
    public EmailAlertObserver(String userName, StocksObservable obj){
        this.userName = userName;
        this.obj=obj;
        this.obj.add(this);
    }
    public void update(){
        sendAlertOnEmail(userName,"Product is in Stock");
    }

    public void sendAlertOnEmail(String userName, String msg){
        System.out.println("Email - Hey "+userName+" "+msg);
    }
}
