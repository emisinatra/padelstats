package com.example.padelstatsv2.model;

import jakarta.persistence.*; // Importa la biblioteca Java Persistence API (JPA)
import java.util.Objects; // Importa la clase Objects para comparar objetos

@Entity // Indica que esta clase será una entidad de una base de datos
@Table(name= "users") // Indica que la tabla en la base de datos se llama "users"
public class UsersModel {

    @Id // Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor se generará automáticamente y será incremental
    Integer id;

    String login; // Atributo para almacenar el login de un usuario

    String password; // Atributo para almacenar la contraseña de un usuario

    String username; // Atributo para almacenar el nombre de usuario de un usuario

    String email; // Atributo para almacenar el correo electrónico de un usuario

    public Integer getId() { // Método para obtener el ID de un usuario
        return id;
    }

    public void setId(Integer id) { // Método para establecer el ID de un usuario
        this.id = id;
    }

    public String getLogin() { // Método para obtener el login de un usuario
        return login;
    }

    public void setLogin(String login) { // Método para establecer el login de un usuario
        this.login = login;
    }

    public String getPassword() { // Método para obtener la contraseña de un usuario
        return password;
    }

    public void setPassword(String password) { // Método para establecer la contraseña de un usuario
        this.password = password;
    }

    public String getUsername() { // Método para obtener el nombre de usuario de un usuario
        return username;
    }

    public void setUsername(String username) { // Método para establecer el nombre de usuario de un usuario
        this.username = username;
    }

    public String getEmail() { // Método para obtener el correo electrónico de un usuario
        return email;
    }

    public void setEmail(String email) { // Método para establecer el correo electrónico de un usuario
        this.email = email;
    }

    @Override
    public boolean equals(Object o) { // Método para comparar objetos de tipo UsersModel
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel userModel = (UsersModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(login, userModel.login) && Objects.equals(password, userModel.password) &&Objects.equals(username, userModel.username) && Objects.equals(email, userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, username, email);
    }

    @Override
    public String toString() { //Metodo toString informativo
        return "UserModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}