package pipeline;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reciever {

    public static List<String> spamCount(List<String> subjects,List<String> spamWords)
    {

//        List<String> result = subjects.stream().map(sub->{ AtomicInteger count = new AtomicInteger();
//            spamWords.stream().forEach(sp-> { Arrays.stream(sub.toLowerCase().split(" "))
//                        .forEach(sb->{
//                            if (sb.equals(sp.toLowerCase()))
//                            count.getAndIncrement();
//                        });
//            });
//            if(count.get()>=2) return "spam"; else return "not_spam";
//        }).collect(Collectors.toList());

        List<String> result = subjects.stream()
                .map(subject -> subject.toLowerCase().split(" "))
                .map(words -> Arrays.stream(words)
                        .filter(word -> spamWords.stream().anyMatch(sw->sw.toLowerCase().equals(word)))
                        .count())
                .map(counter -> counter >= 2 ? "spam" : "not_spam")
                .collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {

        List<String> subjects = new ArrayList<>();
        subjects.add("xyz millions");
        subjects.add("Free xyz");
        subjects.add("millions money free");
        subjects.add("Free millions counts");

        List<String> spamWords = new ArrayList<>();
        spamWords.add("millions");
        spamWords.add("Free");
        spamWords.add("money");

        System.out.println(spamCount(subjects,spamWords));

//        List<String> result = new ArrayList<>();
//
//        for (String subject : subjects) {
//            int spamCount = 0;
//            String lowerSubject = subject.toLowerCase();
//
//            for (String word : spamWords) {
//                spamCount += lowerSubject.split("(?i)" + word.toLowerCase()).length - 1;
//                if (spamCount >= 2) {
//                    result.add("spam");
//                    break;
//                }
//            }
//
//            if (spamCount < 2) {
//                result.add("not_spam");
//            }
//        }
//        System.out.println(result);
    }
}
