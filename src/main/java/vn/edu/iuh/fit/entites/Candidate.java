package vn.edu.iuh.fit.entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @Column(name = "can_id")
    private long id;
    private String fullName;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    public Candidate() {
    }

    public Candidate(long id, String fullName, String phone, String email, List<Experience> experiences) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.experiences = experiences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}
