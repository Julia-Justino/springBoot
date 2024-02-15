package school.sptech.aula001;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculos")
public class Calculadora {



    private  int contador;
    @GetMapping("/contar")
    public int contar(){
        return  ++contador;
    }

    @GetMapping("/contar2")
    public int contar2(){
        return  ++contador;
    }


    @GetMapping("/somar/{n1}/{n2}")
    public int somar(
            @PathVariable int n1,
            @PathVariable int n2
    ){
        return n1 + n2;
    }

}
