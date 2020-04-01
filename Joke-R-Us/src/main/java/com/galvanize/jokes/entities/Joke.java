package com.galvanize.jokes.entities;


import jdk.jfr.events.CertificateId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import sun.jvm.hotspot.debugger.cdbg.EnumType;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "jokes")
public class Joke {
    @Id
    @Generated(strategy = GenerationType.IDENTITY)
    Long jokeId;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    Category category;
    String Joke() {}

    public Joke(Long jokeId, Category category, String joke){
        this.jokeId = jokeId;
        this.category = category;
        this.joke = joke;
    }

    public Joke(Category category, String joke){
        this.category = category;
        this.joke = joke;
    }

    @Override
    public String toString() {
        return "Joke{" + "jokeId=" + jokeId + " cetegory=" + category
                + ", joke=" + joke + '\'' + '}';
    }
}
