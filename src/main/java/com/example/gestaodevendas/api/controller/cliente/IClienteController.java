package com.example.gestaodevendas.api.controller.cliente;

import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.entity.Cliente;
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
@Tag(name = "Clientes")
@RequestMapping(value = "/clientes")
@Validated
public interface IClienteController {

        @Operation(
                summary = "Criar Cliente",
                description = "Endpoint responsável por criar um novo cliente",
                responses = {
                        @ApiResponse(
                                responseCode = "201",
                                description = "Cliente criado com sucesso.",
                                content = @Content(schema = @Schema(implementation = ClienteResponse.class))),
                        @ApiResponse(
                                responseCode = "422",
                                description = "Requisição possui pelo menos um valor faltante ou inválido.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @PostMapping(consumes = "application/json", produces = "application/json")
        @ResponseStatus(CREATED)
        ResponseEntity<ClienteResponse> create(@Valid @RequestBody ClienteRequest clienteRequest);

        @Operation(
                summary = "Buscar cliente por id",
                description = "Endpoint responsável por buscar um cliente",
                responses = {
                        @ApiResponse(
                                responseCode = "200",
                                description = "Cliente encontrado com sucesso.",
                                content = @Content(schema = @Schema(implementation = ClienteResponse.class))),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Cliente não encontrado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @GetMapping("/{id}")
        @ResponseStatus(OK)
        ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id);

        @Operation(
                summary = "Deletar Cliente",
                description = "Endpoint responsável por deletar um cliente",
                responses = {
                        @ApiResponse(
                                responseCode = "204",
                                description = "Cliente deletado com sucesso."
                        ),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Cliente não encontrado.",
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
//        ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id,@RequestBody Cliente clienteNovo);
//
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
