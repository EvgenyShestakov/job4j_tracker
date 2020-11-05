package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
      return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer integer : this.list) {
           tmp.add(fun.apply(integer));
        }
        return new EasyStream(tmp);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer integer : this.list) {
            if (fun.test(integer)) {
             tmp.add(integer);
            }
        }
        return new EasyStream(tmp);
    }

    public List<Integer> collect() {
        return this.list;
    }

}
