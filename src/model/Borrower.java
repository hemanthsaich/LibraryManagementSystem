package model;

// Represents a borrower in the library system
public class Borrower {
    private String name;          // Name of the borrower
    private String contact;       // Contact details of the borrower
    private String membershipId;  // Unique membership ID for the borrower

    // Constructor to initialize a borrower
    public Borrower(String name, String contact, String membershipId) {
        this.name = name;
        this.contact = contact;
        this.membershipId = membershipId;
    }

    // Getters and setters for borrower attributes
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String membershipId) { this.membershipId = membershipId; }

    // Override toString to display borrower details
    @Override
    public String toString() {
        return "Borrower [Name=" + name + ", Contact=" + contact + ", Membership ID=" + membershipId + "]";
    }
}
