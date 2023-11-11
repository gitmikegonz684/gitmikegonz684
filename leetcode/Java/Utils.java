import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static void main(String[] args) {
        System.out.println("HELLO FROM UTILS");
    }

    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<arr.length; i++) {
            if (i==arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String mapToString(Map<Character,Character> map) {
        String string = map.keySet().stream().map(key -> key + "=" + map.get(key)).collect(Collectors.joining(", ", "{", "}"));
        return string;
    }
}
