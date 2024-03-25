import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {

    public static String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : record) {
            String[] arr = str.split(" ");
            if (List.of("Enter", "Change").contains(arr[0])) {
                String uuid = arr[1];
                String name = arr[2];
                hashMap.put(uuid, name);
            }
        }

        List<String> result = new ArrayList<>();
        for (String str : record) {
            String[] arr = str.split(" ");
            String command = arr[0];
            String uuid = arr[1];

            switch (command) {
                case "Enter":
                    result.add(String.format("%s님이 들어왔습니다.", hashMap.get(uuid)));
                    break;
                case "Leave":
                    result.add(String.format("%s님이 나갔습니다.", hashMap.get(uuid)));
                    break;
            }
        }

        return result.toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}