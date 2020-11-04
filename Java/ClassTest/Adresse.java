public class Adresse {
    String country;
    String state;
    String city;
    String street;

    Adresse(String country, String state, String city, String street){
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    String show(){
        return country+", "+state+", "+city+", "+street;
    }
}