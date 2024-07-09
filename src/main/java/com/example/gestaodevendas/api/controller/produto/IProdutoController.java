package com.example.gestaodevendas.api.controller.produto;

import com.example.gestaodevendas.api.controller.produto.request.ProdutoRequest;
import com.example.gestaodevendas.api.controller.produto.response.ProdutoResponse;
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
@Tag(name = "Produtos")
@RequestMapping(value = "/produtos")
@Validated
public interface IProdutoController {

        @Operation(
                summary = "Criar Produto",
                description = "Endpoint responsável por salvar um novo produto",
                responses = {
                        @ApiResponse(
                                responseCode = "201",
                                description = "Produto criado com sucesso.",
                                content = @Content(schema = @Schema(implementation = ProdutoResponse.class))),
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
        ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest request);

        @Operation(
                summary = "Buscar produto por id",
                description = "Endpoint responsável por buscar um produto",
                responses = {
                        @ApiResponse(
                                responseCode = "200",
                                description = "Produto encontrado com sucesso.",
                                content = @Content(schema = @Schema(implementation = ProdutoResponse.class))),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Produto não encontrado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @GetMapping("/{id}")
        @ResponseStatus(OK)
        ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id);

        @Operation(
                summary = "Atualizar Produto",
                description = "Endpoint responsável por atualizar um produto",
                responses = {
                        @ApiResponse(
                                responseCode = "204",
                                description = "Produto atualizado com sucesso."
                        ),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Produto não encontrado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class))),
                        @ApiResponse(
                                responseCode = "500",
                                description = "Ocorreu um erro inesperado.",
                                content = @Content(schema = @Schema(implementation = ErroDTO.class)))
                })
        @PutMapping("/{id}")
        @ResponseStatus(OK)
        ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequest request);

        @Operation(
                summary = "Deletar Produto",
                description = "Endpoint responsável por deletar um produto",
                responses = {
                        @ApiResponse(
                                responseCode = "204",
                                description = "Produto deletado com sucesso."
                        ),
                        @ApiResponse(
                                responseCode = "404",
                                description = "Produto não encontrado.",
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
