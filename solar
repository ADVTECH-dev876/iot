import java.util.Random;
import java.util.Scanner;

public class SolarPanelController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== Solar Panel Controller Simulation ===");
        System.out.println("Simulating Light Sensor (0 - 1000 lux)");
        System.out.println("Press ENTER to capture 10 readings...");
        sc.nextLine();

        int[] lightData = new int[10];

        // Step 1: Simulate raw sensor data
        for (int i = 0; i < lightData.length; i++) {
            lightData[i] = rand.nextInt(1001); // 0 to 1000 lux
            System.out.printf("Reading %d: %d lux%n", i + 1, lightData[i]);
        }

        // Step 2: Simple processing (average brightness)
        int sum = 0;
        for (int val : lightData) {
            sum += val;
        }
        int avgLight = sum / lightData.length;

        System.out.printf("%nProcessed Average Light: %d lux%n", avgLight);

        // Step 3: IoT Decision
        if (avgLight > 500) {
            System.out.println("☀ Sufficient sunlight detected → Solar Panel ON");
        } else {
            System.out.println("🌙 Low sunlight → Solar Panel OFF (switching to battery)");
        }

        sc.close();
    }
}
