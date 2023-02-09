package com.example.padelstatsv2.service;

// Importamos el modelo de usuarios y el repositorio de usuarios
import com.example.padelstatsv2.model.UsersModel;
import com.example.padelstatsv2.repository.UsersRepository;

// Importamos la anotación @Autowired de Spring Framework
import org.springframework.beans.factory.annotation.Autowired;

// Importamos la anotación @Service de Spring Framework
import org.springframework.stereotype.Service;

// Anotación para indicar que esta clase es un servicio en Spring
@Service
public class UsersService {

    // Atributo para acceder al repositorio de usuarios
    private final UsersRepository usersRepository;

    // Constructor para inyectar la dependencia del repositorio de usuarios
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Método para registrar un nuevo usuario
    public UsersModel registerUsers(String login, String password, String email) {
        // Verificamos si login y password son nulos
        if(login == null && password == null){
            if(usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Dublicate login");
                return null;
            }
            // Devolvemos null si es así
            return null;
        }else{
            // Creamos un nuevo modelo de usuario
            UsersModel usersModel = new UsersModel();
            // Asignamos valores al modelo
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            // Guardamos el usuario en la base de datos y lo devolvemos
            return usersRepository.save(usersModel);
        }
    }

    // Método para autenticar a un usuario
    public UsersModel authenticate(String login, String password){
        // Buscamos el usuario en la base de datos y lo devolvemos, sino lo encontramos devolvemos null
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
