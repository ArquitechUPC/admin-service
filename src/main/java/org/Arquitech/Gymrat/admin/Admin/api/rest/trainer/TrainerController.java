package org.Arquitech.Gymrat.admin.Admin.api.rest.trainer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.Arquitech.Gymrat.admin.Admin.domain.trainer.model.entity.Trainer;
import org.Arquitech.Gymrat.admin.Admin.domain.trainer.service.TrainerService;
import org.Arquitech.Gymrat.admin.Admin.mapping.trainer.TrainerMapper;
import org.Arquitech.Gymrat.admin.Admin.resource.trainer.CreateTrainerResource;
import org.Arquitech.Gymrat.admin.Admin.resource.trainer.TrainerResource;
import org.Arquitech.Gymrat.admin.Admin.resource.trainer.UpdateTrainerResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Trainers", description = "Create, Read, Update and delete trainers entities")
@RestController
@RequestMapping("api/v1/trainers")
@AllArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;
    private final TrainerMapper mapper;

    @Operation(summary = "Get all registered trainers", responses = {
            @ApiResponse(description = "Successfully fetched all trainers",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @GetMapping
    public List<Trainer> fetchAll() {
        return trainerService.fetchAll();
    }

    @Operation(summary = "Get a trainer by id", responses = {
            @ApiResponse(description = "Successfully fetched trainer by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @GetMapping("{id}")
    public TrainerResource fetchById(@PathVariable Integer id) {
        return this.mapper.toResource(trainerService.fetchById(id).get());
    }

    @Operation(summary = "Save a trainer", responses = {
            @ApiResponse(description = "Trainer successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @PostMapping
    public TrainerResource save(@RequestBody CreateTrainerResource resource) {
        return this.mapper.toResource(trainerService.save(this.mapper.toModel(resource)));
    }

    @Operation(summary = "Update a trainer by id", responses = {
            @ApiResponse(description = "Trainer successfully updated",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @PutMapping("{id}")
    public ResponseEntity<TrainerResource> update(@PathVariable Integer id, @RequestBody UpdateTrainerResource resource) {
        if(id.equals(resource.getId())) {
            TrainerResource trainerResource = mapper.toResource(
                    trainerService.update(mapper.toModel(resource))
            );
            return new ResponseEntity<>(trainerResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete a trainer by id", responses = {
            @ApiResponse(description = "Successfully deleted trainer by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if(trainerService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
