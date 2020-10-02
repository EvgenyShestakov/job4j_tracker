package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filter(List<Attachment> list,
                                          Predicate<List<Attachment>> predicate) {
        predicate.test(list);
        return list;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<List<Attachment>> predicate = new Predicate<List<Attachment>>() {
            @Override
            public boolean test(List<Attachment> attachments) {
                boolean flag = false;
                List<Attachment> rsl = new ArrayList<>();
                for (Attachment att : attachments) {
                    if (att.getSize() > 100) {
                        rsl.add(att);
                        flag = true;
                    }
                }
                attachments.retainAll(rsl);
                return flag;
            }
        };

        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<List<Attachment>> predicate = new Predicate<List<Attachment>>() {
            @Override
            public boolean test(List<Attachment> attachments) {
                boolean flag = false;
                List<Attachment> rsl = new ArrayList<>();
                for (Attachment att : attachments) {
                    if (att.getName().contains("bug")) {
                        rsl.add(att);
                        flag = true;
                    }
                }
                attachments.retainAll(rsl);
                return flag;
            }
        };
        return filter(list, predicate);
    }
}


