package view;

import domain.Results;

public class ResultViewBuilder {
    public static String build(Results results) {
        StringBuilder builder = new StringBuilder();
        builder.append("**************************** ");
        builder.append("오늘의 짝꿍");
        builder.append(" ****************************\n");
        for (int i = 0; i < results.getResultSize(); i++) {
            builder.append(results.getSelectorName(i) + " -> " + results.getPartnerName(i) + "\n");
        }
        builder.append("********************************************************");
        return builder.toString();
    }
}
