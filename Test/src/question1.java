import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class question1{
    public static void main(String[] args) {

//        Map<String, Map<String, Set<String>>> bouquets = new HashMap<>();
//        bouquets.put("Bouquet1", new HashMap<>());
//        bouquets.get("Bouquet1").put("Rose", new HashSet<>());
//        bouquets.get("Bouquet1").get("Rose").add("Red");
//        bouquets.get("Bouquet1").get("Rose").add("White");
//        bouquets.get("Bouquet1").get("Rose").add("Yellow");
//        bouquets.get("Bouquet1").put("Tulip", new HashSet<>());
//        bouquets.get("Bouquet1").get("Tulip").add("White");
//        bouquets.get("Bouquet1").get("Tulip").add("Purple");
//        bouquets.get("Bouquet1").put("Lily", new HashSet<>());
//        bouquets.get("Bouquet1").get("Lily").add("White");
//
//        bouquets.put("Boutquet2", new HashMap<>());
//        bouquets.get("Boutquet2").put("Rose", new HashSet<>());
//        bouquets.get("Boutquet2").get("Rose").add("Pink");
//        bouquets.get("Boutquet2").get("Rose").add("Orange");
//        bouquets.get("Boutquet2").put("chrysanthemum", new HashSet<>());
//        bouquets.get("Boutquet2").get("chrysanthemum").add("Yellow");
//        bouquets.get("Boutquet2").put("Balsam", new HashSet<>());
//        bouquets.get("Boutquet2").get("Balsam").add("Pink");
//
//        Scanner scanner = new Scanner(System.in);
//        String input[] = scanner.nextLine().split(" ");
//        boolean found = false;
//        for(Map.Entry<String, Map<String, Set<String>>> bouquet: bouquets.entrySet()){
//            if(bouquet.getValue().containsKey(input[1])){
//                if(bouquet.getValue().get(input[1]).contains(input[0])){
//                    System.out.println(bouquet.getKey());
//                    found = true;
//                    break;
//                }
//            }
//        }
//
//        if(!found){
//            System.out.println("None");
//        }

        Map<String,Map<String,String>> bouquet = new HashMap<>();
        bouquet.put("rose",new HashMap<>());
        bouquet.put("tulip",new HashMap<>());
        bouquet.put("lily",new HashMap<>());
        bouquet.put("chrysanthemum",new HashMap<>());
        bouquet.put("balsam",new HashMap<>());

        bouquet.get("rose").put("red","Bouquet1");
        bouquet.get("rose").put("white","Bouquet1");
        bouquet.get("rose").put("yellow","Bouquet1");
        bouquet.get("rose").put("pink","Bouquet2");
        bouquet.get("rose").put("orange","Bouquet2");

        bouquet.get("tulip").put("white","Bouquet1");
        bouquet.get("tulip").put("purple","Bouquet1");

        bouquet.get("lily").put("white","Bouquet1");

        bouquet.get("chrysanthemum").put("yellow","Bouquet2");

        bouquet.get("balsam").put("pink","Bouquet2");

        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().toLowerCase().split(" ");

        if(bouquet.get(input[1])!=null)
        {
            if(bouquet.get(input[1]).get(input[0])!=null)
                System.out.println(bouquet.get(input[1]).get(input[0]));

            else
                System.out.println("None");
        }

        else
            System.out.println("None");


    }
}