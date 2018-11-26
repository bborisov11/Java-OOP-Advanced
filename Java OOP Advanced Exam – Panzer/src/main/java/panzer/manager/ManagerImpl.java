package panzer.manager;

import panzer.contracts.*;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private final String PARTS_PATH = "panzer.models.parts.";
    private final String VEHICLE_PATH = "panzer.models.vehicles.";
    private Map<String, Vehicle> vehicles;
    private Map<String, Part> parts;
    private BattleOperator panzerBattleOperator;

    public ManagerImpl(BattleOperator panzerBattleOperator) {
        this.panzerBattleOperator = panzerBattleOperator;
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {

        String vehicleType = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defense = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));

        try {
            Class vehicleClass = Class.forName(this.VEHICLE_PATH + vehicleType);
            Constructor vehicleConstructor = vehicleClass.getConstructor(String.class, double.class,
                    BigDecimal.class, int.class, int.class, int.class, Assembler.class);
            Vehicle currentVehicle = (Vehicle) vehicleConstructor
                    .newInstance(model, weight, price, attack, defense, hitPoints, new VehicleAssembler());

            this.vehicles.putIfAbsent(model, currentVehicle);
            return String.format("Created %s Vehicle - %s", vehicleType, model);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return "Wrong vehicle Input";
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(0);
        String partType = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParameter = Integer.parseInt(arguments.get(5));

        Vehicle currentVehicle = this.vehicles.get(vehicleModel);

        try {
            Class currentPartClass = Class.forName(this.PARTS_PATH + partType + "Part");
            Constructor partConstructor = currentPartClass.getConstructor(String.class, double.class,
                    BigDecimal.class, int.class);
            Part currentPart = (Part) partConstructor.newInstance(model, weight, price, additionalParameter);
            if(partType.equals("Arsenal")) {
                currentVehicle.addArsenalPart(currentPart);
            } else if(partType.equals("Shell")) {
                currentVehicle.addShellPart(currentPart);
            } else {
                currentVehicle.addEndurancePart(currentPart);
            }
            this.parts.putIfAbsent(model, currentPart);
            return String.format("Added %s - %s to Vehicle - %s", partType, model, vehicleModel);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "Wrong part input";
    }

    @Override
    public String inspect(List<String> arguments) {
        String argument = arguments.get(0);

        if(this.vehicles.containsKey(argument)) {
            return this.vehicles.get(argument).toString();
        }
        return this.parts.get(argument).toString();
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle firstVehicle = this.vehicles.get(arguments.get(0));
        Vehicle secondVehicle = this.vehicles.get(arguments.get(1));

        return String.format("%s versus %s -> %s Wins! Flawless Victory!"
                ,firstVehicle.getModel(), secondVehicle.getModel()
                ,this.panzerBattleOperator.battle(firstVehicle, secondVehicle));
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder builder = new StringBuilder();
        builder.append("Remaining Vehicles: ")
                .append(this.vehicles.values().stream()
                        .filter(x -> x.getTotalHitPoints() > 0)
                                .collect(Collectors.toList()).size() > 0 ?
                        String.join(", ", this.vehicles.values().stream()
                        .filter(x -> x.getTotalHitPoints() > 0)
                        .map(Vehicle::getModel)
                .collect(Collectors.toList())) : "None").append(System.lineSeparator())
        .append("Defeated Vehicles: ").append(this.vehicles.values().stream()
                        .filter(x -> x.getTotalHitPoints() <= 0).collect(Collectors.toList()).size() > 0 ?
                String.join(", ", this.vehicles.values().stream()
                .filter(x -> x.getTotalHitPoints() <= 0)
                .map(Vehicle::getModel)
                .collect(Collectors.toList())) : "None").append(System.lineSeparator())
        .append("Currently Used Parts: ").append(this.vehicles.values().stream()
                .filter(x -> x.getTotalHitPoints() > 0)
                .mapToInt(x -> ((Collection<?>)x.getParts()).size()).sum());

        return builder.toString();
    }
}
