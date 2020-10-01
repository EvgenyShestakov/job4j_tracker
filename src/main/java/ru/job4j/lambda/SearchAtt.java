package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static boolean filter(List<Attachment> list) {
        Predicate<List<Attachment>> predicate = new Predicate<List<Attachment>>() {
            @Override
            public boolean test(List<Attachment> attachments) {
                boolean flag;
                List<Attachment> rsl = new ArrayList<>();
                for (Attachment att : attachments) {
                    if (att.getSize() > 100 && att.getName().contains("bug")) {
                        rsl.add(att);
                    }
                }
                flag = attachments.retainAll(rsl);
                return flag;
            }
        };
        return predicate.test(list);
    }
}


