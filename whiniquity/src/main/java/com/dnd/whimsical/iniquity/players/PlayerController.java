package com.dnd.whimsical.iniquity.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "app/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping
    public List<Players> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping(path = "add")
    public void registerPlayer(HttpEntity<Players> player) {
        playerService.addNewPlayer(Objects.requireNonNull(player.getBody()));
    }

//    @PutMapping(path = "add")
//    public void registerPlayer(@RequestParam Players player) {
//        playersService.addNewPlayer(player);
//    }

    @DeleteMapping(path = "{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);

    }

    @PostMapping("{id}")
    public void updatePlayer(@PathVariable("id") Long id, @RequestParam(required = false) String primaryClass, @RequestParam(required = false) String subclass) {
        playerService.updatePlayer(id, primaryClass, subclass);

    }
}
