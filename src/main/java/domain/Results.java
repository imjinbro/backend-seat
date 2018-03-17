package domain;

import java.util.ArrayList;

public class Results {
    private ArrayList<Result> results = new ArrayList<>();

    public void addResult(String name, String reward) {
        results.add(new Result(name, reward));
    }

    public String getSelectorName(int position) {
        Result result = results.get(position);
        return result.getSelector();
    }

    public String getPartnerName(int position) {
        Result result = results.get(position);
        return result.getPartner();
    }

    public int getResultSize() {
        return results.size();
    }
}
