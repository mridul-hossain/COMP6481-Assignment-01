import java.util.Arrays;

public class SmartDevice {

    private long deviceID;
    private String deviceName;
    private String deviceType;
    private String osVersion;
    private float batteryLife;
    private float price;
    private boolean isInStock;

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

    int size = 1;
    public String[] deviceInfo = new String[size];

    public String storeDate(String deviceName, int index){
        if(!deviceName.isEmpty()){
            int arraySize = deviceInfo.length;
            String[] cloneDeviceInfo = Arrays.copyOf(deviceInfo, arraySize);
            deviceInfo = new String[size++];
            for(int i = 0; i < cloneDeviceInfo.length; i++){
                deviceInfo[i] = cloneDeviceInfo[i];
            }
            deviceInfo[index] = deviceName;
        }else{
            deviceInfo[index] = deviceName;
        }

        return "Device stored successfully";
    }
}
