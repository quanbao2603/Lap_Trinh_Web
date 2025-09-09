package entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int role;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String categoryname;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "role", insertable = false, updatable = false)
    private Users user;

    public Category() {}

    public Category(int role, String categoryname) {
        this.role = role;
        this.categoryname = categoryname;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRole() { return role; }
    public void setRole(int role) { this.role = role; }

    public String getCategoryname() { return categoryname; }
    public void setCategoryname(String categoryname) { this.categoryname = categoryname; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
}