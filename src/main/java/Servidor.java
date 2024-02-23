import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        try (ServerSocket servidor = new ServerSocket(40000)){

            Socket conexao = servidor.accept();

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            entrada.readDouble();

            double real = entrada.readDouble();
            double dolar = real /5.01;

            saida.writeDouble(dolar);

          conexao.getOutputStream();
          conexao.getInputStream();
          
        } catch (IOException e) {                                       
            throw new RuntimeException(e);
        }
    }
}
