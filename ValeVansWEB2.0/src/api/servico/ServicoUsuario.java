package api.servico;

import api.modelo.Usuario;

public interface ServicoUsuario {
    public Usuario insert(Usuario usuario);
    public Usuario findByEmail(String emailUsuario);
}
