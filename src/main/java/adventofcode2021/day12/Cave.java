package adventofcode2021.day12;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.hash;

public class Cave {

    final String name;
    final List<Cave> tunnels = new ArrayList<>();

    public Cave(String name) {
        this.name = name;
    }

    public void addTunnelTo(Cave cave) {
        if (!"end".equals(name)) {
            tunnels.add(cave);
        }
    }

    public String getName() {
        return name;
    }

    public List<Cave> getTunnels() {
        return tunnels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return name.equals(cave.name);
    }

    @Override
    public int hashCode() {
        return hash(name);
    }

    @Override
    public String toString() {
        return "Cave{" +
                "name='" + name + '\'' +
                '}';
    }
}
