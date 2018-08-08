package io.github.cuprumz.mapper;

import io.github.cuprumz.enums.ShapeName;
import io.github.cuprumz.pojo.Shape;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author cuprumz
 * @date 2018/08/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShapeMapperTest {

    @Autowired
    private ShapeMapper shapeMapper;

    @Test
    public void testInsert() throws Exception {
        shapeMapper.insert(new Shape(ShapeName.OVAL, 1.1f, 1.1f));
        shapeMapper.insert(new Shape(ShapeName.RECTANGLE, 1.1f, 1.1f));
        shapeMapper.insert(new Shape(ShapeName.TRIANGLE, 1.1f, 1.1f));
        shapeMapper.insert(new Shape(ShapeName.ROUND, 1.1f, 1.1f));
    }

    @Test
    public void testQuery() throws Exception {
        List<Shape> users = shapeMapper.getAll();
        if(users==null || users.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(users.toString());
        }
    }
}
