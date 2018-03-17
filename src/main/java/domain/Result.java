package domain;

public class Result {
    private Student selector;
    private Student partner;

    Result(String selectorName, String partnerName) {
        this.selector = new Student(selectorName);
        this.partner = new Student(partnerName);
    }

    public String getSelector() {
        return selector.getName();
    }

    public String getPartner() {
        return partner.getName();
    }
}
