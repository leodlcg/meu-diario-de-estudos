import java.net.*;
import java.util.Scanner;

public class ClienteQuizUDP {
public static void main(String[] args) throws Exception {
DatagramSocket socket = new DatagramSocket(9876);
Scanner scanner = new Scanner(System.in);

System.out.println("Aguardando perguntas do Quiz...");

while (true) {
// Recebe a pergunta do servidor (broadcast)
byte[] buffer = new byte[1024];
DatagramPacket pacotePergunta = new DatagramPacket(buffer, buffer.length);
socket.receive(pacotePergunta);

String pergunta = new String(pacotePergunta.getData(), 0, pacotePergunta.getLength());
System.out.println("Pergunta: " + pergunta);

System.out.print("Sua resposta: ");
String resposta = scanner.nextLine();

// Envia resposta ao servidor
byte[] dadosResposta = resposta.getBytes();
InetAddress enderecoServidor = pacotePergunta.getAddress();
int portaServidor = pacotePergunta.getPort();
DatagramPacket pacoteResposta = new DatagramPacket(dadosResposta, dadosResposta.length, enderecoServidor, portaServidor);
socket.send(pacoteResposta);

// Recebe feedback do servidor
byte[] bufferFeedback = new byte[1024];
DatagramPacket pacoteFeedback = new DatagramPacket(bufferFeedback, bufferFeedback.length);
socket.receive(pacoteFeedback);

String feedback = new String(pacoteFeedback.getData(), 0, pacoteFeedback.getLength());
System.out.println(feedback + "\n");
}
}
}