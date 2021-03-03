package uk.ac.cf.cs.ons.skillsdb.skillsdb.played;

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
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.CourseRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.matches.Match;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.matches.MatchRepo;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.Player;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.PlayerRepo;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.SkillRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class PlayedController {

    private PlayerRepo playerRepo;
    private PlayedRepo playedRepo;
    private MatchRepo matchRepo;

    public PlayedController(PlayerRepo plRepo, PlayedRepo pdRepo, MatchRepo mRepo) {
        playerRepo = plRepo;
        playedRepo = pdRepo;
        matchRepo = mRepo;

    }


    @GetMapping(path = "/match/add")
    public String createCourse(Model model) {
        model.addAttribute("match", new Match());
        model.addAttribute("players", playerRepo.findAll());
        model.addAttribute("played10", new Played10());
        return "match/add";
    }

    @PostMapping("/match/add")
    public String submitCourse(@ModelAttribute("course") @Valid Match match, @Valid Played10 played10,
                               BindingResult result, Model model) {

        if ( result.hasErrors() ) {
            model.addAttribute("players", playerRepo.findAll());
            return "match/add";
        }

        Match match2 = new Match();
        match2.setMatchMode("Single Draft");
        matchRepo.save(match2);

        Played played = new Played(); Played played1 = new Played(); Played played2 = new Played(); Played played3 = new Played(); Played played4 = new Played();
        Played played5 = new Played(); Played played6 = new Played(); Played played7 = new Played(); Played played8 = new Played(); Played played9 = new Played();





                played.setPlayerId(played10.getPlayerId());
                played.setMatchId(match2);
                played.setKills(played10.getKills());
                played.setAssists(played10.getAssists());
                played.setDeaths(played10.getDeaths());
                if (played10.getIsWon()) {
                    played.setIsWon(true);
                } else {
                    played.setIsWon(false);
                }
                played.setIsWon(played10.getIsWon());
                played.setPlayerRole(played10.getPlayerRole());
                played.setPlayerTeam("Radient");

                played1.setPlayerId(played10.getPlayerId1());
                played1.setMatchId(match2);
                played1.setKills(played10.getKills1());
                played1.setAssists(played10.getAssists1());
                played1.setDeaths(played10.getDeaths1());
                if (played10.getIsWon()) {
                    played1.setIsWon(true);
                } else {
                    played1.setIsWon(false);
                }
                played1.setPlayerRole(played10.getPlayerRole1());
                played1.setPlayerTeam("Radient");

                played2.setPlayerId(played10.getPlayerId2());
                played2.setMatchId(match2);
                played2.setKills(played10.getKills2());
                played2.setAssists(played10.getAssists2());
                played2.setDeaths(played10.getDeaths2());
                if (played10.getIsWon()) {
                    played2.setIsWon(true);
                } else {
                    played2.setIsWon(false);
                }
                played2.setPlayerRole(played10.getPlayerRole2());
                played2.setPlayerTeam("Radient");

                played3.setPlayerId(played10.getPlayerId3());
                played3.setMatchId(match2);
                played3.setKills(played10.getKills3());
                played3.setAssists(played10.getAssists3());
                played3.setDeaths(played10.getDeaths3());
                if (played10.getIsWon()) {
                    played3.setIsWon(true);
                } else {
                    played3.setIsWon(false);
                }
                played3.setPlayerRole(played10.getPlayerRole3());
                played3.setPlayerTeam("Radient");

                played4.setPlayerId(played10.getPlayerId4());
                played4.setMatchId(match2);
                played4.setKills(played10.getKills4());
                played4.setAssists(played10.getAssists4());
                played4.setDeaths(played10.getDeaths4());
                if (played10.getIsWon()) {
                    played4.setIsWon(true);
                } else {
                    played4.setIsWon(false);
                }
                played4.setPlayerRole(played10.getPlayerRole4());
                played4.setPlayerTeam("Radient");

                played5.setPlayerId(played10.getPlayerId5());
                played5.setMatchId(match2);
                played5.setKills(played10.getKills5());
                played5.setAssists(played10.getAssists5());
                played5.setDeaths(played10.getDeaths5());
                if (played10.getIsWon()) {
                    played5.setIsWon(false);
                } else {
                    played5.setIsWon(true);
                }
                played5.setPlayerRole(played10.getPlayerRole5());
                played5.setPlayerTeam("Dire");

                played6.setPlayerId(played10.getPlayerId6());
                played6.setMatchId(match2);
                played6.setKills(played10.getKills6());
                played6.setAssists(played10.getAssists6());
                played6.setDeaths(played10.getDeaths6());
                if (played10.getIsWon()) {
                    played6.setIsWon(false);
                } else {
                    played6.setIsWon(true);
                }
                played6.setPlayerRole(played10.getPlayerRole6());
                played6.setPlayerTeam("Dire");

                played7.setPlayerId(played10.getPlayerId7());
                played7.setMatchId(match2);
                played7.setKills(played10.getKills7());
                played7.setAssists(played10.getAssists7());
                played7.setDeaths(played10.getDeaths7());
                if (played10.getIsWon()) {
                    played7.setIsWon(false);
                } else {
                    played7.setIsWon(true);
                }
                played7.setPlayerRole(played10.getPlayerRole7());
                played7.setPlayerTeam("Dire");

                played8.setPlayerId(played10.getPlayerId8());
                played8.setMatchId(match2);
                played8.setKills(played10.getKills8());
                played8.setAssists(played10.getAssists8());
                played8.setDeaths(played10.getDeaths8());
                if (played10.getIsWon()) {
                    played8.setIsWon(false);
                } else {
                    played8.setIsWon(true);
                }
                played8.setPlayerRole(played10.getPlayerRole8());
                played8.setPlayerTeam("Dire");

                played9.setPlayerId(played10.getPlayerId9());
                played9.setMatchId(match2);
                played9.setKills(played10.getKills9());
                played9.setAssists(played10.getAssists9());
                played9.setDeaths(played10.getDeaths9());
                if (played10.getIsWon()) {
                    played9.setIsWon(false);
                } else {
                    played9.setIsWon(true);
                }
                played9.setPlayerRole(played10.getPlayerRole9());
                played9.setPlayerTeam("Dire");

                List<Played> playedGames = new ArrayList<>();
                playedGames.add(played); playedGames.add(played1); playedGames.add(played2); playedGames.add(played3); playedGames.add(played4);
                playedGames.add(played5); playedGames.add(played6); playedGames.add(played7); playedGames.add(played8); playedGames.add(played9);

        playedRepo.saveAll(playedGames);

//        playedRepo.save(played);
//        playedRepo.save(played2);
//        playedRepo.save(played3);
//        playedRepo.save(played4);
//        playedRepo.save(played5);
//        playedRepo.save(played6);
//        playedRepo.save(played7);
//        playedRepo.save(played8);
//        playedRepo.save(played9);
//        playedRepo.save(played10);

        return "redirect:/matches/" + match.getId();
    }

    @GetMapping("/matches/{id}")
    public String matchPage(@PathVariable("id") Long id, Model model) {


        List<Played> matchRadient = playedRepo.findAllByMatchIdIdAndPlayerTeam(id, "Radient");
        List<Played> matchDire = playedRepo.findAllByMatchIdIdAndPlayerTeam(id, "Dire");
        if (matchRadient.isEmpty()) {
            return "404";
        }

        model.addAttribute("radient", matchRadient);
        model.addAttribute("dire", matchDire);


        return "match/match";
    }


}
