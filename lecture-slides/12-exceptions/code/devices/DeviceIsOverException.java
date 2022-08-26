public class DeviceIsOverException extends Exception {

    private Device device; // Il device che l'ha causata

    public DeviceIsOverException(Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return this.device;
    }
}