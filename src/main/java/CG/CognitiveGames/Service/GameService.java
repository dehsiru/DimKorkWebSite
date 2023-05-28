package CG.CognitiveGames.Service;

import CG.CognitiveGames.Model.Game;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GameService {

    List<Game> getAllgames();
}
