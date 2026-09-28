package football_highlights.service;

import football_highlights.dto.HighlightRequest;
import football_highlights.entity.Highlight;
import football_highlights.entity.Match;
import football_highlights.repository.HighlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HighlightService {

    private final HighlightRepository highlightRepository;
    private final MatchService matchService;

    @Value("${app.storage.path}")
    private String storagePath;

    public Highlight create(HighlightRequest request) {

        Match match = matchService.findById(request.matchId());

        Path matchDirectory = Paths.get(
                storagePath,
                "matches",
                String.valueOf(match.getId()),
                "highlights"
        );

        try {
            Files.createDirectories(matchDirectory);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Não foi possível criar o diretório do highlight", e
            );
        }

        Path videoPath = matchDirectory.resolve(request.fileName());

        Highlight highlight = Highlight.builder()
                .description(request.description())
                .fileName(request.fileName())
                .filePath(videoPath.toString())
                .durationSeconds(request.durationSeconds())
                .createdAt(LocalDateTime.now())
                .match(match)
                .build();

        return highlightRepository.save(highlight);
    }

    public List<Highlight> findByMatch(Long matchId) {
        return highlightRepository.findByMatchId(matchId);
    }
}