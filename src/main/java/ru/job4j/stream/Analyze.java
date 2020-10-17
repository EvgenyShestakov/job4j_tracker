package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream()).
                mapToInt(Subject::getScore).average().orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().
                stream().mapToInt(Subject::getScore).average().orElse(0D))).
                collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return  stream.flatMap(pupil -> pupil.getSubjects().
                stream()).collect(Collectors.
                groupingBy(Subject::getName, Collectors.averagingDouble(Subject::getScore))).
                entrySet().stream().map(stringDoubleEntry -> new Tuple(stringDoubleEntry.
                getKey(), stringDoubleEntry.getValue())).sorted((o1, o2) -> o2.getName().
                compareTo(o1.getName())).collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return  stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().
                stream().mapToInt(Subject::getScore).sum())).
                max((o1, o2) -> Double.compare(o1.getScore(), o2.getScore())).
                orElse(new Tuple("NoName", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().
                stream()).collect(Collectors.
                groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore))).
                entrySet().stream().map(stringDoubleEntry -> new Tuple(stringDoubleEntry.
                getKey(), stringDoubleEntry.getValue())).
                max((o1, o2) -> Double.compare(o1.getScore(), o2.getScore())).
                orElse(new Tuple("NoName", 0D));
    }
}
