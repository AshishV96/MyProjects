import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class question2 {
    public static void main(String[] args) throws IOException {
        List<String> fileContent;
        try(Stream<String> line = Files.lines(Paths.get("trace.log"))){
            fileContent = line.collect(Collectors.toList());
        }
        LocalDateTime boundryTime = LocalDateTime.parse("2023-06-29 04:04:04", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int left = 0;
        int right = fileContent.size() - 1;
        int temp = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            String log = fileContent.get(mid);
            String splitLog[] = log.split(" ");
            LocalDateTime logTime = LocalDateTime.parse(splitLog[0] + " " + splitLog[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            if(splitLog[2].equals("J1") && logTime.isAfter(boundryTime)){
                temp = mid;
                right = mid - 1;
            }else if(logTime.equals(boundryTime)){
                temp = mid;
                break;
            }else if(logTime.isBefore(boundryTime)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(temp == -1){
            temp = 0;
        }

        for(int i=temp; i < fileContent.size();i++){
            String log = fileContent.get(i);
            String splitLog[] = log.split(" ");
            if(splitLog[2].equals("J1")){
                System.out.println(fileContent.get(i));
                break;
            }
        }
    }
}
