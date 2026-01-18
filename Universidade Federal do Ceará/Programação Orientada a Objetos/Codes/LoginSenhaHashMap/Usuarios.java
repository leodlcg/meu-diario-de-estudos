package LoginSenhaHashMap;
import java.util.*;


public class Usuarios {

    HashMap<String, String> loginESenha = new HashMap<>();


    public void criarUsuario(String login, String senha){
        
    loginESenha.put(login, senha);

    }


    public String logarUsuario(String loginTentativa, String senhaTentativa){


        if(loginESenha.get(loginTentativa) == null){
            return "Login incorreto!";
        }else if(senhaTentativa != loginESenha.get(loginTentativa)){
             return "Senha incorreta!";
        }else{
             return "Logado!";
        }

    }
    

    
}
