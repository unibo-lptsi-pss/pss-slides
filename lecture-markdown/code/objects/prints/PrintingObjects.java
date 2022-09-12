import java.util.Date;
import java.util.Random;
// java.lang.System non va importata

class PrintingObjects{
    public static void main(String[] args){
        // Date
        Date d = new Date();
        System.out.println("Today: " + d);
        System.out.println("Milliseconds since 1/1/1970: " + d.getTime());
        // Random number generator
        Random r = new Random();
        System.out.println("Random number: " + r.nextInt());
        System.out.println("Another random: " + r.nextInt());
        System.out.println("A random in 0..99: " + r.nextInt(100));
        // System properties
        String javaVersion = System.getProperty("java.version");
        String osname = System.getProperty("os.name");
        String usrdir = System.getProperty("user.dir");
        System.out.println("Running Java " + javaVersion + " in " + osname + " from " + usrdir);
    }
}
