package me.gameawards.service;

import me.gameawards.domain.model.Game;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game findById(Long entity_id);

    void insert(Game game);

    void update(Long entity_id, Game game);

    void delete(Long entity_id);

    /**
     * Metódo responsável por contabilizar um voto para um {@link Game}.
     *
     * @param gameId Identificador (ID) do {@link Game}.
     */
    public void vote(Long gameId);


}
