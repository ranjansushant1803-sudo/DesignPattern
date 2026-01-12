package LLD.ObserserPattern.Observable;

import LLD.ObserserPattern.Observer.WeatherObserver;

public interface WeatherObservable {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
    void setWeatherReadings(float temperature, float humidity);
}
