package com.fairychar.bag.domain.validator.rest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件大小范围校验器
 *
 * @author chiyo
 * @since 1.3.2
 */
public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

    private FileSize.Unit unit;
    private long min;
    private long max;


    @Override
    public void initialize(FileSize fileSize) {
        ConstraintValidator.super.initialize(fileSize);
        this.unit = fileSize.unit();
        this.min = fileSize.min();
        this.max = fileSize.max();
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        long bytes = value.getSize();
        if (min * unit.getSize() <= bytes && bytes <= max * unit.getSize()) {
            return true;
        }
        return false;
    }

}
