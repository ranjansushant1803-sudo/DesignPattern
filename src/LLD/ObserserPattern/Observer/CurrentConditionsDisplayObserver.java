package LLD.ObserserPattern.Observer;

import LLD.ObserserPattern.Observable.WeatherObservable;

public class CurrentConditionsDisplayObserver implements WeatherObserver{

    WeatherObservable observable;

    public CurrentConditionsDisplayObserver(WeatherObservable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println(" Current weather ");
    }
}
