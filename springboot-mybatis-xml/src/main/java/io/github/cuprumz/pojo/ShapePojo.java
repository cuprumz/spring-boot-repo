package io.github.cuprumz.pojo;

import io.github.cuprumz.enums.ShapeName;

import java.io.Serializable;

/**
 * @author cuprum
 * @date 2018/08/07
 */

public class ShapePojo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private ShapeName shapeName;
    private Long area;
    private Long perimeter;

    @Override
    public String toString() {
        return "ShapePojo{" +
                "id=" + id +
                ", shapeName=" + shapeName +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShapeName getShapeName() {
        return shapeName;
    }

    public void setShapeName(ShapeName shapeName) {
        this.shapeName = shapeName;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Long perimeter) {
        this.perimeter = perimeter;
    }
}
