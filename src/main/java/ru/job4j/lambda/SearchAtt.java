package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class SearchAtt {
    public static List<Attachment> filter(List<Attachment> list) {
        UnaryOperator<List<Attachment>> unaryOperator = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> attachments) {
                List<Attachment> rsl = new ArrayList<>();
                for (Attachment att : attachments) {
                    if (att.getSize() > 100 && att.getName().contains("bug")) {
                        rsl.add(att);
                    }
                }
                return rsl;
            }
        };
        return unaryOperator.apply(list);
    }
}