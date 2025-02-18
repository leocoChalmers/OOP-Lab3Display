public interface Loadable<T extends Car> {
    void loadVehicle(T vehicle);
    void unloadVehicle();
}
