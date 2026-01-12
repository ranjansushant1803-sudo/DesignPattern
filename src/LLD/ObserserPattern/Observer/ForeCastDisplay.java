package LLD.ObserserPattern.Observer;

import LLD.ObserserPattern.Observable.WeatherObservable;

public class ForeCastDisplay implements WeatherObserver{
    WeatherObservable observable;

    public ForeCastDisplay(WeatherObservable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println(" forecasted Rain");
    }
}
