package LLD.Designs.VehicleRentalSystem;

import LLD.Designs.VehicleRentalSystem.Vehicles.VehicleType;
import LLD.Designs.VehicleRentalSystem.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<Store> stores;
    List<User> users;

    public VehicleRentalSystem(){

        stores = new ArrayList<>();
        users = new ArrayList<>();
    }

    public Store getStore(int storeId) {
        return stores.stream().filter(store -> store.getStoreId() == storeId).findFirst().get();
    }

    public User getUser(int userId) {
        return users.get(userId);
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeStore(int storeId) {
        stores.remove(storeId);
    }

    public void removeUser(int userId) {
        users.remove(userId);
    }

}
