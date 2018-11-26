package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseVehicle implements Vehicle{
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private long hitPoints;
    private Assembler vehicleAssembler;
    private Map<String,Part> parts;

    protected BaseVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints, Assembler vehicleAssembler) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.vehicleAssembler = vehicleAssembler;
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.vehicleAssembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.vehicleAssembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack + this.vehicleAssembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense + this.vehicleAssembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.vehicleAssembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.vehicleAssembler.addArsenalPart(arsenalPart);
        this.parts.putIfAbsent(arsenalPart.getModel(),arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.vehicleAssembler.addShellPart(shellPart);
        this.parts.putIfAbsent(shellPart.getModel(),shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
        this.parts.putIfAbsent(endurancePart.getModel(),endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts.values();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s - %s"
                ,this.getClass().getSimpleName(), this.getModel())).append(System.lineSeparator())
                .append(String.format("Total Weight: %.3f",
                        this.getTotalWeight())).append(System.lineSeparator())
                .append(String.format("Total Price: %.3f",
                        this.getTotalPrice())).append(System.lineSeparator())
                .append(String.format("Attack: %s", this.getTotalAttack())).append(System.lineSeparator())
                .append(String.format("Defense: %s", this.getTotalDefense())).append(System.lineSeparator())
                .append(String.format("HitPoints: %s",
                        this.getTotalHitPoints())).append(System.lineSeparator())
                .append("Parts: ")
                .append(this.parts.size() != 0 ? String.join(", ",
                        this.parts.values().stream().map(Part::getModel).collect(Collectors.toList())) :
                "None");

        return builder.toString();
    }
}
