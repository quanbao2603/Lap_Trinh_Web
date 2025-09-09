package entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "role")
    private int role;

    @OneToMany
    @JoinColumn(name = "role", referencedColumnName = "role", insertable = false, updatable = false)
    private List<Category> categories;

    public Users() {}

    public Users(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getRole() { return role; }
    public void setRole(int role) { this.role = role; }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
}