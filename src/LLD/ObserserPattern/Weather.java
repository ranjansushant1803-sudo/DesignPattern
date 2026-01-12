package LLD.ObserserPattern;

import LLD.ObserserPattern.Observable.WeatherObservable;
import LLD.ObserserPattern.Observable.WeatherStation;
import LLD.ObserserPattern.Observer.CurrentConditionsDisplayObserver;
import LLD.ObserserPattern.Observer.ForeCastDisplay;
import LLD.ObserserPattern.Observer.WeatherObserver;

public class Weather {
    public static void main(String[] args) {

        WeatherObservable observable = new WeatherStation();

        WeatherObserver currentWeatherObserver = new CurrentConditionsDisplayObserver(observable);
        WeatherObserver forecastObserver = new ForeCastDisplay(observable);

        observable.setWeatherReadings(21,15);

    }
}
