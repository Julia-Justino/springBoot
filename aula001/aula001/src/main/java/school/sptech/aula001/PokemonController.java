package school.sptech.aula001;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private List <String> poke = new ArrayList<>();

    @GetMapping
    public String quantidade(){
        return "Total de pokemon cadastrados: " + poke.size();
    }
    @GetMapping("/cadastrar/{pokemon}")
    public String cadastro(@PathVariable String pokemon){
        poke.add(pokemon);
        return  "Pokemon cadastrado";
    }

    @GetMapping("/recuperar/{indice}")
    public String recupera (@PathVariable int indice){
        if (indice<0||indice==poke.size()||indice>poke.size()){
            return "Pokemon não encontrado";
        }
        return poke.get(indice);
    }

    @GetMapping("/excluir/{indice}")
    public String exclui (@PathVariable int indice){
        if (indice<0||indice==poke.size()||indice>poke.size()){
            return "Pokemon não encontrado ";
        }
        poke.remove(indice);
        return "Excluído";
    }

    @GetMapping("/atualizar/{indice}/{novoNome}")
    public String atualiza (
            @PathVariable int indice,
            @PathVariable String novoNome
    ){
        if (indice<0||indice==poke.size()||indice>poke.size()){
            return "Pokemon não encontrado";
        }
        poke.set(indice, novoNome);
        return "Pokemon Atualizado";
    }

    public List<String> getPoke() {
        return poke;
    }

    public void setPoke(List<String> poke) {
        this.poke = poke;
    }

}
