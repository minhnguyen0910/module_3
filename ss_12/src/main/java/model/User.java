package model;

public class User  implements Comparable<User>{
    int id;
    String name;
    String country;
    String email;

    public User(int id, String name,String country,String email) {
        this.id = id;
        this.name = name;
        this.country=country;
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}
