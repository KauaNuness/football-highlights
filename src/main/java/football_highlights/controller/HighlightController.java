package football_highlights.controller;

import football_highlights.dto.HighlightRequest;
import football_highlights.entity.Highlight;
import football_highlights.service.HighlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/highlights")
@RequiredArgsConstructor
public class HighlightController {

    private final HighlightService highlightService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Highlight create(
            @RequestBody @Valid HighlightRequest request
            ){
        return highlightService.create(request);
    }

    @GetMapping("/match/{matchId}")
    public List<Highlight> findByMatch(
            @PathVariable Long matchId
    ){
        return highlightService.findByMatch(matchId);
    }

}
