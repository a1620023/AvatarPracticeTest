package io.emelceledonio.avatarpracticetest.Controller;

import io.emelceledonio.avatarpracticetest.Entity.Pokemon;
import io.emelceledonio.avatarpracticetest.Entity.PokemonData;
import io.emelceledonio.avatarpracticetest.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping("/pokemons")
    public String index(Model model) throws IOException, InterruptedException {
        var object = pokemonService.getJsonBodyAPIData();

        model.addAttribute("pokemon", new PokemonData());
        model.addAttribute("pokemons",object);
        return "index";
    }
}
