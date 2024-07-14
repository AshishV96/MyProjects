import java.util.*;

public class FetchTweets {
    public void main(String[] args) {
        // Creating instances of different levels of friends
        Acquaintance acquaintance = new Acquaintance("John");
        Friend friend = new Friend("Alice", "New York");
        BestFriend bestFriend = new BestFriend("Bob", "Los Angeles", "Bohemian Rhapsody");

        // Getting status of each person
        acquaintance.getStatus();
        friend.getStatus();
        bestFriend.getStatus();
    }
}

class Acquaintance {
    String name;

    Acquaintance(String name) {
        this.name = name;
    }

    public void getStatus() {
        System.out.println(name + " is just an acquaintance.");
    }
}

class Friend extends Acquaintance {
    String homeTown;

    Friend(String name, String homeTown) {
        super(name);
        this.homeTown = homeTown;
    }

    public void getStatus() {
        System.out.println(name + " is a friend and he is from " + homeTown + ".");
    }
}

class BestFriend extends Friend {
    String favoriteSong;

    BestFriend(String name, String homeTown, String favoriteSong) {
        super(name, homeTown);
        this.favoriteSong = favoriteSong;
    }

    public void getStatus() {
        System.out.println(name + " is my best friend. He is from " + homeTown + " and his favorite song is " + favoriteSong + ".");
    }
}