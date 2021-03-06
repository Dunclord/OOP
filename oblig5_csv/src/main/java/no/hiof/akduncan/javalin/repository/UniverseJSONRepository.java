package no.hiof.akduncan.javalin.repository;

import no.hiof.akduncan.javalin.model.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniverseJSONRepository implements IUniverseRepository{

    static List<PlanetSystem> newList = fromJson("planets_4000.json");


    public static List<PlanetSystem> fromJson(String filename) {
        List<PlanetSystem> planetSystems = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            PlanetSystem[] systemArray = objectMapper.readValue(new File(filename), PlanetSystem[].class);

            planetSystems = Arrays.asList(systemArray);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return planetSystems;
    }

    public static void saveToJson(String filename, List<PlanetSystem> planetSystems) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, newList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<PlanetSystem> getPlanetSystems() {
        return newList;
    }

    @Override
    public PlanetSystem getAPlanetSystem(String name) {

        for (PlanetSystem planetSystem : newList) {
            if (planetSystem.getName().equals(name))
                return planetSystem;
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getAllPlanets(String name) {
        PlanetSystem relevantSystem = getAPlanetSystem(name);

        if(relevantSystem != null) {
            return relevantSystem.getPlanets();
        }
        return new ArrayList<>();

    }


    @Override
    public Planet getAPlanet(String systemName, String planetName) {
        PlanetSystem aSystem = getAPlanetSystem(systemName);

        if (aSystem != null) {
            for(Planet aPlanet: aSystem.getPlanets()) {
                if (aPlanet.getName().equals(planetName))
                    return aPlanet;
            }
        }
        return null;
    }

}

 */


