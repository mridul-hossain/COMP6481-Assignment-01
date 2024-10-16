//
// Assignment (01)
// © Md Mridul Hossain
// Written by: (Md Mridul Hossain, 40261486)
//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int action = 0;
        int count = -1;
        String defaultPassword = "device2024";
        int passwordCount = 0;
        int suspiciousCount = 0;
        String password;

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
                                SmartDevice sd = new SmartDevice();
                                System.out.println("Please type the following information >");
                                //comparing device id if it already exist or not
                                while(true) {
                                    System.out.println("ID:");
                                    sd.setDeviceId(Long.valueOf(input.nextLine()));
                                    int comparisonResult = sd.compareDevice();
                                    if(comparisonResult == 0){
                                        break;
                                    }else{
                                        System.out.println("A device with the same ID exist in the database. Please type different ID number.");
                                    }
                                }
                                System.out.println("Name:");
                                sd.setDeviceName(input.nextLine());
                                System.out.println("Type:");
                                sd.setDeviceType(input.nextLine());
                                System.out.println("OS Version:");
                                sd.setOsVersion(input.nextLine());
                                System.out.println("Battery Life:");
                                sd.setBatteryLife(Float.valueOf(input.nextLine()));
                                System.out.println("Price:");
                                sd.setPrice(Float.valueOf(input.nextLine()));
                                System.out.println("Availability:");
                                sd.setIsInStock(Boolean.valueOf(input.nextLine()));

                                String result = sd.addDevice(i);
                                System.out.println(result);
                            }
                        }else{
                            int availableSpaceToAddDevices = (SmartDevice.maxDevices - dataCount);
                            System.out.println("You can add more " + availableSpaceToAddDevices + " devices");
                        }
                        action = 0;
                        break;
                    }else{
                        passwordCount++;
                        suspiciousCount++;
                        if(passwordCount == 3){
                            passwordCount = 0;
                            if (suspiciousCount == 12) {
                                suspiciousCount = 0;
                                System.out.println("Program detected suspicious activities and will terminate immediately!");
                                System.exit(0);
                            }
                            break;
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

                            //getting the device info from the device database
                            int indexCount = 0;
                            String[] deviceInfo = null;
                            while(SmartDevice.DeviceDatabase[indexCount] != null){
                                deviceInfo = SmartDevice.DeviceDatabase[indexCount].split("\\|");
                                if(Long.valueOf(deviceInfo[0]).equals(devicesIdToEdit)){
                                    break;
                                }
                                indexCount++;
                            }
                            //end of getting device info

                            if(deviceInfo == null){
                                System.out.println("No device found with the following ID.\nDo you want to update another device?\n1. Yes\n2. No");
                                int decision = Integer.valueOf(input.nextLine());
                                if(decision == 2){
                                    break;
                                }
                            }else{
                                System.out.println("SmartDevice: #" + indexCount + "\nID:" + deviceInfo[0] + "\nDevice Name:" + deviceInfo[1] + "\nDevice Type:" + deviceInfo[2] +  "\nOS Version:" + deviceInfo[3] +  "\nBattery Life:" + deviceInfo[4] +  "\nPrice:" + deviceInfo[5] +  "\nAvailability:" + deviceInfo[6]);
                                while(true){
                                    System.out.println("What information would you like to change?\n1. Device Name\n2. Device Type\n3. OS Version\n4. Battery Life\n5. Price\n6. Availability\n7. Quit\nEnter your choice >");
                                    int choice = Integer.valueOf(input.nextLine());

                                    //appointing attribute values
                                    SmartDevice sd = new SmartDevice();
                                    sd.setDeviceId(Long.valueOf(deviceInfo[0]));
                                    sd.setDeviceName(deviceInfo[1]);
                                    sd.setDeviceType(deviceInfo[2]);
                                    sd.setOsVersion(deviceInfo[3]);
                                    sd.setBatteryLife(Float.valueOf(deviceInfo[4]));
                                    sd.setPrice(Float.valueOf(deviceInfo[5]));
                                    sd.setIsInStock(Boolean.valueOf(deviceInfo[6]));
                                    //end of appointment

                                    //choice wise changing the attribute values
                                    if(choice == 1){
                                        System.out.println("Type New Device Name:");
                                        sd.setDeviceName(input.nextLine());
                                    }
                                    if(choice == 2){
                                        System.out.println("Type New Device Type:");
                                        sd.setDeviceType(input.nextLine());
                                    }
                                    if(choice == 3){
                                        System.out.println("Type New OS Version:");
                                        sd.setOsVersion(input.nextLine());
                                    }
                                    if(choice == 4){
                                        System.out.println("Type New Battery Life:");
                                        sd.setBatteryLife(Float.valueOf(input.nextLine()));
                                    }
                                    if(choice == 5){
                                        System.out.println("Type New Price:");
                                        sd.setPrice(Float.valueOf(input.nextLine()));
                                    }
                                    if(choice == 6){
                                        System.out.println("Type New Availability:");
                                        sd.setIsInStock(Boolean.valueOf(input.nextLine()));
                                    }
                                    if(choice == 7){
                                        break;
                                    }
                                    //end

                                    String result = sd.updateDevice(indexCount);
                                    deviceInfo = SmartDevice.DeviceDatabase[indexCount].split("\\|");
                                    System.out.println(result + "\nSmartDevice: #" + indexCount + "\nID:" + deviceInfo[0] + "\nDevice Name:" + deviceInfo[1] + "\nDevice Type:" + deviceInfo[2] +  "\nOS Version:" + deviceInfo[3] +  "\nBattery Life:" + deviceInfo[4] +  "\nPrice:" + deviceInfo[5] +  "\nAvailability:" + deviceInfo[6]);
                                }
                                break;
                            }
                        }
                        action = 0;
                        break;
                    }else{
                        passwordCount++;
                        suspiciousCount++;
                        if(passwordCount == 3){
                            passwordCount = 0;
                            if (suspiciousCount == 12) {
                                suspiciousCount = 0;
                                System.out.println("Program detected suspicious activities and will terminate immediately!");
                                System.exit(0);
                            }
                            break;
                        }
                    }
                }
                action = 0;
            }
            if(action == 3){
                System.out.println("Please type device type:");
                String deviceType = input.nextLine();

                String[] result = SmartDevice.findSearchDevicesByType(deviceType);

                //checking if the result is empty or not
                boolean emptyCheck = true;
                for(int i = 0; i < result.length; i++){
                    if(result[i] != null){
                        emptyCheck = false;
                    }
                }
                // end of checking if the result is empty or not

                if(emptyCheck == false){
                    int indexCount = 0;
                    while (result[indexCount] != null) {
                        System.out.println(result[indexCount]);
                        indexCount++;
                    }
                }else{
                    System.out.println("No device(s) found for following device type.");
                }

                action = 0;
            }
            if(action == 4){
                System.out.println("Please type your affordable price:");
                float maxPrice = Float.valueOf(input.nextLine());

                String[] result = SmartDevice.affordableDevices(maxPrice);

                //checking if the result is empty or not
                boolean emptyCheck = true;
                for(int i = 0; i < result.length; i++){
                    if(result[i] != null){
                        emptyCheck = false;
                    }
                }
                // end of checking if the result is empty or not

                if(emptyCheck == false){
                    int indexCount = 0;
                    while (result[indexCount] != null) {
                        System.out.println(result[indexCount]);
                        indexCount++;
                    }
                }else{
                    System.out.println("No device(s) found in affordable price.");
                }

                action = 0;
            }
            if(action == 5){
                break;
            }
            action = 0;
        }
    }
}