import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class 신고_결과_받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        for (String rep : report) {
            String reportId = rep.split(" ")[0];
            String reportedId = rep.split(" ")[1];
            HashSet<String> reportSet = reportMap.get(reportedId);
            if (reportSet == null) {
                reportMap.put(reportedId, new HashSet<>(List.of(reportId)));
            } else {
                reportSet.add(reportId);
            }
        }

        Map<String, Integer> reportMailMap = new HashMap<>();
        for (String id : id_list) {
            reportMailMap.put(id, 0);
        }

        reportMap.forEach((key, reportedSet) -> {
            if (reportedSet.size() >= k) {
                for (String reported : reportedSet) {
                    reportMailMap.put(reported, reportMailMap.get(reported) + 1);
                }
            }
        });

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            result[i] = reportMailMap.get(id_list[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2
            )));

        System.out.println(Arrays.toString(
            solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3
            )));
    }
}