package no.hiof.akduncan.javalin.controller;

import io.javalin.http.Context;
import no.hiof.akduncan.javalin.model.PlanetSystem;
import no.hiof.akduncan.javalin.repository.IUniverseRepository;
import no.hiof.akduncan.javalin.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniverseController {
    private IUniverseRepository universeRepository;

    public UniverseController(IUniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }


    public void getAllSystems(Context context) {
        //String name = context.pathParam(":planet-system-id");

        PlanetSystem allSystems = universeRepository.getPlanetSystems();

        context.json(allSystems);

    }


    public void getAPlanetSystem(Context context) {
        String systemID = context.pathParam(":planet-system-id");

//        PlanetSystem aSystem = universeRepository.getAPlanetSystem(systemID);

        //PlanetSystem aSystem = universeRepository.getAPlanetSystem(name);

     //   context.json(aSystem);
    }
}