package vn.edu.iuh.fit.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")

public class Experience {
    @Column(name = "exp_id")
    @Id
    private long id;
    private LocalDate fromDate;
    private  LocalDate toDate;
    private String workDescription;
    @Column(name = "company", columnDefinition = "varchar(120)")
    private String companyName;
    @Enumerated(EnumType.ORDINAL)
    private Role roles;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience() {
    }

    public Experience(long id, LocalDate fromDate, LocalDate toDate, String workDescription, String companyName, Role roles, Candidate candidate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.workDescription = workDescription;
        this.companyName = companyName;
        this.roles = roles;
        this.candidate = candidate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", workDescription='" + workDescription + '\'' +
                ", companyName='" + companyName + '\'' +
                ", roles=" + roles +
                ", candidate=" + candidate +
                '}';
    }
}
