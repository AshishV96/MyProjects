import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecieveMessage {
    public static void main(String[] args) {

        String msgData = "SINGLE_CORRECT\": [\n" +
                "            {\n" +
                "                \"QUESTION_ID\": \"c42ad463-62cc-48f0-8225-8be0ff6a4604\",\n" +
                "                \"SUBMITTED_ANSWER\": \"0\",\n" +
                "                \"COMPILER_OUTPUT\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"QUESTION_ID\": \"8e727312-a089-4b90-821b-ffa9c80d9a45\",\n" +
                "                \"SUBMITTED_ANSWER\": \"2\",\n" +
                "                \"COMPILER_OUTPUT\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"QUESTION_ID\": \"5fe3ea5f-542f-419f-96c3-608cad9463c5\",\n" +
                "                \"SUBMITTED_ANSWER\": \"2\",\n" +
                "                \"COMPILER_OUTPUT\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"QUESTION_ID\": \"c48aa506-ab9c-4d8f-b10d-9a9a0a0df1d7\",\n" +
                "                \"SUBMITTED_ANSWER\": \"1\",\n" +
                "                \"COMPILER_OUTPUT\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"QUESTION_ID\": \"f8d0e4a4-9fdf-4327-bcf3-e60154c447d1\",\n" +
                "                \"SUBMITTED_ANSWER\": \"0\",\n" +
                "                \"COMPILER_OUTPUT\": \"\"\n" +
                "            }\n" +
                "        ]";

//        System.out.println(msgData.substring(17));
//        String innerdata = msgData.substring(msgData.indexOf('[')).replaceAll("[\\s\\[\\]]","");
//        System.out.println(innerdata);
//        List<String> objects = Arrays.asList(innerdata.split("},"));
//        List<String> candidateProfileBusDetails = new ArrayList<>();
//        objects.forEach(obj->{
//            if(objects.indexOf(obj)!=objects.size()-1) obj+="}";
//            candidateProfileBusDetails.add(obj);
//        });
//
//        System.out.println(candidateProfileBusDetails);
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now().minusDays(93), ZoneId.systemDefault());
        Long millis90s=zdt.toInstant().toEpochMilli();
        Long millisToday = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(millis90s<=millisToday);

        String prompt = "{\n    \"totalPercentage\": \"66.0\",\n    \"comment\": \"The provided ANSWER is correct based on the given QUESTION. It imports the necessary packages and prints 'Hello, World!' to the console using the main method.\",\n    \"evaluatedMarks\": \"66.0\",\n    \"error\": \"\"\n}";
//        prompt = "CREATE TABLE employee_salaries (\r\n    employee_id INT PRIMARY KEY,\r\n    employee_name VARCHAR(255),\r\n    salary DECIMAL(10, 2)\r\n);\r\n\r\nINSERT INTO employee_salaries (employee_id, employee_name, salary)\r\nVALUES\r\n    (101, 'John Doe', 60000.00),\r\n    (102, 'Jane Smith', 75000.00),\r\n    (103, 'Bob Johnson', 80000.00),\r\n    (104, 'Alice Brown', 90000.00),\r\n    (105, 'Eve White', 85000.00);\r\n    \r\nSELECT AVG(salary) AS avg_salary FROM employee_salaries;\r\n\r\nSELECT * \r\nFROM employee_salaries\r\nWHERE salary > (SELECT AVG(salary) FROM employee_salaries);";
        prompt = "I have a coding QUESTION in Language (1) with the following details:\n" +
                "- QUESTION: (2)\n" +
                "- SUBMITTED CODE: (3)\n" +
                "- COMPILER OUTPUT: (4)\n" +
                "- Max Marks: (5)\n" +
                "You must evaluate the (3)Submitted Code based on (4)Compiler Output against the provided (2)Question only and generate JSON response." +
                "AFTER checking for syntactical errors, generate this response:\n"+
                "{\n"+
                "\"percentage\": \"provide percentage here without percentage sign\",\n"+
                "\"comment\": \"The 'comment' field should not be empty, and it should contain a comprehensive explanation for (3)Submitted Code based on Question. Ensure that the comment does not include any special characters or symbols.(If the submitted code is in different language then don't evaluate)\",\n"+
                "\"evaluatedMarks\": \"provide evaluated marks out of max marks here after deducting appropriate marks for syntactical error (For syntax error deduct 20% of max marks for each and provide 0 if submitted code is in different language)\",\n"+
                "\"error\": \"provide errors here\"\n"+
                "}";
//        System.out.println(prompt.split("\"")[7]);
        int i = 1;
        String word = "Hello";
        try{
            String[] split = word.split(" ");
            split[i++].trim();
        }catch (Exception e)
        {
            System.out.println(i);
        }

        List<String> str = new ArrayList<>(10);
        str.add("HI");
        str.add("HELLO");
        str.add("BYE");

        String[] vals = new String[str.size()];

        str.forEach(s->vals[0]=s);

        System.out.println(str);

//        System.out.println(prompt);

    }


}
