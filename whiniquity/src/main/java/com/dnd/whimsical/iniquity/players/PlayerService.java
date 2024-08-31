package com.dnd.whimsical.iniquity.players;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayersService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayersService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public List<Players> getPlayers() {
        return playerRepository.findAll();
    }
    public void addNewPlayer(Players player) {
        Optional<Players> playersOptional = playerRepository.findPlayerByName(player.getName());

        if(playersOptional.isPresent()) {
            throw new IllegalStateException("Player already created");
        }

        playerRepository.save(player);
        System.out.println(player);
    }

    public void deletePlayer(Long id) {
        boolean exists = playerRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException("Player with id " + id + " does not exist!");
        }
        playerRepository.deleteById(id);
    }

    @Transactional
    public void updatePlayer(Long id, String primaryClass, String subclass) {
        Optional<Players> player = Optional.ofNullable(playerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException("Player with id " + id + " does not exist!")));

        if(primaryClass != null && !primaryClass.isEmpty() && !Objects.equals(player.get().getPrimaryClass(), primaryClass)) {
            player.get().setPrimaryClass(primaryClass);
        }

        if(subclass != null && !subclass.isEmpty() && !Objects.equals(player.get().getSubclass(), subclass)) {
            player.get().setSubclass(subclass);
        }
    }

}
