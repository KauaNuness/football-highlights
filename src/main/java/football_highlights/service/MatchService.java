package football_highlights.service;

import football_highlights.dto.MatchRequest;
import football_highlights.entity.Field;
import football_highlights.entity.Match;
import football_highlights.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final FieldService fieldService;

    public Match create(MatchRequest request){

        Field field = fieldService.findById(request.fieldId());

        Match match = Match.builder()
                .description(request.description())
                .startedAt(LocalDateTime.now())
                .field(field)
                .build();

        return matchRepository.save(match);

    }

    public Match findById(Long id){
        return matchRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Partida não encontrada"));
    }

    public Match finish(Long id){
        Match match = findById(id);
        match.setFinishedAt(LocalDateTime.now());

        return matchRepository.save(match);
    }

    public List<Match> findAll(){
        return matchRepository.findAll();
    }

}
