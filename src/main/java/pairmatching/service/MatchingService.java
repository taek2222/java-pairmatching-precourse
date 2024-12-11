package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.PairMatchings;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.Curriculum;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;

public class MatchingService {

    public PairMatching processMatching(Crews crews, Curriculum curriculum, PairMatchings pairMatchings) {
        Course course = curriculum.getCourse();
        Level level = curriculum.getLevel();

        List<String> names = crews.findCrewNamesByCourse(course);

        for (int loop = 0; loop < 3; loop++) {
            List<String> mixNames = Randoms.shuffle(names);
            List<Pair> pairs = matchingPars(mixNames, pairMatchings);

            if (pairMatchings.isDuplicatePairsIfLevel(pairs, level)) {
                continue;
            }
            return new PairMatching(curriculum, pairs);
        }

        throw new IllegalArgumentException();
    }

    private List<Pair> matchingPars(List<String> mixNames, PairMatchings pairMatchings) {
        List<Pair> pairs = new ArrayList<>();
        while(!mixNames.isEmpty()) {
            if (mixNames.size() == 3) {
                Pair pair = matchingPar(mixNames, 3);
                pairs.add(pair);
                continue;
            }
            Pair pair = matchingPar(mixNames, 2);
            pairs.add(pair);
        }
        return pairs;
    }

    private Pair matchingPar(List<String> pairs, int length) {
        List<String> pair = new ArrayList<>();

        for (int index = 0; index < length; index++) {
            pair.add(pairs.getFirst());
            pairs.removeFirst();
        }
        return new Pair(pair);
    }
}
