package uk.ac.cf.cs.ons.skillsdb.skillsdb.players;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.played.PlayedRepo;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.Player;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.PlayerRepo;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PlayerController {
    private PlayerRepo playerRepo;
    private PlayedRepo playedRepo;

    public PlayerController(PlayerRepo pRepo, PlayedRepo pdRepo) {
        playerRepo = pRepo;
        playedRepo = pdRepo;
    }


    @GetMapping(path = "/player/add")
    public String createPlayer(Model model) {
        model.addAttribute("player", new Player());
//        model.addAttribute("skills", skillRepo.findAll());
        return "player/add";
    }

    @PostMapping("/player/add")
    public String submitPlayer(@ModelAttribute("Player") @Valid Player player, BindingResult result, Model model) {


        if ( result.hasErrors() ) {
            return "player/add";
        }
        playerRepo.save(player);

        return "redirect:/player/" + player.getId();
    }

    @GetMapping("/player/{id}")
    public String coursePage(@PathVariable("id") Long id, Model model) {

        Optional<Player> player = playerRepo.findById(id);
        if (!player.isPresent()) {
            return "404";
        }

        long theid = 2;

        PlayerStats stats = new PlayerStats();

        String playerName = playerRepo.findById(id).get().getName();
        Integer kills = playedRepo.getKillSumByPlayerId(id);
        Integer deaths = playedRepo.getAssistsSumByPlayerId(id);
        Integer assists = playedRepo.getDeathSumByPlayerId(id);
        Integer totalgames = playedRepo.getTotalGamesPlayer(id);
        Integer gameswon = playedRepo.getGamesWon(id);
        Integer gameslost = playedRepo.getGamesLost(id);
        Integer gamesonhardsup = playedRepo.getGamesOnRole(id, "Hard Support");
        Integer gamesonsup = playedRepo.getGamesOnRole(id, "Support");
        Integer gamesonoff = playedRepo.getGamesOnRole(id, "Offlane");
        Integer gamesonmid = playedRepo.getGamesOnRole(id, "Midlane");
        Integer gamesoncarry = playedRepo.getGamesOnRole(id, "Carry");

        stats.setName(playerName);
        stats.setKills(kills);
        stats.setDeaths(deaths);
        stats.setAssists(assists);
        stats.setTotalgames(totalgames);
        stats.setWins(gameswon);
        stats.setLosses(gameslost);
        stats.setHardsup(gamesonhardsup);
        stats.setSup(gamesonsup);
        stats.setOff(gamesonoff);
        stats.setMid(gamesonmid);
        stats.setCarry(gamesoncarry);

        model.addAttribute("kills", kills);
        model.addAttribute("stats", stats);


        return "player/player";
    }



}
