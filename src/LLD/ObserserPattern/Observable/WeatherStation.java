package LLD.ObserserPattern.Observable;

import LLD.ObserserPattern.Observer.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable {

    List<WeatherObserver> observerList;
    float temperature;
    float humidity;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public WeatherStation(){
        observerList = new ArrayList<>();
    }

    public void addObserver(WeatherObserver observer){
        observerList.add(observer);
    }

    public void removeObserver(WeatherObserver observer){
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(WeatherObserver observers:observerList) {
            observers.update();
        }
    }

    @Override
    public void setWeatherReadings(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println("New Weather update: temperature : "+temperature+" humidity : "+humidity);
        notifyObservers();
    }


}
