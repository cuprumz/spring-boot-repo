package io.github.cuprumz.web;

import io.github.cuprumz.mapper.ShapeMapper;
import io.github.cuprumz.pojo.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cuprumz
 * @date 2018/08/08
 */
@RestController
public class ShapeController {

    @Autowired
    private ShapeMapper shapeMapper;

    @RequestMapping("/getshapes")
    public List<Shape> getUserLists() {
        return shapeMapper.getAll();
    }

    @RequestMapping("/getshape/{id}")
    public Shape getUser(@PathVariable Long id) {
        return shapeMapper.getShapeByID(id);
    }

    @RequestMapping("/add")
    public void save(Shape shape) {
        shapeMapper.insert(shape);
    }

    @RequestMapping("/update")
    public void update(Shape shape) {
        shapeMapper.update(shape);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        shapeMapper.deleteByID(id);
    }
}
