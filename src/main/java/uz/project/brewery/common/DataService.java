package uz.project.brewery.common;

import java.util.Set;

public interface DataService <T> {
    Set<T> getAll();
}
