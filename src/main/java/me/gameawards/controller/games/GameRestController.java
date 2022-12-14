package me.gameawards.controller.games;

import me.gameawards.controller.BaseRestController;
import me.gameawards.domain.model.Game;
import me.gameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameRestController extends BaseRestController {

    @Autowired
    private GameService businessLayer;

    @GetMapping("games")
    public ResponseEntity<List<Game>> findAll() {
        return ResponseEntity.ok(this.businessLayer.findAll());
    }

    @GetMapping("games/{entity_id}")
    public ResponseEntity<Game> findById(@PathVariable Long entity_id) {
        return ResponseEntity.ok(this.businessLayer.findById(entity_id));
    }

    @PostMapping("games")
    public ResponseEntity<Game> insert(@RequestBody Game game) {
        businessLayer.insert(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @PutMapping("games/{entity_id}")
    public ResponseEntity<Game> update(@PathVariable Long entity_id, @RequestBody Game game) {
        businessLayer.update(entity_id, game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("games/{entity_id}")
    public ResponseEntity<Game> delete(@PathVariable Long entity_id) {
        businessLayer.delete(entity_id);
        return ResponseEntity.ok().build();
    }

    /**
     * Enpoint que vota em um {@link Game} específico, também consumido pelo App React Native:<br>
     * <a href="https://youtu.be/Ity0Aa_ytPM">DIO Fullstack Labs - Dia 1 (API Java 17)<a/><br>
     * <a href="https://youtu.be/QXeXmKPOmvo">DIO Fullstack Labs - Dia 2 (App React Native)<a/>
     *
     * @param id Identificador do {@link Game} para contabilizarmos o voto.
     */
    @PatchMapping("games/{id}/vote")
    public ResponseEntity<Void> vote(@PathVariable Long id) {
        this.businessLayer.vote(id);
        return ResponseEntity.ok().build();
    }

}
