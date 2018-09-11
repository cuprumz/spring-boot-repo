package io.github.cuprumz.mapper;

import io.github.cuprumz.pojo.Shape;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author cuprum
 * @date 2018/08/07
 */
public interface ShapeMapper {

    @Delete("delete from shape where id = #{id}")
    void deleteByID(Long id);

    @Update("update shape set shape_name=#{shapeName}, area=#{area}, perimeter=#{perimeter}")
    void update(Shape shape);

    @Insert("insert into shape(shape_name, area, perimeter) values(#{shapeName}, #{area}, #{perimeter})")
    void insert(Shape shape);

    @Select("select id, shape_name shapeName, area, perimeter from shape where id = #{id}")
    Shape getShapeByID(Long id);

    @Select("select id, shape_name shapeName, area, perimeter from shape")
    List<Shape> getAll();
}
