public class Main {
    public static void main(String[] args) {
        // Crear instancia de UsuariosCSV para manejar el archivo CSV
        UsuariosCSV usuariosCSV = new UsuariosCSV("usuarios.csv");

        // Crear instancia del LoginFrame y pasarlo la referencia de UsuariosCSV
        LoginFrame loginFrame = new LoginFrame(usuariosCSV);

    }
}