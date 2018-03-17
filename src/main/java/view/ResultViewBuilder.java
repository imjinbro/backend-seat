package view;

import domain.Results;

public class ResultViewBuilder {
    public static String build(Results results) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < results.getResultSize(); i++) {
            builder.append(results.getSelectorName(i) + " -> " + results.getPartnerName(i) + "\n");
        }
        return builder.toString();
    }
}
