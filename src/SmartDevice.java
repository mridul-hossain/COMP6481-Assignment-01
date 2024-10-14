//
// Assignment (01)
// © Md Mridul Hossain
// Written by: (Md Mridul Hossain, 40261486)
//

public class SmartDevice {

    private long deviceID;
    private String deviceName;
    private String deviceType;
    private String osVersion;
    private float batteryLife;
    private float price;
    private boolean isInStock;
    public static int maxDevices = 10;
    public static String[] DeviceDatabase = new String[maxDevices];
    public static int deviceCount = 0;

    public SmartDevice(){
        deviceID = 0;
        deviceName = "";
        deviceType = "";
        osVersion = "";
        batteryLife = 0;
        price = 0;
        isInStock = false;
    }

    public SmartDevice(long deviceID, String deviceName, String deviceType, String osVersion, float batteryLife, float price, boolean isInStock){
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
        this.batteryLife = batteryLife;
        this.price = price;
        this.isInStock = isInStock;
    }

    public void setDeviceId(long deviceID){
        this.deviceID = deviceID;
    }
    public long getDeviceID(){
        return deviceID;
    }

    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public String getDeviceName(){
        return deviceName;
    }

    public void setDeviceType(String deviceType){
        this.deviceType = deviceType;
    }
    public String getDeviceType(){
        return deviceType;
    }

    public void setOsVersion(String osVersion){
        this.osVersion = osVersion;
    }
    public String getOsVersion(){
        return osVersion;
    }

    public void setBatteryLife(float batteryLife){
        this.batteryLife = batteryLife;
    }
    public float getBatteryLife(){
        return batteryLife;
    }

    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }

    public void setIsInStock(boolean isInStock){
        this.isInStock = isInStock;
    }
    public boolean getIsInStock(){
        return isInStock;
    }

    //method for adding devices in the device database
    public String addDevice(int indexNumber){
        DeviceDatabase[indexNumber] = deviceID + "|" + deviceName + "|" + deviceType + "|" + osVersion + "|" + batteryLife + "|" + price + "|" + isInStock;
        deviceCount++;

        return "Device added successfully";
    }

    //method for updating device information
    public String updateDevice(int indexNumber){
        DeviceDatabase[indexNumber] = deviceID + "|" + deviceName + "|" + deviceType + "|" + osVersion + "|" + batteryLife + "|" + price + "|" + isInStock;
        return "Device information changed successfully";
    }

    //method for searching the devices by type
    public static String[] findSearchDevicesByType(String type){
        String[] devices = new String[maxDevices];
        int count = 0;
        int countForNewArray = 0;
        while(DeviceDatabase[count] != null){
            String[] deviceInfo = DeviceDatabase[count].split("\\|");
            if(deviceInfo[2].equals(type)){
                devices[countForNewArray] = DeviceDatabase[count];
                countForNewArray++;
            }
            count++;
        }

        return devices;
    }

    //methods for comparing devices if they are the same or not
    public int compareDevice(){
        int count = 0;
        while(DeviceDatabase[count] != null){
            String[] deviceInfo = DeviceDatabase[count].split("\\|");
            if(Long.valueOf(deviceInfo[0]).equals(deviceID)){
                return 1;
            }
            count++;
        }

        return 0;
    }

    //method for finding affordable devices
    public static String[] affordableDevices(float maxPrice){
        String[] devices = new String[maxDevices];
        int count = 0;
        while(DeviceDatabase[count] != null){
            String[] deviceInfo = DeviceDatabase[count].split("\\|");
            if(Float.valueOf(deviceInfo[5]) <= maxPrice){
                devices[count] = DeviceDatabase[count];
            }
            count++;
        }

        return devices;
    }

    //method for getting the number of smart devices
    public static int getNumberOfSmartDevices(){
        return deviceCount;
    }
}
