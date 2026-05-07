package SDET_Day3;

//Voting Application : encapsulate user voting rights and identity.

public class Encapsulation_Q5 {
	public static void main(String[] args) {
        Voter v1 = new Voter();
        v1.setDetails("Shaurya", 23);
        v1.vote();
        v1.vote();
        System.out.println(v1.getName());
    }
}
class Voter {
    private String name;
    private int age;
    private boolean hasVoted = false;
    public void setDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void vote() {
        if (age < 18) {
            System.out.println("Not eligible to vote.");
        } else if (hasVoted) {
            System.out.println("You have already voted.");
        } else {
            hasVoted = true;
            System.out.println("Vote cast successfully!");
        }
    }
    public String getName() {
        return name;
    }
}