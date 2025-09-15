import java.util.*;

// Base Device Class
class Device {
    protected String name;
    protected boolean status; // true = ON, false = OFF

    public Device(String name) {
        this.name = name;
        this.status = false;
    }

    public void turnOn() {
        status = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        status = false;
        System.out.println(name + " is now OFF.");
    }

    public void getStatus() {
        System.out.println(name + " status: " + (status ? "ON" : "OFF"));
    }

    public String getName() {
        return name;
    }
}

// Sensor Class
abstract class Sensor {
    protected String name;

    public Sensor(String name) {
        this.name = name;
    }

    public abstract void readData(); // Each sensor will define its own reading
    public String getName() {
        return name;
    }
}

// Temperature Sensor
class TemperatureSensor extends Sensor {
    Random rand = new Random();

    public TemperatureSensor(String name) {
        super(name);
    }

    @Override
    public void readData() {
        int temp = 18 + rand.nextInt(15); // Random temp between 18-32
        System.out.println(name + " reading: " + temp + "°C");
    }
}

// Motion Sensor
class MotionSensor extends Sensor {
    Random rand = new Random();

    public MotionSensor(String name) {
        super(name);
    }

    @Override
    public void readData() {
        boolean motion = rand.nextBoolean();
        System.out.println(name + " detected motion: " + (motion ? "YES" : "NO"));
    }
}

// Door Lock Sensor
class DoorLockSensor extends Sensor {
    Random rand = new Random();

    public DoorLockSensor(String name) {
        super(name);
    }

    @Override
    public void readData() {
        boolean locked = rand.nextBoolean();
        System.out.println(name + " status: " + (locked ? "LOCKED" : "UNLOCKED"));
    }
}

public class SmartHomeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // IoT Devices
        HashMap<Integer, Device> devices = new HashMap<>();
        devices.put(1, new Device("Living Room Light"));
        devices.put(2, new Device("Bedroom Fan"));
        devices.put(3, new Device("Smart TV"));
        devices.put(4, new Device("Air Conditioner"));

        // IoT Sensors
        HashMap<Integer, Sensor> sensors = new HashMap<>();
        sensors.put(1, new TemperatureSensor("Temperature Sensor"));
        sensors.put(2, new MotionSensor("Motion Sensor"));
        sensors.put(3, new DoorLockSensor("Door Lock Sensor"));

        int choice;
        do {
            System.out.println("\n=== IoT Smart Home Console ===");
            System.out.println("1. Turn ON Device");
            System.out.println("2. Turn OFF Device");
            System.out.println("3. Check Device Status");
            System.out.println("4. List All Devices");
            System.out.println("5. Read Sensor Data");
            System.out.println("6. List All Sensors");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showDevices(devices);
                    System.out.print("Enter device number to turn ON: ");
                    int onId = sc.nextInt();
                    if (devices.containsKey(onId)) devices.get(onId).turnOn();
                    else System.out.println("Invalid device!");
                    break;

                case 2:
                    showDevices(devices);
                    System.out.print("Enter device number to turn OFF: ");
                    int offId = sc.nextInt();
                    if (devices.containsKey(offId)) devices.get(offId).turnOff();
                    else System.out.println("Invalid device!");
                    break;

                case 3:
                    showDevices(devices);
                    System.out.print("Enter device number to check status: ");
                    int statusId = sc.nextInt();
                    if (devices.containsKey(statusId)) devices.get(statusId).getStatus();
                    else System.out.println("Invalid device!");
                    break;

                case 4:
                    showDevices(devices);
                    break;

                case 5:
                    showSensors(sensors);
                    System.out.print("Enter sensor number to read data: ");
                    int sensorId = sc.nextInt();
                    if (sensors.containsKey(sensorId)) sensors.get(sensorId).readData();
                    else System.out.println("Invalid sensor!");
                    break;

                case 6:
                    showSensors(sensors);
                    break;

                case 0:
                    System.out.println("Exiting Smart Home App. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void showDevices(HashMap<Integer, Device> devices) {
        System.out.println("\nAvailable Devices:");
        for (Integer id : devices.keySet()) {
            System.out.println(id + ". " + devices.get(id).getName());
        }
    }

    private static void showSensors(HashMap<Integer, Sensor> sensors) {
        System.out.println("\nAvailable Sensors:");
        for (Integer id : sensors.keySet()) {
            System.out.println(id + ". " + sensors.get(id).getName());
        }
    }
}
