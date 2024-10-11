import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SmartDevice sd = new SmartDevice();

        int action = 0;
        int count = -1;
        String defaultPassword = "device2024";
        int passwordCount = 0;
        String password;
        int maxDevices = 10;
        String[] DeviceDatabase = new String[maxDevices];
        long deviceID;
        String deviceName;
        String deviceType;
        String osVersion;
        float batteryLife;
        float price;
        boolean isInStock;

        while(action == 0){
            System.out.println("** WELCOME TO DEVICE MANAGER **\n(This device manager only can manage 10 devices)");
            System.out.println("What do you want to do?\n1. Add Devices\n2. Update Device\n3. Find Device By Type\n4. Find Affordable Devices\n5. Quit\nPlease enter your choice >");
            action = Integer.valueOf(input.nextLine());

            switch (action){
                case 1:
                    while(true){
                        System.out.println("Please enter your password: ");
                        password = input.nextLine();
                        if(defaultPassword.equals(password)){
                            System.out.println("How many devices do want to add?");
                            int devicesWantToAdd = Integer.valueOf(input.nextLine());
                            if((maxDevices - devicesWantToAdd) > 0){
                                for (int i = 0; i < devicesWantToAdd; i++){
                                    System.out.println("ID:");
                                    deviceID = Long.valueOf(input.nextLine());
                                    System.out.println("Name:");
                                    deviceName = input.nextLine();
                                    System.out.println("Type:");
                                    deviceType = input.nextLine();
                                    System.out.println("OS Version:");
                                    osVersion = input.nextLine();
                                    System.out.println("Battery Life:");
                                    batteryLife = Float.valueOf(input.nextLine());
                                    System.out.println("Price:");
                                    price = Float.valueOf(input.nextLine());
                                    System.out.println("Availability:");
                                    isInStock = Boolean.valueOf(input.nextLine());
                                }
                            }
                            action = 0;
                            break;
                        }else{
                            passwordCount++;
                            if(passwordCount == 3){
                                break;
                            }
                            if (passwordCount >= 4) {
                                System.out.println("Program detected suspicious activities and will terminate immediately!");
                                System.exit(0);
                            }
                        }
                    }
                    action = 0;
                    break;
                case 2:
                    System.out.println("Please enter your password: ");
                    for (int i = 0; i < sd.deviceInfo.length; i++){
                        System.out.println(sd.deviceInfo[i]);
                    }
                    action = 0;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }
}