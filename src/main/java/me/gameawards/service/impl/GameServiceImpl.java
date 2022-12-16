package me.gameawards.service.impl;

import me.gameawards.domain.model.Game;
import me.gameawards.domain.model.GameRepository;
import me.gameawards.service.GameService;
import me.gameawards.service.exception.BusinessException;
import me.gameawards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> findAll() {
        return repository.findAll(Sort.by(Direction.DESC, "votes"));
    }

    @Override
    public Game findById(Long entity_id) {
        return this.repository.findById(entity_id).orElseThrow(NoContentException::new);
    }

    @Override
    public void insert(Game game) {
        this.repository.save(game);
    }

    @Override
    public void update(Long entity_id, Game game) {
        Game gameDb = this.findById(entity_id);

        if (!gameDb.getEntity_id().equals(game.getEntity_id())) {
            throw new BusinessException("Cannot update the game");
        }
    }

    @Override
    public void delete(Long entity_id) {
        Game gameDb = this.findById(entity_id);
        repository.delete(gameDb);
    }

    @Override
    public void vote(Long gameId) {
        Game game = findById(gameId);
        game.setVotes(game.getVotes() + 1);

        update(gameId, game);
    }
}
