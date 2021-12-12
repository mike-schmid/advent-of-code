package adventofcode2021.day11;

import java.util.ArrayList;
import java.util.List;

public class Octopus {

    int energyLevel;
    boolean flashed = false;
    List<Octopus> neighbours = new ArrayList<>();

    public Octopus(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void addNeighbour(Octopus neighbour) {
        neighbours.add(neighbour);
    }

    public void updateFlashes() {
        if (flashed) {
            return;
        }

        energyLevel += 1;
        if (energyLevel > 9) {
            energyLevel = 0;
            flashed = true;
            neighbours.forEach(Octopus::updateFlashes);
        }
    }

    public void resetFlash() {
        flashed = false;
    }

    public boolean hasFlashed() {
        return flashed;
    }

}
