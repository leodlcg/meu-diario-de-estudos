import java.net.*;
import java.util.*;

public class ServidorQuizUDP {
public static void main(String[] args) throws Exception {
DatagramSocket socket = new DatagramSocket();
Scanner scanner = new Scanner(System.in);

// Perguntas e respostas
String[][] quiz = {
{"Qual a capital do Brasil?", "brasilia"},
{"Quanto e 7 x 8?", "56"},
{"Quem escreveu 'Dom Casmurro'?", "machado de assis"},
{"Qual o maior planeta do sistema solar?", "jupiter"}
};

int porta = 9876;
InetAddress broadcast = InetAddress.getByName("255.255.255.255");
socket.setBroadcast(true);

for (String[] qa : quiz) {
String pergunta = qa[0];
String resposta = qa[1];

// Envia a pergunta para todos
byte[] dadosPergunta = pergunta.getBytes();
DatagramPacket pacotePergunta = new DatagramPacket(dadosPergunta, dadosPergunta.length, broadcast, porta);
socket.send(pacotePergunta);
System.out.println("Pergunta enviada: " + pergunta);

// Espera pela primeira resposta correta
boolean acertou = false;
while (!acertou) {
byte[] buffer = new byte[1024];
DatagramPacket pacoteResposta = new DatagramPacket(buffer, buffer.length);
socket.receive(pacoteResposta);

String respostaCliente = new String(pacoteResposta.getData(), 0, pacoteResposta.getLength()).trim().toLowerCase();
InetAddress enderecoCliente = pacoteResposta.getAddress();

if (respostaCliente.equals(resposta)) {
String msg = "Parabens! Voce acertou!";
DatagramPacket pacoteAcerto = new DatagramPacket(msg.getBytes(), msg.length(), enderecoCliente, pacoteResposta.getPort());
socket.send(pacoteAcerto);
System.out.println("Resposta correta de " + enderecoCliente.getHostAddress());
acertou = true;
} else {
String msg = "Resposta errada! Tente de novo!";
DatagramPacket pacoteErro = new DatagramPacket(msg.getBytes(), msg.length(), enderecoCliente, pacoteResposta.getPort());
socket.send(pacoteErro);
}
}
System.out.println("Proxima pergunta em 3 segundos...\n");
Thread.sleep(3000);
}
socket.close();
scanner.close();
}
}