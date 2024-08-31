// 96. 주차 요금 계산

import java.util.*;

class Solution {
    static Map<String, Integer> parkingInTime;
    static Map<String, Integer> parkingTotalTime;

    public int[] solution(int[] fees, String[] records) {
        parkingInTime = new HashMap<>();
        parkingTotalTime = new HashMap<>();
        
        for (String record : records) {
            String[] infoArr = record.split(" ");
            String[] curTime = infoArr[0].split(":");
            String number = infoArr[1];
            boolean isEnter = infoArr[2].equals("IN");
            int curMinutes = Integer.parseInt(curTime[0]) * 60 + Integer.parseInt(curTime[1]);
            
            if (isEnter) {
                carIn(number, curMinutes);
            } else {
                carOut(number, curMinutes);
            }
        }
        
        
        for (String number : new HashSet<>(parkingInTime.keySet())) {
            carOut(number, 1439);
        }


        List<String> vehicleList = new ArrayList<>(parkingTotalTime.keySet());
        Collections.sort(vehicleList);
        int[] result = new int[vehicleList.size()];
        
        
        for (int i = 0; i < vehicleList.size(); i++) {
            String number = vehicleList.get(i);
            result[i] = calculateFare(fees, parkingTotalTime.get(number));
        }
        
        return result;
    }

    public static int calculateFare(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFare = fees[1];
        int unitTime = fees[2];
        int unitFare = fees[3];

        if (time <= baseTime) {
            return baseFare;
        }

        int extraTime = time - baseTime;
        int additionalFare = (int) Math.ceil((double) extraTime / unitTime) * unitFare;

        return baseFare + additionalFare;
    }

    public static void carIn(String number, int curMinutes) {
        parkingInTime.put(number, curMinutes);
    }

    public static void carOut(String number, int curMinutes) {
        if (parkingInTime.containsKey(number)) {
            int inTime = parkingInTime.get(number);
            parkingInTime.remove(number);

            parkingTotalTime.put(number, parkingTotalTime.getOrDefault(number, 0) + curMinutes - inTime);
        }
    }
}