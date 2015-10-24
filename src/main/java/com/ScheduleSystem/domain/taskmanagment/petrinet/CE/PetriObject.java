package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;
import java.util.UUID;

/**
 * Created by SG0222895 on 10/3/2015.
 */
@Data
public abstract class PetriObject {
    protected Long id;
    protected String name;
    public String SHA256Code;

    public PetriObject() {
        SHA256Code = UUID.randomUUID().toString();
    }

    public PetriObject(String name) {
        this();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetriObject that = (PetriObject) o;

        return SHA256Code.equals(that.SHA256Code);
    }

    @Override
    public int hashCode() {
        return SHA256Code.hashCode();
    }
}
