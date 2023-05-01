import java.io.*;
import java.util.*;

public class UsuariosCSV {
    private String archivoCSV;

    public UsuariosCSV(String archivoCSV) {
        this.archivoCSV = archivoCSV;
    }

    public Map<String, String> getUsuarios() {
        Map<String, String> usuarios = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String usuario = partes[0].trim();
                    String contrasena = partes[1].trim();
                    usuarios.put(usuario, contrasena);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public boolean agregarUsuario(String usuario, String contrasena) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV, true))) {
            String linea = usuario + "," + contrasena;
            bw.write(linea);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarUsuario(String usuario, String contrasena) {
        Map<String, String> usuarios = getUsuarios();
        if (usuarios.containsKey(usuario)) {
            String contrasenaGuardada = usuarios.get(usuario);
            if (contrasenaGuardada.equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public void agregarUsuario(Usuario usuario) {
    }
}
