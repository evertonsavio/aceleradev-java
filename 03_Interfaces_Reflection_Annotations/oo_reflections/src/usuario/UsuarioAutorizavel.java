package usuario;

public interface UsuarioAutorizavel {
    default boolean temAutorizacao(){
        return false;
    };
}
