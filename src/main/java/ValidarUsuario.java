import java.util.Map;

class ValidadorUsuarios {
    private UsuariosCSV usuariosCSV;

    public ValidadorUsuarios(UsuariosCSV usuariosCSV) {
        this.usuariosCSV = usuariosCSV;
    }

    public boolean validarUsuario(String usuario, String contrasena) {
        // Obtener todos los usuarios y contraseñas del archivo CSV
        Map<String, String> usuarios = usuariosCSV.getUsuarios();

        // Buscar el usuario y comprobar la contraseña
        if (usuarios.containsKey(usuario)) {
            String contrasenaGuardada = usuarios.get(usuario);
            if (contrasenaGuardada.equals(contrasena)) {
                return true;
            }
        }

        return false;
    }

    public boolean usuarioExiste(String usuario) {
        // Obtener todos los usuarios del archivo CSV
        Map<String, String> usuarios = usuariosCSV.getUsuarios();

        // Buscar el usuario
        if (usuarios.containsKey(usuario)) {
            return true;
        }

        return false;
    }

    public boolean agregarUsuario(String usuario, String contrasena) {
        // Comprobar si el usuario ya existe
        if (usuarioExiste(usuario)) {
            return false;
        }

        // Agregar el nuevo usuario al archivo CSV
        return usuariosCSV.agregarUsuario(usuario, contrasena);
    }
}
