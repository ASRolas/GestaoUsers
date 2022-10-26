/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaousers.controller;

import gestaousers.model.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rolas
 */
public class UserController {
    public static void registar(User u) {
        List<User> users = listar();
        users.add(u);
        persistir(users);
    }
    
    public static List<User> listar() {
        List<User> users = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("users.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            users = (List<User>) objectInputStream.readObject();
                
            fileInputStream.close();
            objectInputStream.close();
//        }catch(EOFException e){
//            return LISTA_USUARIOS;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return users;
    }
    
    public static void persistir(List<User> users){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("users.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(users);
            
            fileOutputStream.flush();
            fileOutputStream.close();
            
            objectOutputStream.flush();
            objectOutputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace( );
        }
    }
    
    public static void remover(String id) {
        List<User> users = listar();
        for (User u : users) {
            if (u.getId().equals(id)) {
                users.remove(u);
                persistir(users);
                break;
            }
        }
    }
    
    public static void alterar(String id, User user) {
        List<User> users = listar();
        for (User u : users) {
            if (u.getId().equals(id)) {
                u.setNome(user.getNome());
                u.setApelido(user.getApelido());
                u.setNomeUsuaro(user.getNomeUsuaro());
                u.setEmail(user.getEmail());
                u.setTelefone(user.getTelefone());
                u.setBiografia(user.getBiografia());
                u.setSenha(user.getSenha());
                persistir(users);
            }
        }
    }
    
    public static boolean autentica(User u) {
        List<User> users = listar();
        boolean autentica = users.stream().anyMatch(p -> (p.getNomeUsuaro().equals(u.getNomeUsuaro()) && p.getSenha().equals(u.getSenha())));
        return autentica;
    }
    
    public static void main(String[] args) {
//        registar(new User("Josefina","Alex","ja@mail","8999","josenax","bbbb","senha"));
        System.out.println(listar());
        remover("2c2f20fb-7d32-42af-a0b7-eb1ec4465544");
//        alterar("5580eec0-fa3c-4466-88bf-24a5fcb691c1", new User("anita", "paulitaa", "ap@mail", "8998", "anapaula", "bbbb", "senha"));
        System.out.println(listar());
    }
    
}