package com.example.padelstatsv2.controller;

import com.example.padelstatsv2.model.UsersModel;
import com.example.padelstatsv2.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {


    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
/*Este método maneja las solicitudes GET a la URL "/register".
El parámetro Model model es un objeto de tipo Model de Spring que se utiliza para agregar atributos al modelo
y, posteriormente, pasarlos a la vista.
Se agrega un atributo al modelo llamado "registerRequest" con una nueva instancia de UsersModel.
Finalmente, se devuelve el nombre de la vista "register_page".*/
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
     return "register_page";
    }
    /*Este método maneja las solicitudes GET a la URL "/login".
El parámetro Model model es un objeto de tipo Model de Spring que se utiliza para agregar atributos al modelo
y, posteriormente, pasarlos a la vista.
Se agrega un atributo al modelo llamado "loginRequest" con una nueva instancia de UsersModel.
Finalmente, se devuelve el nombre de la vista "login_page".*/
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }
    /*Este método maneja las solicitudes POST a la URL "/register".
El parámetro @ModelAttribute UsersModel usersModel es un objeto de tipo UsersModel
que contiene los datos enviados en la solicitud. La anotación @ModelAttribute indica que los datos enviados en la solicitud
deben ser asignados a un objeto de tipo UsersModel.
Se imprime en la consola un mensaje con los detalles del objeto usersModel.
Luego, se llama al método registerUsers del objeto usersService con los valores de login, password y correo electrónico
extraídos del objeto usersModel. Este método registra un nuevo usuario.
Si el usuario registrado es nulo, se devuelve el nombre de la vista "error_page".
De lo contrario, se devuelve una redirección a la página de inicio de sesión con la URL "/login".*/
    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
        System.out.println("Register request: "+ usersModel);
        UsersModel registeredUser = usersService.registerUsers(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel){
        System.out.println("Register request: "+ usersModel);
        UsersModel authenticated = usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if(authenticated != null){
           return "personal_page";
        }else{
            return "error_page";
        }
    }

}
