import java.util.Random;
import java.util.Scanner;

public class IoTSignalProcessingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("=== IoT Signal Processing Simulation ===");
        System.out.println("Simulating Temperature Sensor Signals (in °C)");
        System.out.println("Press ENTER to capture 10 sensor readings...");
        sc.nextLine();
        
        double[] sensorData = new double[10];
        
        // Step 1: Simulate raw sensor data (like microcontroller ADC input)
        for (int i = 0; i < sensorData.length; i++) {
            sensorData[i] = 20 + rand.nextDouble() * 15; // Range: 20°C to 35°C
            // Adding some random noise
            if (rand.nextBoolean()) {
                sensorData[i] += rand.nextDouble() * 5;
            }
            System.out.printf("Raw Reading %d: %.2f °C%n", i+1, sensorData[i]);
        }
        
        // Step 2: Apply simple signal processing (noise filtering → average)
        double sum = 0;
        for (double val : sensorData) {
            sum += val;
        }
        double avgTemp = sum / sensorData.length;
        
        System.out.printf("%nProcessed Average Temperature: %.2f °C%n", avgTemp);
        
        // Step 3: Decision making (IoT action)
        if (avgTemp > 30) {
            System.out.println("⚠ ALERT: High Temperature! Sending signal to FAN → ON");
        } else if (avgTemp < 22) {
            System.out.println("INFO: Temperature is low. Sending signal to HEATER → ON");
        } else {
            System.out.println("✅ Temperature is Normal. No action required.");
        }
        
        sc.close();
    }
}
