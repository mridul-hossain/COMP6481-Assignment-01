import java.util.Arrays;

public class SmartDevice {
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
