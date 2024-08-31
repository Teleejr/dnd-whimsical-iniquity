package com.dnd.whimsical.iniquity.players;

import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;
import java.util.Objects;

@Entity
@Table
public class Players {

    @Id
    @SequenceGenerator(name = "players_sequence", sequenceName = "players_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_sequence")
    private Long id;
    private String name;
    private String charName;
    private String race;
    private String primaryClass;
    private String subclass;
    private int age;

    private int level;


    public Players() {
    }

    public Players(Long id, String name, String charName, String race, String primaryClass, String subclass, int age, int level) {
        this.id = id;
        this.name = name;
        this.charName = charName;
        this.race = race;
        this.primaryClass = primaryClass;
        this.subclass = subclass;
        this.age = age;
        this.level = level;
    }

    public Players(String name, String charName, String race, String primaryClass, String subclass, int age, int level) {
        this.name = name;
        this.charName = charName;
        this.race = race;
        this.primaryClass = primaryClass;
        this.subclass = subclass;
        this.age = age;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPrimaryClass() {
        return primaryClass;
    }

    public void setPrimaryClass(String primaryClass) {
        this.primaryClass = primaryClass;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "players{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", charName='" + charName + '\'' +
                ", race='" + race + '\'' +
                ", primaryClass='" + primaryClass + '\'' +
                ", subclass='" + subclass + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Players players = (Players) o;
        return id != null && Objects.equals(id, players.id);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
