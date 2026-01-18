package LoginSenhaHashMap;

public class Main {


    public static void main(String args[]){

        Usuarios usuarios = new Usuarios();


        //Criando usuarios:
        usuarios.criarUsuario("Teste123", "123");
        usuarios.criarUsuario("Ana", "321");
        usuarios.criarUsuario("Hello", "world");

        //Tentando logar:
        System.err.println(usuarios.logarUsuario("Ana", "123"));
        System.err.println(usuarios.logarUsuario("Ana", "321"));
        System.err.println(usuarios.logarUsuario("Hello", "321"));
        System.err.println(usuarios.logarUsuario("323232", "321"));
        System.err.println(usuarios.logarUsuario("Hello", "world"));


    }

    
}
