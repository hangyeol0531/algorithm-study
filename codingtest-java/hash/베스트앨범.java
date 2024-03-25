import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 베스트앨범 {

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genresMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genresMap.put(genre, genresMap.getOrDefault(genre, 0) + plays[i]);
        }

        List<String> sortGenres = genresMap.keySet().stream()
            .sorted(Comparator.comparingInt(genresMap::get).reversed())
            .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (String genre : sortGenres) {
            HashMap<Integer, Integer> genreMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    genreMap.put(i, plays[i]);
                }
            }

            List<Integer> sortGenrePlays = genreMap.keySet().stream()
                .sorted(Comparator.comparing(genreMap::get).reversed())
                .limit(2)
                .collect(Collectors.toList());

            result.addAll(sortGenrePlays);
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[]{"classic", "pop", "classic", "classic", "pop"},
            new int[]{500, 600, 150, 800, 2500}
        )));
    }
}