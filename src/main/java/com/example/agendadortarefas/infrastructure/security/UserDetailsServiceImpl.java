package com.example.agendadortarefas.infrastructure.security;


import com.example.agendadortarefas.business.dto.UsuarioDTO;
import com.example.agendadortarefas.infrastructure.client.UsuarioClient;
import com.example.usuario.infrastructure.entity.Usuario;
import com.example.usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;


    public UserDetails carregaDadosUsuario(String email, String token){

        UsuarioDTO usuarioDTO = client.buscaUsuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                        .build();
    }
}
