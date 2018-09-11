package io.github.cuprumz.mapper;

import io.github.cuprumz.pojo.Shape;

import java.util.List;

/**
 * @author cuprum
 * @date 2018/08/07
 */
public interface ShapeMapper {

    void deleteByID(Long id);

    void update(Shape shape);

    void insert(Shape shape);

    Shape getShapeByID(Long id);

    List<Shape> getAll();
}
