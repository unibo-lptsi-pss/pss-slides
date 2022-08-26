public class UseDevice {
	public static void main(String[] args) {
		DeviceRow dr = new DeviceRow(3);
		System.out.println(dr); 
		// DeviceRow [off.3, off.3, off.3, off.3]
		try{
		    dr.allOn();
		    dr.allOff();
		    dr.allOn();
		    dr.allOff();
		    dr.getDevice(0).on();
		    dr.getDevice(0).off();
		    dr.getDevice(1).on();
		    dr.getDevice(1).off();
		    System.out.println(dr);
		    // DeviceRow [off.0, off.0, off.1, off.1]
		    dr.allOn(); // Eccezione
		} catch (DeviceIsOverException e){
		    System.out.println("Eccezione...");
		}
		System.out.println(dr); 
		// DeviceRow [over.0, over.0, on .0, on .0]
	}
}
