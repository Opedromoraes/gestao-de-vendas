package com.example.gestaodevendas.service;

import com.example.gestaodevendas.api.controller.excel.request.ExcelRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExcelService {

    private static final String fileName = "C:/testePlanilha/novoExcel.xls";
//    private ExcelRepository repository;

    public String gerarExcel(ExcelRequest request) {

        log.info("Criando planilha");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nomes");

        int numeroDaLinha = 0;
        for (String nome : request.getNomes()) {
            Row row = sheet.createRow(numeroDaLinha++);
            row.createCell(0).setCellValue(nome);
        }

        try {
            log.info("Acessando diretório");
            FileOutputStream out = new FileOutputStream(fileName);
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            log.error("Arquivo não encontrado!" + ex.getMessage());
        } catch (IOException ex) {
            log.error("Erro na edição do arquivo!" + ex.getMessage());
        }

        return "Planilha criada: " + fileName;
    }

    public List<String> lerExcel(String file) {
        List<String> list = new ArrayList<>();
        try {
            Workbook workbook = getWorkbookFromFile(file);
            Sheet sheet = workbook.getSheetAt(0);
            //Criando objeto do tipo Sheet que vai representar o workbook

            for (Row row : sheet) {
                // Para cada linha dentro do excel faça:
                for (Cell cell : row) {
                    // Para cada célula dentro da linha faça:
                    list.add(cell.toString());
                    // Passando a célula pra String e adicionando ela na lista
                }
            }

            workbook.close();
            // fechando o arquivo.

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Workbook getWorkbookFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return WorkbookFactory.create(fileInputStream);
            // estou passando o caminho do arquivo por uma String (o caminho que vou colocar no swagger)
            // Criando um objeto do tipo File, que vai representar esse caminho
            // FileInputStream vai ler o arquivo de acordo com o caminho que passei
            // Cria um objeto Woorkbook(um arquivo) através do FileInputStream para retornar ele no método "lerExcel"
        }
    }
}
