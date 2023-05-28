package CG.CognitiveGames.Repository;

import CG.CognitiveGames.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <Game, Long>{


}
