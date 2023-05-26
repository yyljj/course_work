package com.whut.reggie.dto;


import com.whut.reggie.pojo.Setmeal;
import com.whut.reggie.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
