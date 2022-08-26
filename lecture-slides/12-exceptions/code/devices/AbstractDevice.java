public abstract class AbstractDevice implements Device {

    private boolean on;
    private boolean over; // over implies not on

    public AbstractDevice() {
        this.on = false;
        this.over = false;
    }

    final public boolean isOn() {
        return this.on; // getter
    }

    final public boolean isOver() { // getter
        return this.over;
    }

    final public void off() {
        this.on = false; // setter
    }

    final public void on() throws DeviceIsOverException {
        if (!this.on) { // è spento?
            this.over = this.onFails(); // è esaurito?
            this.on = !this.over; 	// sincronizzo on
        }
        if (!this.on) { // l'ho acceso?
            throw new DeviceIsOverException(this); // eccezione
        }
    }

    /* Se scatta l'on() ora, diventerà over()? */
    protected abstract boolean onFails();

    public String toString() {
        return this.over ? "over" : this.on ? "on " : "off";
    }
}
