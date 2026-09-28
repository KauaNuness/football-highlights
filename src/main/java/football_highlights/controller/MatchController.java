package football_highlights.controller;

import football_highlights.dto.MatchRequest;
import football_highlights.entity.Match;
import football_highlights.service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Match create(
            @RequestBody @Valid MatchRequest request
            ){
        return matchService.create(request);
    }

    @GetMapping
    public List<Match> findAll(){
        return matchService.findAll();
    }

    @GetMapping("/{id}")
    public Match findById(@PathVariable Long id){
        return matchService.findById(id);
    }

    @PatchMapping("/{id}/finish")
    public Match finish(@PathVariable Long id){
        return matchService.finish(id);
    }

}
