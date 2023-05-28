package CG.CognitiveGames.Service;

import CG.CognitiveGames.Model.Game;
import CG.CognitiveGames.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> getAllgames() {
        return gameRepository.findAll();
    }
}
