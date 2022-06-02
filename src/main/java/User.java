/**
 * @author Xu Zheng
 * @description
 */
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String country;

    public User(String id, String firstName, String lastName, String email, String gender, String country){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }
    /*
    {
        '_id':1,
        'firstname': '',
        'lastname': '',
        'email':'',
        'gender':'',
        'country':''
    }
     */

    public String toJSON(){
        return "{'_id':'"+id+"','firstname':'"+firstName+"','lastname':'"+lastName+"','email':'"+email+"','gender':'"+gender+"','country':'"+country+"'}";
    }

    public static void main(String[] args) {
        User user = new User("1","roy","zheng","11111@gmail.com","male","china");
        System.out.println(user.toJSON());
    }
}
