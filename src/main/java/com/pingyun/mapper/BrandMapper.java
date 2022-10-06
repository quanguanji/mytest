package com.pingyun.mapper;

import com.pingyun.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    @Insert("insert into tb_brand values(null, #{brandName}, #{companyName}, #{ordered}, " +
            "#{description}, #{status})")
    void addBrand(Brand brand);
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(Integer id);
    void updateBrand(Brand brand);
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(Integer id);
}
