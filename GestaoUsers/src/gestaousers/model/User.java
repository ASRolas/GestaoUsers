/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaousers.model;

import java.io.Serializable;
import java.util.UUID;
import org.w3c.dom.Text;

/**
 *
 * @author rolas
 */
public class User implements Serializable{
    
    private String id;
    private String nome;
    private String apelido;
    private String email;
    private String telefone;
    private String nomeUsuaro;
    private String biografia;
    private String senha;

    public User(String nome, String apelido, String email, String telefone, String nomeUsuaro, String biografia, String senha) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.nomeUsuaro = nomeUsuaro;
        this.biografia = biografia;
        this.senha = senha;
    }

    public User(String nomeUsuaro, String senha) {
        this.nomeUsuaro = nomeUsuaro;
        this.senha = senha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", apelido=").append(apelido);
        sb.append(", email=").append(email);
        sb.append(", telefone=").append(telefone);
        sb.append(", nomeUsuaro=").append(nomeUsuaro);
        sb.append(", biografia=").append(biografia);
        sb.append(", senha=").append(senha);
        sb.append("}\n");
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        return "User{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", email=" + email + ", telefone=" + telefone + ", nomeUsuaro=" + nomeUsuaro + ", biografia=" + biografia + ", senha=" + senha + "}\n";
//    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeUsuaro() {
        return nomeUsuaro;
    }

    public void setNomeUsuaro(String nomeUsuaro) {
        this.nomeUsuaro = nomeUsuaro;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
