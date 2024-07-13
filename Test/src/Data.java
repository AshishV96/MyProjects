import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Data {

    public static void main(String[] args) {

        Arrays.stream(Model.class.getDeclaredFields()).forEach(s -> System.out.println(s.getName()));
        Model model = new Model();
        model.setId(123);
        model.setDetails("latest files");
        model.setCreatedOn(LocalDateTime.now());
        Arrays.stream(model.getClass().getFields()).forEach(System.out::println);

        Field[] fields = model.getClass().getDeclaredFields();

        // Access and print the values of each field
        for (Field field : fields) {
            field.setAccessible(true); // Make the field accessible (even if it's private)

            try {
                Object value = field.get(model);
                System.out.println("Field: " + field.getName() + ", Value: " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }
}
class Model{

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Integer id;

    private String name;

    private String details;

    private LocalDateTime createdOn;

    private String createdBy;

}
