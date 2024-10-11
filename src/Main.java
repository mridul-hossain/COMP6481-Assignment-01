import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SmartDevice sd = new SmartDevice();

        int action = 0;
        int count = -1;

        while(action == 0){
            System.out.println("What you want to do?\n1. Store Device Information\n2. Show All Devices\n3. Quit");
            action = input.nextInt();

            switch (action){
                case 1:
                    System.out.println("Type device name:");
                    input.nextLine();
                    String deviceName = input.nextLine();
                    count++;
                    sd.storeDate(deviceName, count);
                    action = 0;
                    break;
                case 2:
                    System.out.println("All devices:");
                    for (int i = 0; i < sd.deviceInfo.length; i++){
                        System.out.println(sd.deviceInfo[i]);
                    }
                    action = 0;
                    break;
                case 3:
                    break;
            }
        }
    }
}