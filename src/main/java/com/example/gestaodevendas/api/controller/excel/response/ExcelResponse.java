package com.example.gestaodevendas.api.controller.excel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelResponse {

    Long idExcel;
    List<String> nomes;
    String mensagem;

}
