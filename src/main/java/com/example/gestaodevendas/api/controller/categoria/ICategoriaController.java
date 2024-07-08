package com.example.gestaodevendas.api.controller.categoria;

import com.example.gestaodevendas.api.controller.categoria.request.CategoriaRequest;
import com.example.gestaodevendas.api.controller.categoria.response.CategoriaResponse;
import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.exceptions.dto.ErroDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@Tag(name = "Categorias")
@RequestMapping(value = "/categorias")
@Validated
public interface ICategoriaController {

        @Operation(
                summary = "Criar Categoria",
                description = "Endpoint responsável por criar uma nova categoria",
                responses = {
                        @ApiResponse(
                                responseCode = "201",
                                description = "Categoria criada com sucesso.",
                                content = @Content(schema = @Schema(implementation = CategoriaResponse.class))),
                        @ApiResponse(
                                responseCode = "422",
                                description = "Requisição possui pelo menos um valor faltante ou inválido.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @PostMapping
        @ResponseStatus(CREATED)
        ResponseEntity<CategoriaResponse> create(@Valid @RequestBody CategoriaRequest request);

        @Operation(
                summary = "Buscar categoria por id",
                description = "Endpoint responsável por buscar uma categoria",
                responses = {
                        @ApiResponse(
                                responseCode = "200",
                                description = "Categoria encontrada com sucesso.",
                                content = @Content(schema = @Schema(implementation = CategoriaResponse.class))),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Categoria não encontrada.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @GetMapping("/{id}")
        @ResponseStatus(OK)
        ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Long id);

        @Operation(
                summary = "Deletar Categoria",
                description = "Endpoint responsável por deletar uma categoria",
                responses = {
                        @ApiResponse(
                                responseCode = "204",
                                description = "Categoria deletada com sucesso."
                        ),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Categoria não encontrada.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @DeleteMapping(value = "/{id}")
        @ResponseStatus(NO_CONTENT)
        ResponseEntity<Void> deletar(@PathVariable Long id);

//        @Operation(
//                summary = "Atualizar Cliente",
//                description = "Endpoint responsável por atualizar um cliente",
//                responses = {
//                        @ApiResponse(
//                                responseCode = "204",
//                                description = "Cliente atualizado com sucesso."
//                        ),
//                        @ApiResponse(
//                                responseCode = "404",
//                                description = "Cliente não encontrado.",
//                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
//                        @ApiResponse(
//                                responseCode = "500",
//                                description = "Ocorreu um erro inesperado.",
//                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
//                })
//        @PutMapping("/{id}")
//        @ResponseStatus(OK)
//        ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id,@RequestBody ClienteRequest request);

//        @Operation(
//                summary = "Consultar cardápio paginado",
//                description = "Endpoint responsável por buscar um cardápio paginado",
//                responses = {
//                        @ApiResponse(
//                                responseCode = "200",
//                                description = "Cardápio encontrado com sucesso.",
//                                content = @Content(schema = @Schema(implementation = CardapioResponse.class))),
//                        @ApiResponse(
//                                responseCode = "404",
//                                description = "Cardápio não encontrado.",
//                                content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
//                        @ApiResponse(
//                                responseCode = "500",
//                                description = "Ocorreu um erro inesperado.",
//                                content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
//                })
//        @GetMapping
//        @ResponseStatus(OK)
//        ResponseEntity<PageResponse<CardapioResponse>> findAllPaginated(
//                @ParameterObject @RequestParam(defaultValue = "0") @Min(0) int page,
//                @ParameterObject @RequestParam(defaultValue = "10") @Min(1) int size,
//                @RequestParam(required = false) String nome,
//                @RequestParam(required = false) Long idRestaurante,
//                @RequestParam(required = false) String nomeRestaurante);
//    }

}
