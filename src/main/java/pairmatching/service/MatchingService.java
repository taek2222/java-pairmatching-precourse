package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.Curriculum;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.domain.curriculum.Course;

public class MatchingService {

    public PairMatching processMatching(Crews crews, Curriculum curriculum) {
        Course course = curriculum.getCourse();
        List<String> names = crews.findCrewNamesByCourse(course);

        // 섞은 후
        List<String> mixNames = Randoms.shuffle(names);

        // 매칭 정보 이미 존재시 로직 추가해아함

        List<Pair> pairs = matchingPars(mixNames);
        return new PairMatching(curriculum, pairs);
    }

    private List<Pair> matchingPars(List<String> mixNames) {
        List<Pair> pairs = new ArrayList<>();
        while(!mixNames.isEmpty()) {
            if (mixNames.size() == 3) {
                pairs.add(matchingPar(mixNames, 3));
                continue;
            }
            pairs.add(matchingPar(mixNames, 2));
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
