package dev.isez.departmentservice.service.impl;

import dev.isez.departmentservice.dto.DepartmentDto;
import dev.isez.departmentservice.entity.Department;
import dev.isez.departmentservice.exception.ResourceNotFoundException;
import dev.isez.departmentservice.mapper.DepartmentMapper;
import dev.isez.departmentservice.repository.DepartmentRepository;
import dev.isez.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department", "department code", departmentCode)
        );

        DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);

        return departmentDto;
    }
}
