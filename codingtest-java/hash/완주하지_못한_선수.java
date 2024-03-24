import java.util.HashMap;

public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap();

        for (String name : participant) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            hashMap.put(name, hashMap.get(name) - 1);
        }


        for (String name : participant) {
            Integer count = hashMap.get(name);
            if (count != 0) {
                return name;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}