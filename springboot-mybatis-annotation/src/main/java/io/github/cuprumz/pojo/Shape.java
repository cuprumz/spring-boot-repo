package io.github.cuprumz.pojo;

import io.github.cuprumz.enums.ShapeName;

import java.io.Serializable;

/**
 * @author cuprum
 * @date 2018/08/07
 */

/**
 DROP TABLE IF EXISTS `shape`;
 CREATE TABLE `shape` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `shape_name` varchar(32) DEFAULT NULL,
 `area` float DEFAULT NULL COMMENT '面积',
 `perimeter` float DEFAULT NULL COMMENT '周长',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
 */
public class Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private ShapeName shapeName;
    private Float area;
    private Float perimeter;

    public Shape() {
        super();
    }

    public Shape(ShapeName shapeName, Float area, Float perimeter) {
        this.shapeName = shapeName;
        this.area = area;
        this.perimeter = perimeter;
    }

    @Override
    public String toString() {
        return "Shape{" +
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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Float perimeter) {
        this.perimeter = perimeter;
    }
}
