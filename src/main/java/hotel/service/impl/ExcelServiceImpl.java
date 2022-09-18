package hotel.service.impl;

import hotel.dto.RoomsDto;
import hotel.entity.Rooms;
import hotel.repository.RoomsRepository;
import hotel.service.ExcelService;
import hotel.service.mapper.RoomsMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    private final RoomsRepository repository;

    public ExcelServiceImpl(RoomsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void exportAllRooms() {
        List<Rooms> roomsList = repository.findAll();
        List<RoomsDto> roomsDtoList = roomsList.stream()
                .map(RoomsMapper::toDto)
                .toList();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("№");
        row0.createCell(1).setCellValue("Категория комнаты");

        for (RoomsDto room: roomsDtoList){
            Row row = sheet.createRow(sheet.getLastRowNum());
        }
    }
}
