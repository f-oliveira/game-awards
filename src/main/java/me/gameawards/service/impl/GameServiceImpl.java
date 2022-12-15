package me.gameawards.service.impl;

import me.gameawards.domain.model.Game;
import me.gameawards.domain.model.GameRepository;
import me.gameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> findAll() {
        return null;
    }

    @Override
    public Game findById(Long entity_id) {
        return null;
    }

    @Override
    public void insert(Game game) {

    }

    @Override
    public void update(Long entity_id, Game game) {

    }

    @Override
    public void delete(Long entity_id) {

    }
}
