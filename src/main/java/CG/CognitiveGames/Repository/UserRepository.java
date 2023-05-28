package CG.CognitiveGames.Repository;

import CG.CognitiveGames.Model.Game;
import CG.CognitiveGames.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {


}
