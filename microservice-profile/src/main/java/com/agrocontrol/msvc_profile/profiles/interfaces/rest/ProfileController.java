package com.agrocontrol.msvc_profile.profiles.interfaces.rest;

import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetAgriculturalProducerByUserIdAsyncQuery;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetDistributorByUserIdAsyncQuery;
import com.agrocontrol.msvc_profile.profiles.domain.services.AgriculturalProducerCommandService;
import com.agrocontrol.msvc_profile.profiles.domain.services.AgriculturalProducerQueryService;
import com.agrocontrol.msvc_profile.profiles.domain.services.DistributorCommandService;
import com.agrocontrol.msvc_profile.profiles.domain.services.DistributorQueryService;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.AgriculturalProducerResource;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.CreateAgriculturalProducerResource;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.CreateDistributorResource;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.DistributorResource;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform.AgriculturalProducerResourceFromEntityAssembler;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform.CreateAgriculturalProducerCommandFromResourceAssembler;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform.CreateDistributorCommandFromResourceAssembler;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform.DistributorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profiles Management Endpoints")
public class ProfileController {
    private final AgriculturalProducerQueryService agriculturalProducerQueryService;
    private final DistributorQueryService distributorQueryService;
    private final AgriculturalProducerCommandService agriculturalProducerCommandService;
    private final DistributorCommandService distributorCommandService;

    public ProfileController(AgriculturalProducerQueryService agriculturalProducerQueryService,
                             DistributorQueryService distributorQueryService,
                             AgriculturalProducerCommandService agriculturalProducerCommandService,
                             DistributorCommandService distributorCommandService) {
        this.agriculturalProducerQueryService = agriculturalProducerQueryService;
        this.distributorQueryService = distributorQueryService;
        this.agriculturalProducerCommandService = agriculturalProducerCommandService;
        this.distributorCommandService = distributorCommandService;
    }

    @Operation(summary = "Get agricultural producer by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Agricultural Producer found"),
            @ApiResponse(responseCode = "404",description = "Agricultural Producer not found")
    })
    @GetMapping(value = "/agricultural-producer/{userId}")
    public ResponseEntity<AgriculturalProducerResource> getAgriculturalProducer(@PathVariable Long userId) {
        var getAgriculturalProducerByUserIdQuery = new GetAgriculturalProducerByUserIdAsyncQuery(userId);
        var agriculturalProducer = agriculturalProducerQueryService.handle(getAgriculturalProducerByUserIdQuery);
        if (agriculturalProducer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var agriculturalProducerResource = AgriculturalProducerResourceFromEntityAssembler
                .toResourceFromEntity(agriculturalProducer.get());

        return ResponseEntity.ok(agriculturalProducerResource);
    }

    @Operation(summary = "Get distributor by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Distributor found"),
            @ApiResponse(responseCode = "404",description = "Distributor not found")
    })
    @GetMapping(value = "/distributor/{userId}")
    public ResponseEntity<DistributorResource> getDistributor(@PathVariable Long userId) {
        var getDistributorByUserIdQuery = new GetDistributorByUserIdAsyncQuery(userId);
        var distributor = distributorQueryService.handle(getDistributorByUserIdQuery);
        if (distributor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var distributorResource = DistributorResourceFromEntityAssembler.toResourceFromEntity(distributor.get());

        return ResponseEntity.ok(distributorResource);
    }

    @Operation(summary = "Create Agricultural Producer by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Agricultural Producer Created"),
            @ApiResponse(responseCode = "400",description = "Invalid Input")
    })
    @PostMapping(value = "/agricultural-producer/{userId}")
    public ResponseEntity<Long> createAgriculturalProducer(
            @PathVariable Long userId,
            @RequestBody CreateAgriculturalProducerResource createAgriculturalProducerResource
    ){
        var createAgriculturalProducer = CreateAgriculturalProducerCommandFromResourceAssembler.toCommandFromResource(createAgriculturalProducerResource);
        var agriculturalProducer = agriculturalProducerCommandService.handle(createAgriculturalProducer, userId);
        if (agriculturalProducer.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        // Retornar el ID del aggregate recién creado
        var agriculturalProducerId = agriculturalProducer.get().getId();
        return new ResponseEntity<>(agriculturalProducerId, HttpStatus.CREATED);
    }


    @Operation(summary = "Create Distributor by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Distributor Created"),
            @ApiResponse(responseCode = "400",description = "Invalid Input")
    })
    @PostMapping(value = "/distributor/{userId}")
    public ResponseEntity<Long> createDistributor(
            @PathVariable Long userId,
            @RequestBody CreateDistributorResource createDistributorResource
    ){
        var createDistributor = CreateDistributorCommandFromResourceAssembler.toCommandFromResource(createDistributorResource);
        var distributor = distributorCommandService.handle(createDistributor, userId);
        if (distributor.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var distributorId = distributor.get().getId();
        return new ResponseEntity<>(distributorId, HttpStatus.CREATED);
    }

    @Operation(summary = "Check if Agricultural Producer exists by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check completed")
    })
    @GetMapping(value = "/agricultural-producer/exists/{userId}")
    public ResponseEntity<Boolean> existsAgriculturalProducer(@PathVariable Long userId) {
        var query = new GetAgriculturalProducerByUserIdAsyncQuery(userId);
        boolean exists = agriculturalProducerQueryService.handle(query).isPresent();
        return ResponseEntity.ok(exists);
    }

    @Operation(summary = "Check if Distributor exists by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check completed")
    })
    @GetMapping(value = "/distributor/exists/{userId}")
    public ResponseEntity<Boolean> existsDistributor(@PathVariable Long userId) {
        var query = new GetDistributorByUserIdAsyncQuery(userId);
        boolean exists = distributorQueryService.handle(query).isPresent();
        return ResponseEntity.ok(exists);
    }
}
