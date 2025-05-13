package com.agrocontrol.msvc_field.fields.interfaces.rest;

import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetAllWorkersByProducerId;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetFullnameByWorkerId;
import com.agrocontrol.msvc_field.fields.domain.services.WorkerCommandService;
import com.agrocontrol.msvc_field.fields.domain.services.WorkerQueryService;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.CreateWorkerResource;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.WorkerResource;
import com.agrocontrol.msvc_field.fields.interfaces.rest.transform.CreateWorkerFromWorkerResourceAssembler;
import com.agrocontrol.msvc_field.fields.interfaces.rest.transform.WorkerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/workers",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Workers",description = "Operations related to workers")
public class WorkersController {
    private final WorkerCommandService workerCommandService;
    private final WorkerQueryService workerQueryService;

    public WorkersController(WorkerCommandService workerCommandService, WorkerQueryService workerQueryService) {
        this.workerCommandService = workerCommandService;
        this.workerQueryService = workerQueryService;
    }

    @Operation(summary = "Create a worker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Worker Created"),
            @ApiResponse(responseCode = "400",description = "Invalid Input")
    })
    @PostMapping
    public ResponseEntity<WorkerResource> createWorker(@RequestBody CreateWorkerResource resource) {
        Optional<Worker> worker= this.workerCommandService
                .handle(CreateWorkerFromWorkerResourceAssembler.toCommandFromWorkerResource(resource));
        return worker.map(source->new ResponseEntity<>(WorkerResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
    @Operation(summary = "Get All by User ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Workers Founded"),
            @ApiResponse(responseCode = "400",description = "Workers not found")
    })
    @GetMapping("/{producerId}")
    public ResponseEntity<List<WorkerResource>> getWorkers(@PathVariable Long producerId ) {
        var query = new GetAllWorkersByProducerId(producerId);
        List<Worker> workers = this.workerQueryService
                .handle(query);

        if(workers.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<WorkerResource> workerResources = workers.stream()
                .map(WorkerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return new ResponseEntity<>(workerResources,CREATED);
    }

    /*
    @Operation(summary = "Delete a Worker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Worker Deleted"),
            @ApiResponse(responseCode = "400",description = "Worker not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<WorkerResource> deleteWorker(@PathVariable Long id,@RequestParam Long producerId) {
        DeleteWorkerCommand command = new DeleteWorkerCommand(id, producerId);
        this.workerCommandService.handle(command);
        return ResponseEntity.ok().build();

    } */
    @Operation(summary = "Get Full Name by Worker ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Full name found"),
            @ApiResponse(responseCode = "404", description = "Worker not found")
    })
    @GetMapping("/fullName/{workerId}")
    public ResponseEntity<String> getWorkerFullName(@PathVariable Long workerId) {
        var query = new GetFullnameByWorkerId(workerId);
        Optional<Worker> worker = this.workerQueryService.findFullNameById(query);

        return worker
                .map(value -> ResponseEntity.ok(value.getFullName()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
