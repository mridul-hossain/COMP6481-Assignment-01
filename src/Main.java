import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int action = 0;
        int count = -1;
        String defaultPassword = "device2024";
        int passwordCount = 0;
        String password;
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

            if(action == 1){
                while(true){
                    System.out.println("Please enter your password: ");
                    password = input.nextLine();
                    if(defaultPassword.equals(password)){
                        System.out.println("How many devices do want to add?");
                        int devicesWantToAdd = Integer.valueOf(input.nextLine());

                        //counting how many device information is already stored in the device database
                        int dataCount = 0;
                        while(SmartDevice.DeviceDatabase[dataCount] != null){
                            dataCount++;
                        }
                        //end of counting how many device information is already stored in the device database

                        if((SmartDevice.maxDevices - (devicesWantToAdd + dataCount)) >= 0){
                            for (int i = dataCount; i < (devicesWantToAdd + dataCount); i++){
                                System.out.println("Please type the following information >");
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

                                //creating objects of devices
                                new SmartDevice(deviceID, deviceName, deviceType, osVersion, batteryLife, price, isInStock, i);
                            }
                        }
                        System.out.println("Device(s) added successfully.");
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
            }
            if(action == 2){
                while(true){
                    System.out.println("Please enter your password: ");
                    password = input.nextLine();
                    if(defaultPassword.equals(password)){
                        while(true){
                            System.out.println("Type the device ID that you want to update:");
                            long devicesIdToEdit = Long.valueOf(input.nextLine());

                            //checking if the database is empty or not
                            int indexCount = 0;
                            String[] deviceInfo = null;
                            while(SmartDevice.DeviceDatabase[indexCount] != null){
                                deviceInfo = SmartDevice.DeviceDatabase[indexCount].split("\\|");
                                if(deviceInfo[0].equals(devicesIdToEdit)){
                                    break;
                                }
                                indexCount++;
                            }
                            //end of checking if the database is empty or not

                            if(deviceInfo == null){
                                System.out.println("No device found with the following ID.\nDo you want to update another device?\n1. Yes\n2. No");
                                int decision = Integer.valueOf(input.nextLine());
                                if(decision == 2){
                                    break;
                                }
                            }else{
                                System.out.println("SmartDevice: #" + indexCount + "\nID:" + deviceInfo[0] + "\nDevice Name:" + deviceInfo[1] + "\nDevice Type:" + deviceInfo[2] +  "\nOS Version:" + deviceInfo[3] +  "\nBattery Life:" + deviceInfo[4] +  "\nPrice:" + deviceInfo[5] +  "\nAvailability:" + deviceInfo[6]);
                                break;
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
            }
            if(action == 3){

            }
            if(action == 4){

            }
            if(action == 5){
                break;
            }
        }

//        System.out.println(Arrays.toString(SmartDevice.DeviceDatabase));
    }
}