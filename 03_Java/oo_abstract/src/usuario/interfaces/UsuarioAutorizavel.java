package usuario.interfaces;

public interface UsuarioAutorizavel {
    default boolean temAuth(){
        return false;
    };
}
